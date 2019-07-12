package com.example.ryan.findfriend.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ryan.findfriend.R;

public class PerfectfiveActivity extends AppCompatActivity {
    private  Intent intent;
    private Button button1,button2,button3,button4,button5,button6;
    private String nian,yue,ri,gender,sheng,height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfectfive);
        intent=getIntent();
        Toast.makeText(this, intent.getStringExtra("height")+intent.getStringExtra("nian"), Toast.LENGTH_SHORT).show();
        button1=findViewById(R.id.xl1);
        button2=findViewById(R.id.xl2);
        button3=findViewById(R.id.xl3);
        button4=findViewById(R.id.xl4);
        button5=findViewById(R.id.xl5);
        button6=findViewById(R.id.xl6);
        nian=intent.getStringExtra("nian");
        yue=intent.getStringExtra("yue");
        ri=intent.getStringExtra("ri");
        gender=intent.getStringExtra("gender");
        sheng=intent.getStringExtra("sheng");
        height=intent.getStringExtra("height");
        intent=new Intent(this,PerfectsixActivity.class);
        intent.putExtra("sheng",sheng);
        intent.putExtra("nian",nian);
        intent.putExtra("gender",gender);
        intent.putExtra("yue",yue);
        intent.putExtra("ri",ri);
        intent.putExtra("height",height);
    }

    public void Intent_five1(View view) {
        intent.putExtra("xl","1");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void Intent_five2(View view) {
        intent.putExtra("xl","2");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void Intent_five3(View view) {
        intent.putExtra("xl","3");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void Intent_five4(View view) {
        intent.putExtra("xl","4");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
    public void Intent_five5(View view) {
        intent.putExtra("xl","5");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }public void Intent_five6(View view) {
        intent.putExtra("xl","6");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }



    public void onback(View view) {
        onBackPressed();
    }

    public void Intent_five7(View view) {
        intent.putExtra("xl","7");
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }
}
