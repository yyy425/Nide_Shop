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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class GridNewgoods  extends DelegateAdapter.Adapter<GridNewgoods.ViewHolder> {

    private Context context;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private LayoutHelper LayoutHelper;


    public GridNewgoods(Context context, ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans, com.alibaba.android.vlayout.LayoutHelper layoutHelper) {
        this.context = context;
        this.newGoodsListBeans = newGoodsListBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_newgoods, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsListBeans.get(position);
        Glide.with(context).load(newGoodsListBean.getList_pic_url()).into(holder.newgoods_img);
        holder.newg00ds_name.setText(newGoodsListBean.getName());
        holder.newgoods_price.setText("¥ " +newGoodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        return newGoodsListBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView newgoods_img;
        private TextView newg00ds_name;
        private TextView newgoods_price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            newgoods_img=itemView.findViewById(R.id.newgoods_img);
            newg00ds_name=itemView.findViewById(R.id.newgoods_name);
            newgoods_price=itemView.findViewById(R.id.newgoods_retail_price);
        }
    }
}
