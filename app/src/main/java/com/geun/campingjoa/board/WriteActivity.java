package com.geun.campingjoa.board;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.geun.campingjoa.R;
import com.geun.campingjoa.login.G;
import com.geun.campingjoa.main.MainActivity;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WriteActivity extends AppCompatActivity {
    private long kakao=G.id;
    private String kakaoid=String.valueOf(kakao);
    private ImageView ivPreview;
    private EditText ettitle,etcontent;
    private Uri imgUri;
    boolean isChanged=false;

    DatabaseReference profileRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            int permissionResult =checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permissionResult== PackageManager.PERMISSION_DENIED){
                String[] permissions=new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
                requestPermissions(permissions,100);
            }
        }

        TextView writename = findViewById(R.id.writename);
        writename.setText(G.nickname);
        ImageView ivProfile = findViewById(R.id.ivProfile);
        Button back = findViewById(R.id.back);

        Glide.with(this).load(G.profile).into(ivProfile);

        ivPreview =findViewById(R.id.iv_preview);
        ettitle=findViewById(R.id.write_title_text);
        etcontent=findViewById(R.id.write_contents_text);




        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WriteActivity.this, Boardlist.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });
    }

    public void image_push(View view) {
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,100);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==100 && resultCode==RESULT_OK){
            imgUri=data.getData();
            if (imgUri!=null){
                Glide.with(this).load(imgUri).into(ivPreview);
                isChanged=true;
            }
        }
    }
    void saveData(){
        //제목 내용 사진을 한번에 저장하려고 한다!!!!
        G.title=ettitle.getText().toString();
        G.contents=etcontent.getText().toString();
        G.photo=imgUri.toString();

        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmss");
        SimpleDateFormat sdff=new SimpleDateFormat("작성일 : yyyy년 MM월 dd일 / hh시 mm분");
        String fileName=sdf.format(new Date())+".png";
        final String fileTime=sdff.format(new Date());

        FirebaseStorage firebaseStorage= FirebaseStorage.getInstance();
        final StorageReference imgRef=firebaseStorage.getReference("boardphoto/"+fileName);


        UploadTask task =imgRef.putFile(imgUri);
        task.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                imgRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        G.photo=uri.toString();
                        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();

                        profileRef=firebaseDatabase.getReference("Borad");

                        Writeinfo writeinfo=new Writeinfo(G.nickname,kakaoid,G.title,G.contents,G.photo,fileTime);
                        profileRef.push().setValue(writeinfo);

                        Toast.makeText(WriteActivity.this, "작성완료!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });

            }
        });

    }

    public void check_btn(View view) {
        saveData();
    }
}
