package com.example.nide_shop.model;

import com.example.myplibrary.base.BaseView;
import com.example.myplibrary.utils.net.Callback;
import com.example.myplibrary.utils.net.RetrofirUtils;
import com.example.nide_shop.bean.HomeBean;
import com.example.nide_shop.constract.HomeConstract;
import com.example.nide_shop.presenter.HomePresenterIml;

public class HomeModelIml implements HomeConstract.IHomeModel{

    private final HomeConstract.IHomePresenter presenter;

    public HomeModelIml(HomeConstract.IHomePresenter homePresenterIml) {
        this.presenter=homePresenterIml;
    }

    @Override
    public <T> void getHomeList(String url, Callback<T> callback) {
        RetrofirUtils.getInstance().getHome(url,callback);
    }
}
