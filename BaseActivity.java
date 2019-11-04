package com.example.a111zy;
/*
 *@auther:周鑫光
 *@Date: 2019/11/1
 *@Time:19:28
 *@Description:${DESCRIPTION}
 * */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(inisid());
        inisview();
        inisData();
    }

    protected abstract void inisData();

    protected abstract void inisview();

    protected abstract int inisid();
}
