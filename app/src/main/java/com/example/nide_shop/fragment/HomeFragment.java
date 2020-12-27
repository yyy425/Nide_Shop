package com.example.nide_shop.fragment;

import android.graphics.Color;
import android.util.Log;

import android.view.View;


import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;

import com.example.myplibrary.base.BaseFragment;
import com.example.nide_shop.R;
import com.example.nide_shop.adapter.BannerAdapter;
import com.example.nide_shop.adapter.ColumnLayoutAdapter;
import com.example.nide_shop.adapter.GrilbrandAdapter;
import com.example.nide_shop.adapter.TitleAdapter;
import com.example.nide_shop.bean.HomeBean;
import com.example.nide_shop.constract.HomeConstract;
import com.example.nide_shop.presenter.HomePresenterIml;


import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenterIml> implements HomeConstract.IHomeView {
    private HomePresenterIml homePresenterIml;
    private RecyclerView recycler;
    private BannerAdapter bannerAdapter;
    private ColumnLayoutAdapter columnLayoutAdapter;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerBeans;
    private ArrayList<HomeBean.DataBean.ChannelBean> channelBeans;
    private TitleAdapter titleAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private GrilbrandAdapter grilbrandAdapter;

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


        delegateAdapter.addAdapter(initBanner());
        delegateAdapter.addAdapter(initChannel());
      //  delegateAdapter.addAdapter(initTitle());
        delegateAdapter.addAdapter(initBrand());

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(delegateAdapter);
    }

    private DelegateAdapter.Adapter initBrand() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(false);
        gridLayoutHelper.setWeights(new float[]{50,50});
        gridLayoutHelper.setVGap(10);
        gridLayoutHelper.setHGap(10);
        gridLayoutHelper.setSpanCount(2);
        brandListBeans = new ArrayList<>();
        grilbrandAdapter = new GrilbrandAdapter(gridLayoutHelper, brandListBeans);
        return grilbrandAdapter;
    }

    private DelegateAdapter.Adapter initBanner() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        bannerBeans = new ArrayList<>();
        bannerAdapter = new BannerAdapter(bannerBeans, getActivity(), linearLayoutHelper);
        return bannerAdapter;

    }

    private DelegateAdapter.Adapter initChannel() {
        channelBeans = new ArrayList<>();
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解

        columnLayoutAdapter = new ColumnLayoutAdapter(columnLayoutHelper, getActivity(), channelBeans);
        return columnLayoutAdapter;
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
        if (homeBean!=null) {
            List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
            bannerBeans.addAll(banner);
            bannerAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();
            channelBeans.addAll(channel);
            columnLayoutAdapter.notifyDataSetChanged();

          //  titleAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.BrandListBean> brandList = homeBean.getData().getBrandList();
            brandListBeans.addAll(brandList);
            grilbrandAdapter.notifyDataSetChanged();

        }

    }

    private DelegateAdapter.Adapter initTitle() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.WHITE);
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name="品牌制造商直供";
        titleAdapter = new TitleAdapter(singleLayoutHelper, name, getActivity());
        return titleAdapter;
    }

    @Override
    public void getHomesNo(String error) {
        Log.e("TAG", "getHomesNo: " + error);

    }
}