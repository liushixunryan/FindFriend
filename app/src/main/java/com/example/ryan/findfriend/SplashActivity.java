package com.example.ryan.findfriend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ryan.findfriend.Register.PerfectoneActivity;

public class SplashActivity extends AppCompatActivity {
    private Button register_btn,login_btn;
    private TextView xieyi_tv,geren_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        onClick();
    }
    private void init() {
        register_btn=findViewById(R.id.register_btn);
        login_btn=findViewById(R.id.login_btn);
        xieyi_tv=findViewById(R.id.xieyi_tv);
        geren_tv=findViewById(R.id.geren_tv);
    }


    private void onClick() {
        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,PerfectoneActivity.class);
                startActivity(intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        xieyi_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        geren_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
