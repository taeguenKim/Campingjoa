package com.geun.campingjoa.board;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.geun.campingjoa.R;
import com.geun.campingjoa.info.MyinfoActivity;
import com.geun.campingjoa.main.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Boardlist extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardlist);

        Button back=findViewById(R.id.back);
        FloatingActionButton write=findViewById(R.id.write_button);

        write.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Boardlist.this,WriteActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Boardlist.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });



    }
}
