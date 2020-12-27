package com.example.nide_shop.fragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.myplibrary.base.BaseFragment;
import com.example.nide_shop.R;
import com.example.nide_shop.adapter.BannerAdapter;
import com.example.nide_shop.adapter.ColumnLayoutAdapter;
import com.example.nide_shop.bean.HomeBean;
import com.example.nide_shop.constract.HomeConstract;
import com.example.nide_shop.presenter.HomePresenterIml;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterIml> implements HomeConstract.IHomeView {

    private HomePresenterIml homePresenterIml;
    private RecyclerView recycler;
    private BannerAdapter bannerAdapter;
    private ColumnLayoutAdapter columnLayoutAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(getContext());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);


        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        bannerAdapter = new BannerAdapter(linearLayoutHelper);

        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        // columnLayoutHelper特有属性
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解
        columnLayoutAdapter = new ColumnLayoutAdapter(columnLayoutHelper);

        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(columnLayoutAdapter);

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(delegateAdapter);
    }

    @Override
    protected HomePresenterIml createPresenter() {
        return new HomePresenterIml(this);
    }

    @Override
    protected void initData() {
        homePresenterIml = new HomePresenterIml(this);
        homePresenterIml.getHome();

    }

    @Override
    public void getHomes(HomeBean homeBean) {
        if (homeBean != null) {
            bannerAdapter.getBannerData(homeBean.getData().getBanner());
            columnLayoutAdapter.getColumnChannel((ArrayList<HomeBean.DataBean.ChannelBean>) homeBean.getData().getChannel());

//            List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();
//            channelBeans.addAll(channel);
//            columnLayoutAdapter.notifyDataSetChanged();
        }
    }


    @Override
    public void getHomesNo(String error) {
        Log.e("TAG", "getHomesNo: " + error);

    }
}