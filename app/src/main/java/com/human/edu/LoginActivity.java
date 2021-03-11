package com.human.edu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;

    @Override
    protected void onStart() {
        Toast.makeText(LoginActivity.this, "onStart상태", Toast.LENGTH_SHORT).show();
        super.onStart();
    }

    @Override
    protected void onStop() {
        Toast.makeText(LoginActivity.this, "onStop상태", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(LoginActivity.this, "onDestroy상태", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Toast.makeText(LoginActivity.this, "onPause상태", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(LoginActivity.this, "onResume상태", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(LoginActivity.this, "onCreate상태", Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin.findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText TextID, TextPW;
                TextID = findViewById(R.id.TextID);
                TextPW = findViewById(R.id.TextPW);
                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                mainIntent.putExtra("TextID", TextID.getText().toString());
                mainIntent.putExtra("TextPW", TextPW.getText().toString());
                startActivity(mainIntent);
            }
        });
    }


    //login.xml에서 onclick속성을 gotoMain으로 지정했을 경우 사용가능(아래)-지금은 해제
    public void gotoMain(View view) {
        EditText TextID, TextPW;
        TextID = findViewById(R.id.TextID);
        TextPW = findViewById(R.id.TextPW);
       // Toast.makeText(LoginActivity.this, "디버그" + TextID.getText(),Toast.LENGTH_SHORT).show();
       //로그인 버튼을 onclick 했을 때
        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
       //데이터를 입력해서 메인액티비티 화면열기(아래)
        mainIntent.putExtra("TextID", TextID.getText());//아이디
        mainIntent.putExtra("TextPW", TextPW.getText());//암호
        startActivity(mainIntent);//편지봉투 Intent를 개봉 = 화면불러오기 실행
        finish();//종료
    }
}