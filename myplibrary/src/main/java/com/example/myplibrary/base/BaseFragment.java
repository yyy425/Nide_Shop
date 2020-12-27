package com.example.myplibrary.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    private P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayout(), container, false);

        if (presenter==null){
            presenter=createPresenter();
            presenter.attachView(this);
        }
        initView(inflate);
        initData();
        return inflate;
    }
    protected abstract int getLayout();
    protected abstract void initView(View inflater);
    protected abstract P createPresenter();
    protected abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter!=null){
            presenter.detachView();
        }
    }
}
