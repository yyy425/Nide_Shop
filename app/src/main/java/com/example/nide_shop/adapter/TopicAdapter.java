package com.example.nide_shop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.example.nide_shop.R;
import com.example.nide_shop.bean.HomeBean;

import java.util.ArrayList;

public class TopicAdapter extends DelegateAdapter.Adapter<TopicAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private LayoutHelper LayoutHelper;
    private int xOffset;
    private int position;
    private TopiclistAdapter topiclistAdapter;

    public TopicAdapter(Context context, ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans, LayoutHelper layoutHelper) {
        this.context = context;
        this.topicListBeans = topicListBeans;
        LayoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return LayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_topic, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            holder.recyclerView.setLayoutManager(linearLayoutManager);
            topiclistAdapter = new TopiclistAdapter(context, topicListBeans);
            holder.recyclerView.setAdapter(topiclistAdapter);
    }

    @Override
    public int getItemCount() {
       if (topicListBeans.size()>0){
           return 1;
       }else {
           return 0;
       }
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView=itemView.findViewById(R.id.recycler);
        }
    }
}
