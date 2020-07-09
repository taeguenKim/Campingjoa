package com.geun.campingjoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.drawable.GradientDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.LogoutResponseCallback;

import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.kakao.util.maps.helper.Utility.getPackageInfo;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv01 = (ImageView) findViewById(R.id.iv_02);
        Glide.with(this).load(R.raw.main_05).into(iv01);

        ImageView iv02 = (ImageView) findViewById(R.id.imageView6);
        Glide.with(this).load(R.raw.camping).into(iv02);


    }

    public void menu_01(View view) {

        Intent intent = new Intent(this, CampingActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

    }

    public void login_01(View view) {

        UserManagement.requestLogout(new LogoutResponseCallback() {

            @Override

            public void onCompleteLogout() {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);

                startActivity(intent);

            }

        });

        overridePendingTransition(R.anim.fadein, R.anim.fadeout);


    }
}
