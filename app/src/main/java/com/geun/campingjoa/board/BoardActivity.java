package com.geun.campingjoa.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.geun.campingjoa.R;
import com.geun.campingjoa.hotplace.CampdetailActivity;
import com.geun.campingjoa.hotplace.HotplaceActivity;
import com.geun.campingjoa.info.MyinfoActivity;
import com.geun.campingjoa.login.G;
import com.geun.campingjoa.main.MainActivity;

public class BoardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        Button back=findViewById(R.id.back);

        ImageView ivphoto = findViewById(R.id.imageView1);
        TextView tvNickname = findViewById(R.id.textView);
        TextView tv_title=findViewById(R.id.textView1);
        TextView tv_contents=findViewById(R.id.textView4);
        TextView tv_time=findViewById(R.id.textView3);

        Intent k=getIntent();
        String contents= k.getStringExtra("contents");
        String photo= k.getStringExtra("photo");
        String time= k.getStringExtra("time");
        String title= k.getStringExtra("title");

        tvNickname.setText(G.nickname);
        tv_title.setText(title);
        tv_contents.setText(contents);
        tv_time.setText(time);

        Glide.with(this).load(photo).into(ivphoto);

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(BoardActivity.this, Boardlist.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


    }

    public void haha(View view) {
        Toast.makeText(this, "칭찬해 주셔서 감사합니다!!", Toast.LENGTH_SHORT).show();
    }
}
