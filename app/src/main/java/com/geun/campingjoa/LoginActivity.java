package com.geun.campingjoa;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import com.kakao.auth.AuthType;
import com.kakao.auth.Session;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Session session = Session.getCurrentSession();
        session.addCallback(new SessionCallback());
        session.open(AuthType.KAKAO_LOGIN_ALL, this);

    }

}
