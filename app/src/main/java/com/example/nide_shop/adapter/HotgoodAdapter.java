package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class HotgoodAdapter extends DelegateAdapter.Adapter<HotgoodAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private LayoutHelper LayoutHelper;

    public HotgoodAdapter(Context context, ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans, com.alibaba.android.vlayout.LayoutHelper layoutHelper) {
        this.context = context;
        this.hotGoodsListBeans = hotGoodsListBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_hotgood, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBean.DataBean.HotGoodsListBean hotGoodsListBean = hotGoodsListBeans.get(position);
        Glide.with(context).load(hotGoodsListBean.getList_pic_url()).into(holder.img);
        holder.name.setText(hotGoodsListBean.getName());
        holder.brief.setText(hotGoodsListBean.getGoods_brief());
        holder.brief.setText(hotGoodsListBean.getRetail_price());

    }

    @Override
    public int getItemCount() {
        return hotGoodsListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView brief;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.hotgood_img);
            name=itemView.findViewById(R.id.hotgood_name);
            brief=itemView.findViewById(R.id.hotgood_goods_brief);
            price=itemView.findViewById(R.id.hotgood_retail_price);
        }
    }
}
