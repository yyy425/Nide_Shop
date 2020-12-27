package com.example.nide_shop.presenter;

import com.example.myplibrary.base.BasePresenter;
import com.example.myplibrary.utils.net.Callback;
import com.example.myplibrary.utils.net.UrlConstant;
import com.example.nide_shop.bean.HomeBean;
import com.example.nide_shop.constract.HomeConstract;
import com.example.nide_shop.model.HomeModelIml;

public class HomePresenterIml extends BasePresenter implements HomeConstract.IHomePresenter {
    private final HomeConstract.IHomeView view;
    private final HomeConstract.IHomeModel model;

    public HomePresenterIml(HomeConstract.IHomeView iHomeView) {
        this.view = iHomeView;
        this.model = new HomeModelIml(this);
    }

    @Override
    public void getHome() {

        model.getHomeList(UrlConstant.RADIOGROUP_HOME, new Callback<HomeBean>() {
            @Override
            public void onsuccess(HomeBean homeBean) {

                view.getHomes(homeBean);
            }

            @Override
            public void onfail(String msg) {
                view.getHomesNo(msg);
            }
        });
    }
}
