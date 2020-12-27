package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans;

    public CategoryListAdapter(Context context, ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsListBeans) {
        this.context = context;
        this.goodsListBeans = goodsListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_categorylist, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeBean.DataBean.CategoryListBean.GoodsListBean goodsListBean = goodsListBeans.get(position);
        holder.name.setText(goodsListBean.getName());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(holder.img);
        holder.price.setText("￥"+goodsListBean.getRetail_price());
    }

    @Override
    public int getItemCount() {
        if (goodsListBeans.size()>0){
            return goodsListBeans.size();
        }else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.categorylist_img);
            name=itemView.findViewById(R.id.categorylist_name);
            price=itemView.findViewById(R.id.categorylist_price);
        }
    }
}
