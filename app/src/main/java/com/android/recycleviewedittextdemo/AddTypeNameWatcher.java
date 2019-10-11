package com.android.recycleviewedittextdemo;

import android.text.Editable;
import android.text.TextWatcher;


//记录解决edittext数据刷新的问题
public class AddTypeNameWatcher implements TextWatcher {


    private Order mData;

    public AddTypeNameWatcher(Order data) {
        mData = data;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String s = charSequence.toString();
        mData.setName(s);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}