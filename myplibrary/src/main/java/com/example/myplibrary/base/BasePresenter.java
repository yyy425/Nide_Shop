package com.example.myplibrary.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    private V iView;
    public void attachView(V v){
        iView=v;
    }

    public void detachView(){
        iView=null;
    }

}
