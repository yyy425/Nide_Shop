package com.example.nide_shop.constract;

import com.example.myplibrary.base.BaseView;
import com.example.myplibrary.utils.net.Callback;
import com.example.nide_shop.bean.HomeBean;

public class HomeConstract {
    public interface IHomeView extends BaseView {
        void getHomes(HomeBean homeBean);
        void getHomesNo(String error);
    }
    public interface IHomeModel{
        <T> void getHomeList(String url, Callback<T> callback);
    }
    public interface IHomePresenter{
        void getHome();
    }
}
