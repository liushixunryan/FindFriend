package com.example.ryan.findfriend.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.ryan.findfriend.R;
//import com.example.ryan.findfriend.pojo.Data;

import org.greenrobot.eventbus.EventBus;

import de.hdodenhof.circleimageview.CircleImageView;

public class PerfectoneActivity extends AppCompatActivity {
    private CircleImageView nan_img,nv_img,P_img;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfectone);

        init();

        intent=new Intent(PerfectoneActivity.this,PerfecttwoActivity.class);
        onClick();
    }

    private void onClick() {
        nan_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EventBus.getDefault().post(new String("ffff"));
//                intent=new Intent(PerfectoneActivity.this,CreatActivity.class);

//                startActivityForResult(intent,0);

//                 intent=new Intent(PerfectoneActivity.this,PerfecttwoActivity.class);
                intent.putExtra("gender","1");
//                sendBroadcast(intent);
                startActivity(intent);
            }
        });
    }

    private void init() {
        nan_img=findViewById(R.id.nan_img);
        nv_img=findViewById(R.id.nv_img);
        P_img=findViewById(R.id.P_img);

        P_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("gender","3");

                startActivity(intent);
            }
        });
    }

    public void onback(View view) {
        onBackPressed();
    }

    public void nv(View view) {
//        intent=new Intent(PerfectoneActivity.this,CreatActivity.class);

        intent.putExtra("gender","2");

        startActivity(intent);
    }
}
