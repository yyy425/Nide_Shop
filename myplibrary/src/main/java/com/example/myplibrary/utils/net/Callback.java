package com.example.myplibrary.utils.net;

public interface Callback<T> {
    void onsuccess(T t);
    void onfail(String msg);
}
