package com.geun.campingjoa.board;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.geun.campingjoa.R;
import com.geun.campingjoa.main.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Boardlist extends AppCompatActivity {


    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private ListView listView;
    private BoardAdapter adapter;
    ArrayList<Writeinfo> Datas=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boardlist);
        listView =findViewById(R.id.list_view);
        database=FirebaseDatabase.getInstance();
        myRef=database.getReference("Borad");
        adapter = new BoardAdapter(this, Datas);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Writeinfo writeinfo=Datas.get(position);

                String contents=writeinfo.contents;
                String photo=writeinfo.photo;
                String time=writeinfo.time;
                String title=writeinfo.title;

                Intent intent=new Intent(Boardlist.this,BoardActivity.class);
                intent.putExtra("contents",contents);
                intent.putExtra("photo",photo);
                intent.putExtra("time",time);
                intent.putExtra("title",title);
                startActivity(intent);

            }
        });

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Writeinfo writeinfo=snapshot.getValue(Writeinfo.class);
                Datas.add(writeinfo);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        Button back = findViewById(R.id.back);
        FloatingActionButton write = findViewById(R.id.write_button);

        write.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Boardlist.this, WriteActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Boardlist.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });


    }


}

