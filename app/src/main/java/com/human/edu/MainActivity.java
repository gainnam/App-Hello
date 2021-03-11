package com.human.edu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //class 안쪽에서 사용될 변수 선언(아래) = 멤버변수
    Button btnTel, btnLogout;
    TextView textViewWelcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//메모리 로딩(화면 랜더링)

        Intent intent = new Intent(this.getIntent());
        String userId = intent.getStringExtra("TextID");
        String userPW = intent.getStringExtra("TextPW");
        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewWelcome.setText(userId + "님 환영합니다.");

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
            }
        });
        Button btnTel = findViewById(R.id.btnTel);//onclick속성없이 사용

        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "전화걸기 버튼 실행", Toast.LENGTH_SHORT).show();;
                Intent telIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:0101111111"));
                startActivity(telIntent);
                finish();//앱종료x 액티비티가 사라지는 기능
                System.exit(0);//자바프로그램 강제종료법 0 정상종료, 1 비정상 강제종료
            }
        });
    }

    public void goToNaver(View view) {
        //디버그 작동확인 -스프링: sysout, 여기는 toast
        Toast.makeText(getApplicationContext(), "네이버 버튼이 눌렸어용", Toast.LENGTH_LONG).show();
        Intent naverIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://naver.com"));
        startActivity(naverIntent);//activity화면 실행
    }
}