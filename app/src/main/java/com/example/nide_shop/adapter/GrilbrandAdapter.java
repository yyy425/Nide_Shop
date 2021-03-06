package com.example.nide_shop.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.List;

public class GrilbrandAdapter extends DelegateAdapter.Adapter {
    private List<HomeBean.DataBean.BrandListBean> brandListBeans;
    private LayoutHelper LayoutHelper;

    public GrilbrandAdapter(List<HomeBean.DataBean.BrandListBean> brandListBeans, com.alibaba.android.vlayout.LayoutHelper layoutHelper) {
        this.brandListBeans = brandListBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_brand, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder= (ViewHolder) holder;
        HomeBean.DataBean.BrandListBean brandListBean = brandListBeans.get(position);
        viewHolder.brand_name.setText(brandListBean.getName());
        viewHolder.brand_floor_price.setText(brandListBean.getFloor_price()+"起");
        Glide.with(holder.itemView.getContext()).load(brandListBean.getNew_pic_url()).into(viewHolder.brand_img);
    }

    @Override
    public int getItemCount() {
        return brandListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView brand_img;
        private TextView brand_name;
        private TextView brand_floor_price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brand_img = itemView.findViewById(R.id.brand_img);
            brand_name = itemView.findViewById(R.id.brand_name);
            brand_floor_price = itemView.findViewById(R.id.brand_floor_price);
        }
    }
}
