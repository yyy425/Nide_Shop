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

public class TitleAdapter extends DelegateAdapter.Adapter{
    private String name;
    private Context context;
    private SingleLayoutHelper SingleLayoutHelper;

    public TitleAdapter(SingleLayoutHelper singleLayoutHelper, String name, Context context) {
        SingleLayoutHelper=singleLayoutHelper;
        this.name = name;
        this.context = context;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return SingleLayoutHelper;
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
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_name=itemView.findViewById(R.id.title_name);
        }
    }
}
