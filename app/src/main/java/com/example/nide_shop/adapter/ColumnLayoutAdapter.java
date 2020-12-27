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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class ColumnLayoutAdapter extends DelegateAdapter.Adapter<ColumnLayoutAdapter.ViewHolder> {
    private ColumnLayoutHelper ColumnLayoutHelper;
    private List<HomeBean.DataBean.ChannelBean> channelBeans=new ArrayList<>();

    public ColumnLayoutAdapter(ColumnLayoutHelper columnLayoutHelper) {
        ColumnLayoutHelper = columnLayoutHelper;
    }
    public void getColumnChannel(List<HomeBean.DataBean.ChannelBean> list){
        list.addAll(channelBeans);
        notifyDataSetChanged();

    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return ColumnLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_channel, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBean.DataBean.ChannelBean channelBean = channelBeans.get(position);
        Glide.with(holder.itemView.getContext()).load(channelBean.getIcon_url()).into(holder.channel_img);
        holder.channel_name.setText(channelBean.getName());
    }

    @Override
    public int getItemCount() {
        return channelBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView channel_img;
        private TextView channel_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            channel_img=itemView.findViewById(R.id.channel_img);
            channel_name=itemView.findViewById(R.id.channel_name);
        }
    }
}