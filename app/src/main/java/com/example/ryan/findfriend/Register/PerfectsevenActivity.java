package com.example.ryan.findfriend.Register;

import android.content.BroadcastReceiver;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ryan.findfriend.R;

public class PerfectsevenActivity extends AppCompatActivity {
    private Intent intent;
    String nian,yue,ri,sheng,gender,height,xl,hun;
    private Button button1,button2,button3,button4,button5,button6,button7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_perfectseven);
        button1=findViewById(R.id.gz1);
        button2=findViewById(R.id.gz2);
        button3=findViewById(R.id.gz3);
        button4=findViewById(R.id.gz4);
        button5=findViewById(R.id.gz5);
        button6=findViewById(R.id.gz6);
        button7=findViewById(R.id.gz7);
        intent=getIntent();
        nian=intent.getStringExtra("nian");
        yue=intent.getStringExtra("yue");
        ri=intent.getStringExtra("ri");
        gender=intent.getStringExtra("gender");
        sheng=intent.getStringExtra("sheng");
        height=intent.getStringExtra("height");
        xl=intent.getStringExtra("xl");
        hun=intent.getStringExtra("hun");
        Toast.makeText(this,
                intent.getStringExtra("nian")+intent.getStringExtra("hun"), Toast.LENGTH_SHORT).show();
        intent=new Intent(this,CreatActivity.class);
        intent.putExtra("sheng",sheng);
        intent.putExtra("nian",nian);
        intent.putExtra("gender",gender);
        intent.putExtra("yue",yue);
        intent.putExtra("height",height);
        intent.putExtra("xl",xl);
        intent.putExtra("ri",ri);
        intent.putExtra("hun",hun);
    }


    public void Intent_seven(View view) {
        intent.putExtra("gz","1");
        startActivity(intent);

    }
    public void Intent_seven1(View view) {
        intent.putExtra("gz","2");
        startActivity(intent);
    }

    public void Intent_seven2(View view) {
        intent.putExtra("gz","3");
        startActivity(intent);
    }

    public void Intent_seven3(View view) {
        intent.putExtra("gz","4");
        startActivity(intent);
    }

    public void Intent_seven4(View view) {
        intent.putExtra("gz","5");
        startActivity(intent);
    }

    public void Intent_seven5(View view) {
        intent.putExtra("gz","6");
        startActivity(intent);
    }
    public void Intent_seven6(View view) {
        intent.putExtra("gz","7");
        startActivity(intent);
    }

    public void onback(View view) {
        onBackPressed();
    }
}
