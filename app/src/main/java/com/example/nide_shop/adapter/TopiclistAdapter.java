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

public class TopiclistAdapter extends RecyclerView.Adapter<TopiclistAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;

    public TopiclistAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans) {
        this.context = context;
        this.topicListBeans = topicListBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_topic_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeBean.DataBean.TopicListBean topicListBean = topicListBeans.get(position);
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(holder.img);
        holder.title.setText(topicListBean.getTitle());
        holder.price.setText("￥"+topicListBean.getPrice_info()+"元起");
        holder.subtitle.setText(topicListBean.getSubtitle());
    }

    @Override
    public int getItemCount() {
        if (topicListBeans.size() > 0) {
            return topicListBeans.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView price;
        private TextView subtitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.topic_img);
            title = itemView.findViewById(R.id.topic_title);
            price = itemView.findViewById(R.id.topic_price_info);
            subtitle = itemView.findViewById(R.id.topic_subtitle);
        }
    }
}
