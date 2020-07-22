package com.geun.campingjoa.camping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.geun.campingjoa.R;
import com.geun.campingjoa.main.MainActivity;

import net.daum.mf.map.api.MapView;

public class CampingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camping);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);
        super.onBackPressed();
    }
}
