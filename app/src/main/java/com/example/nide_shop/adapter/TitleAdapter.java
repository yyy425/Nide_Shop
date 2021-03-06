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
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class TitleAdapter extends DelegateAdapter.Adapter{
    private String name;
    private Context context;
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    private LayoutHelper LayoutHelper;

    public TitleAdapter(String name, Context context, ArrayList<HomeBean.DataBean.ChannelBean> channelBeans, LayoutHelper layoutHelper) {
        this.name = name;
        this.context = context;
        this.channelBeans = channelBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_title, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        viewHolder.title_name.setText(name);
    }
    @Override
    public int getItemCount() {
       if (channelBeans.size()>0){
           return 1;
       }else {
           return 0;
       }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_name=itemView.findViewById(R.id.title_name);
        }
    }
}
