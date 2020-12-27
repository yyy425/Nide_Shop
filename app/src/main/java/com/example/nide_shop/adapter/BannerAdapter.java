package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends DelegateAdapter.Adapter<BannerAdapter.ViewHolder> {

    private List<HomeBean.DataBean.BannerBean> banner=new ArrayList<>();
    private LinearLayoutHelper LinearLayoutHelper;

    public BannerAdapter(LinearLayoutHelper linearLayoutHelper) {
        this.LinearLayoutHelper=linearLayoutHelper;
    }

    public void getBannerData(List<HomeBean.DataBean.BannerBean> banner){
        banner.addAll(banner);
        notifyDataSetChanged();;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LinearLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.banner.setImages(banner).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean bannerBean= (HomeBean.DataBean.BannerBean) path;
                Glide.with(context).load(bannerBean.getImage_url()).into(imageView);
            }
        }).start();
    }

    @Override
    public int getItemCount() {
        return banner.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner=itemView.findViewById(R.id.banner_img);
        }
    }
}
