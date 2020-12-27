package com.example.myplibrary.utils.net;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofirUtils implements INewWorkInterface {
    private static RetrofirUtils instance;
    private final ApiService apiService;

    public static RetrofirUtils getInstance(){
       if (instance==null){
           synchronized (RetrofirUtils.class){
               if (instance==null){
                   instance=new RetrofirUtils();
               }
           }
       }
       return instance;
   }

    public RetrofirUtils() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UrlConstant.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    @Override
    public <T> void getHome(String url, Callback<T> callback) {

        apiService.getHome(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {

                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = callback.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type=actualTypeArguments[0];
                            T json = new Gson().fromJson(string, type);
                            callback.onsuccess(json);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        callback.onfail(e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
