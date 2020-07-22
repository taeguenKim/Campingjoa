package com.geun.campingjoa.board;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.geun.campingjoa.R;
import com.geun.campingjoa.login.G;
import com.google.firebase.firestore.FirebaseFirestore;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class WriteActivity extends AppCompatActivity {

    private static final String TAG = "WriteActivity";

    private long kakao=G.id;
    private String kakaoid=String.valueOf(kakao);
    private Uri filePath;
    private ImageView ivPreview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);

        Button checkbutton=findViewById(R.id.check);
        Button imagepush=findViewById(R.id.image_push);
        TextView writename = findViewById(R.id.writename);
        writename.setText(G.nickname);
        ivPreview = (ImageView) findViewById(R.id.iv_preview);

        checkbutton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
                Intent intent=new Intent(WriteActivity.this,Boardlist.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        });

        imagepush.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                tedPermission();
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "이미지를 선택하세요."), 0);

            }

        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0 && resultCode == RESULT_OK){
            filePath = data.getData();
            Log.d(TAG, "uri:" + String.valueOf(filePath));
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                ivPreview.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void tedPermission() {
        PermissionListener permissionListener=new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setRationaleMessage(getResources().getString(R.string.permission_2))
                .setDeniedMessage(getResources().getString(R.string.permission_1))
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
                .check();
    }




    private void uploadFile() {
        if (filePath != null) {
            //업로드 진행 Dialog 보이기
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("업로드중...");
            progressDialog.show();

            //storage
            FirebaseStorage storage = FirebaseStorage.getInstance();

            //Unique한 파일명을 만들자.
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMHH_mmss");
            Date now = new Date();
            String filename = formatter.format(now) + ".png";
            //storage 주소와 폴더 파일명을 지정해 준다.
            StorageReference storageRef = storage.getReferenceFromUrl("gs://yourStorage.appspot.com").child("images/" + filename);
            //올라가거라...
            storageRef.putFile(filePath)
                    //성공시
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss(); //업로드 진행 Dialog 상자 닫기
                            Toast.makeText(getApplicationContext(), "업로드 완료!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //실패시
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getApplicationContext(), "업로드 실패!", Toast.LENGTH_SHORT).show();
                        }
                    })
                    //진행중
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            @SuppressWarnings("VisibleForTests") //이걸 넣어 줘야 아랫줄에 에러가 사라진다. 넌 누구냐?
                                    double progress = (100 * taskSnapshot.getBytesTransferred()) /  taskSnapshot.getTotalByteCount();
                            //dialog에 진행률을 퍼센트로 출력해 준다
                            progressDialog.setMessage("Uploaded " + ((int) progress) + "% ...");
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "파일을 먼저 선택하세요.", Toast.LENGTH_SHORT).show();
        }
    }

}






    private void update(){
        final String title=((EditText)findViewById(R.id.write_title_text)).getText().toString();
        final String contents=((EditText)findViewById(R.id.write_contents_text)).getText().toString();

        if (title.length()>0 &&contents.length()>0){
            Writeinfo writeinfo=new Writeinfo(title,contents,kakaoid);
            uploader(writeinfo);
        }

    }

    private void uploader(Writeinfo writeinfo){
        FirebaseFirestore db= FirebaseFirestore.getInstance();
        db.collection("posts").add(writeinfo);
    }
}
