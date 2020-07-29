package com.geun.campingjoa.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.geun.campingjoa.board.Boardlist;
import com.geun.campingjoa.info.MyinfoActivity;
import com.geun.campingjoa.R;
import com.geun.campingjoa.hotplace.HotplaceActivity;


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
    public void menu_myinfo(View view) {
            Intent intent=new Intent(this, MyinfoActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        }
    public void menu_02(View view) {
        Intent intent=new Intent(this, HotplaceActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
    public void menu_event(View view) {
        Intent intent=new Intent(this, EventActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
    public void menu_board(View view) {
        Intent intent=new Intent(this, Boardlist.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
    }
}

