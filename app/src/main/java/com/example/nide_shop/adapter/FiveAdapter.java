package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class FiveAdapter extends DelegateAdapter.Adapter<FiveAdapter.ViewHolder> {
    protected Context context;
    private LayoutHelper LayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;

    public FiveAdapter(Context context, com.alibaba.android.vlayout.LayoutHelper layoutHelper, ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans) {
        this.context = context;
        LayoutHelper = layoutHelper;
        this.brandListBeans = brandListBeans;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_five, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder =  holder;
        holder.title_name.setText("周一周四·新品首发");
    }

    @Override
    public int getItemCount() {
        if (brandListBeans.size()>0){
            return 1;
        }else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_name = itemView.findViewById(R.id.title_name);
        }
    }
}
