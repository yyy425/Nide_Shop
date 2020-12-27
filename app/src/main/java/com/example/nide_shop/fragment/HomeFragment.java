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
import com.example.nide_shop.adapter.CategoryAdapter;
import com.example.nide_shop.adapter.ColumnLayoutAdapter;
import com.example.nide_shop.adapter.FiveAdapter;
import com.example.nide_shop.adapter.GridNewgoods;
import com.example.nide_shop.adapter.GrilbrandAdapter;
import com.example.nide_shop.adapter.HotgoodAdapter;
import com.example.nide_shop.adapter.TitleAdapter;
import com.example.nide_shop.adapter.TopicAdapter;
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
    private TitleAdapter sevenAdapter;
    private TitleAdapter titleAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandListBeans;
    private GrilbrandAdapter grilbrandAdapter;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> newGoodsListBeans;
    private GridNewgoods gridNewgoods;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> hotGoodsListBeans;
    private HotgoodAdapter hotgoodAdapter;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListBeans;
    private TopicAdapter topicAdapter;
    private VirtualLayoutManager layoutManager;
    private FiveAdapter fiveAdapter;
    private TitleAdapter nineadapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean> categoryListBeans;
    private CategoryAdapter categoryAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {

        recycler = (RecyclerView) view.findViewById(R.id.recycler);
    }

    private void initTopic() {
        topicListBeans = new ArrayList<>();
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        topicAdapter = new TopicAdapter(getActivity(), topicListBeans, singleLayoutHelper);
        singleLayoutHelper.setPaddingBottom(40);
    }

    private void initHotgood() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        hotGoodsListBeans = new ArrayList<>();
        linearLayoutHelper.setItemCount(3);
        hotgoodAdapter = new HotgoodAdapter(getActivity(), hotGoodsListBeans, linearLayoutHelper);
    }

    private void initNewgoods() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutHelper.setWeights(new float[]{50, 50});
        newGoodsListBeans = new ArrayList<>();
        gridNewgoods = new GridNewgoods(getActivity(), newGoodsListBeans, gridLayoutHelper);
    }

    private void initBrand() {
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(2);
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutHelper.setWeights(new float[]{50, 50});
        gridLayoutHelper.setVGap(10);
        gridLayoutHelper.setHGap(10);
        gridLayoutHelper.setSpanCount(2);
        brandListBeans = new ArrayList<>();
        grilbrandAdapter = new GrilbrandAdapter(brandListBeans, gridLayoutHelper);
    }

    private void initBanner() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        bannerBeans = new ArrayList<>();
        singleLayoutHelper.setItemCount(1);
        bannerAdapter = new BannerAdapter(bannerBeans, getActivity(), singleLayoutHelper);
    }

    private void initChannel() {
        channelBeans = new ArrayList<>();
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});// 设置该行每个Item占该行总宽度的比例
        // 同上面Weigths属性讲解

        columnLayoutAdapter = new ColumnLayoutAdapter(getActivity(), channelBeans, columnLayoutHelper);
    }

    @Override
    protected HomePresenterIml createPresenter() {
        return new HomePresenterIml(this);
    }

    @Override
    protected void initData() {
        homePresenterIml = new HomePresenterIml(this);

        layoutManager = new VirtualLayoutManager(getActivity());
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recycler.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,11);
        recycler.setLayoutManager(layoutManager);

        initBanner();
        initChannel();
        initTitle();
        initBrand();
        initFive();
        initNewgoods();
        initServen();
        initHotgood();
        initNine();
        initTopic();
        initCategory();

        addAdapter();
        homePresenterIml.getHome();

    }

    private void initCategory() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        categoryListBeans = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getActivity(), categoryListBeans, linearLayoutHelper);
    }

    private void initNine() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name = "专题精选";
        nineadapter = new TitleAdapter(name, getActivity(), channelBeans, singleLayoutHelper);
    }

    private void initFive() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        fiveAdapter = new FiveAdapter(getActivity(), singleLayoutHelper, brandListBeans);
    }

    private void addAdapter() {
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager, true);


        delegateAdapter.addAdapter(bannerAdapter);
        delegateAdapter.addAdapter(columnLayoutAdapter);
        delegateAdapter.addAdapter(titleAdapter);
        delegateAdapter.addAdapter(grilbrandAdapter);
        delegateAdapter.addAdapter(fiveAdapter);
        delegateAdapter.addAdapter(gridNewgoods);
        delegateAdapter.addAdapter(sevenAdapter);
        delegateAdapter.addAdapter(hotgoodAdapter);
        delegateAdapter.addAdapter(nineadapter);
        delegateAdapter.addAdapter(topicAdapter);
        delegateAdapter.addAdapter(categoryAdapter);


        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(delegateAdapter);
    }

    @Override
    public void getHomes(HomeBean homeBean) {
        if (homeBean != null) {
            List<HomeBean.DataBean.BannerBean> banner = homeBean.getData().getBanner();
            bannerBeans.addAll(banner);
            bannerAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.ChannelBean> channel = homeBean.getData().getChannel();
            channelBeans.addAll(channel);
            columnLayoutAdapter.notifyDataSetChanged();

            titleAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.BrandListBean> brandList = homeBean.getData().getBrandList();
            brandListBeans.addAll(brandList);
            grilbrandAdapter.notifyDataSetChanged();


            fiveAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.NewGoodsListBean> newGoodsList = homeBean.getData().getNewGoodsList();
            newGoodsListBeans.addAll(newGoodsList);
            gridNewgoods.notifyDataSetChanged();

            sevenAdapter.notifyDataSetChanged();


            if (newGoodsListBeans.size() > 0) {
                List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList = homeBean.getData().getHotGoodsList();
                hotGoodsListBeans.addAll(hotGoodsList);
                hotgoodAdapter.notifyDataSetChanged();
            }
            nineadapter.notifyDataSetChanged();

            List<HomeBean.DataBean.TopicListBean> topicList = homeBean.getData().getTopicList();
            topicListBeans.addAll(topicList);
            topicAdapter.notifyDataSetChanged();

            List<HomeBean.DataBean.CategoryListBean> categoryList = homeBean.getData().getCategoryList();
            categoryListBeans.addAll(categoryList);
            categoryAdapter.notifyDataSetChanged();
        }

    }

    private void initServen() {        //人气推荐
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setBgColor(Color.WHITE);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(4);
        String name = "人气推荐";
        sevenAdapter = new TitleAdapter(name, getActivity(), channelBeans, singleLayoutHelper);
    }

    private void initTitle() {
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setBgColor(Color.WHITE);
        singleLayoutHelper.setItemCount(1);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutHelper.setMarginTop(6);
        String name = "品牌制造商直供";
        titleAdapter = new TitleAdapter(name, getActivity(), channelBeans, singleLayoutHelper);
    }

    @Override
    public void getHomesNo(String error) {
        Log.e("TAG", "getHomesNo: " + error);

    }
}