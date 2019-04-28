package com.tj.librarypractice_20190428;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.tj.librarypractice_20190428.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {

    }

    @Override
    public void setValues() {

//        웹상의 피자헛 이미지를 이미지뷰에 띄우기.
        Glide.with(mContext).load("http://cfs15.tistory.com/image/24/tistory/2008/11/05/18/00/491160cb593e2").into(act.pizzaLogoImgView);

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}
