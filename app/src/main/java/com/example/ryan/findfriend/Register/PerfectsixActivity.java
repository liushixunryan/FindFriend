package com.example.ryan.findfriend.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ryan.findfriend.R;

public class PerfectsixActivity extends AppCompatActivity {
        private  Intent intent;
        private Button button1,button2,button3;
       private String nian,yue,ri,height,sheng,gender,xl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfectsix);
        intent=getIntent();
        Toast.makeText(this, intent.getStringExtra("nian")+intent.getStringExtra("xl"), Toast.LENGTH_SHORT).show();
        nian=intent.getStringExtra("nian");
        yue=intent.getStringExtra("yue");
        gender=intent.getStringExtra("gender");
        ri=intent.getStringExtra("ri");
        sheng=intent.getStringExtra("sheng");
        height=intent.getStringExtra("height");
        xl=intent.getStringExtra("xl");
    intent=new Intent(this,PerfectsevenActivity.class);
    button1=findViewById(R.id.hun1);
    button2=findViewById(R.id.hu2);
    button3=findViewById(R.id.hu3);
        intent.putExtra("sheng",sheng);
        intent.putExtra("nian",nian);
        intent.putExtra("gender",gender);
        intent.putExtra("yue",yue);
        intent.putExtra("ri",ri);
        intent.putExtra("height",height);
        intent.putExtra("xl",xl);
    }

    public void Intent_six1(View view) {
        intent.putExtra("hun","1");
        startActivity(intent);

    }
    public void Intent_six2(View view) {
        intent.putExtra("hun","2");
        startActivity(intent);

    }
    public void Intent_six3(View view) {
        intent.putExtra("hun","3");
        startActivity(intent);

    }



    public void onback(View view) {
        onBackPressed();
    }
}
