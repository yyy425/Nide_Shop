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
import com.bumptech.glide.Glide;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.List;

public class ColumnLayoutAdapter extends DelegateAdapter.Adapter {
    private Context context;
    private List<HomeBean.DataBean.ChannelBean> channelBeans;
    private LayoutHelper LayoutHelper;

    public ColumnLayoutAdapter(Context context, List<HomeBean.DataBean.ChannelBean> channelBeans, LayoutHelper layoutHelper) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_channel, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        HomeBean.DataBean.ChannelBean channelBean = channelBeans.get(position);
        Glide.with(context).load(channelBean.getIcon_url()).into(viewHolder.channel_img);
        viewHolder.channel_name.setText(channelBean.getName());
    }

    @Override
    public int getItemCount() {
       if (channelBeans.size()>0){
           return channelBeans.size();
       }else {
           return 0;
       }
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
