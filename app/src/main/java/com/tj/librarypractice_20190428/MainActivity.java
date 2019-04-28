package com.tj.librarypractice_20190428;

import android.Manifest;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import com.tj.librarypractice_20190428.databinding.ActivityMainBinding;

import java.util.List;

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


        act.callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PermissionListener permissionListener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Uri uri = Uri.parse(String.format("tel:%s", act.phoneNumTxt.getText().toString())); // 띄어쓰기 하면 앱이 죽음. 파싱 실패
                        Intent intent = new Intent(Intent.ACTION_CALL, uri);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(mContext, "전화 권한이 거부되어 통화에 실패했습니다.", Toast.LENGTH_SHORT).show();
                    }
                };

                TedPermission.with(mContext)
                        .setPermissionListener(permissionListener)
                        .setDeniedMessage("전화 권한을 거부하면 통화가 불가합니다. [설정]에서 활성화해주세요.")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();



            }
        });

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
