package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter  extends DelegateAdapter.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private LayoutHelper LayoutHelper;

    public CategoryAdapter(Context context, ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans, LayoutHelper layoutHelper) {
        this.context = context;
        this.categoryListBeans = categoryListBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_category, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        holder.recyclerView.setLayoutManager(gridLayoutManager);
        HomeBean.DataBean.CategoryListBean categoryListBean = categoryListBeans.get(position);
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean> goodsList = categoryListBean.getGoodsList();
        holder.name.setText(categoryListBean.getName());

        ArrayList<HomeBean.DataBean.CategoryListBean.GoodsListBean> beans = new ArrayList<>();
        if (categoryListBean.getGoodsList().size()>0){
            beans.addAll(goodsList);
            CategoryListAdapter categoryListAdapter = new CategoryListAdapter(context, beans);
            holder.recyclerView.setAdapter(categoryListAdapter);
        }
    }

    @Override
    public int getItemCount() {
        if (categoryListBeans.size()>0){
            return categoryListBeans.size();
        }else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        private TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.category_recycler);
            name=itemView.findViewById(R.id.category_name);
        }
    }
}
