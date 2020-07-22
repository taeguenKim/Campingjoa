package com.geun.campingjoa.hotplace;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.geun.campingjoa.R;

public class CampdetailActivity extends Activity {


    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campdetail);
        Button back=findViewById(R.id.back);

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CampdetailActivity.this, HotplaceActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


        ImageView profile=(ImageView)findViewById(R.id.imageView1);
        TextView title=(TextView)findViewById(R.id.textView1);
        TextView place=(TextView)findViewById(R.id.textView2);
        TextView show=(TextView)findViewById(R.id.textView4);
        TextView money=(TextView)findViewById(R.id.textView3);
        TextView people=(TextView)findViewById(R.id.textView);




        Intent intent=getIntent();

        profile.setImageResource(intent.getIntExtra("profile",0));
        title.setText(intent.getStringExtra("title"));
        place.setText(intent.getStringExtra("place"));
        show.setText(intent.getStringExtra("show"));
        money.setText(intent.getStringExtra("money"));
        people.setText(intent.getStringExtra("people"));
        url=intent.getStringExtra("url");





    }

    public void haha(View view) {
        startActivity(new Intent(getIntent().ACTION_VIEW, Uri.parse(url)));
    }
}
