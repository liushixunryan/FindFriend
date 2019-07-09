package com.example.ryan.findfriend.Register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.Guangbo;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.Register.fragment.nian.NianRecclerAdapter;
import com.example.ryan.findfriend.Register.fragment.nian.NianThreeFragment;
import com.example.ryan.findfriend.Register.fragment.ri.RiThreeFragment;
import com.example.ryan.findfriend.Register.fragment.yue.YueThreeFragment;

public class PerfectthreeActivity extends AppCompatActivity {
    private TextView nian_tv,yue_tv,ri_tv;
    private NianRecclerAdapter.NianViewHolder holder;
    private TextView textView;


    private Fragment fragmentN=new NianThreeFragment();
    private  Fragment fragmentY=new YueThreeFragment();
    private  Fragment fragmentR=new RiThreeFragment();
    private  int niantiao=0;
    Intent intent;
    private  FragmentManager manager=PerfectthreeActivity.this.getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfectthree);
        //第一次直接运行
        Fragment fragment=new NianThreeFragment();
        FragmentManager manager=PerfectthreeActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.data,fragment);
        transaction.commit();


         textView=findViewById(R.id.bai);


        init();
        onClick();



    }

    private void onClick() {
        nian_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Fragment fragment=new NianThreeFragment();
                android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.data,fragmentN);
                transaction.commit();
            }
        });

        yue_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=getIntent();
                Toast.makeText(PerfectthreeActivity.this, intent.getStringExtra("nian"), Toast.LENGTH_SHORT).show();
                if(intent.getStringExtra("nian")==null){


                }
                else {
                    android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.data,fragmentY);
                    transaction.commit();
                }
//                Fragment fragment=new YueThreeFragment();
//                FragmentManager manager=PerfectthreeActivity.this.getSupportFragmentManager();

            }
        });

        ri_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=getIntent();
                Toast.makeText(PerfectthreeActivity.this, intent.getStringExtra("yue"), Toast.LENGTH_SHORT).show();
                if(intent.getStringExtra("yue")==null){

                }
                else {
                    android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
                    transaction.replace(R.id.data,fragmentR);
                    transaction.commit();
                }
//                Fragment fragment=new RiThreeFragment();
//                FragmentManager manager=PerfectthreeActivity.this.getSupportFragmentManager();

            }
        });

    }

    private void init() {
        nian_tv=findViewById(R.id.nian_tv);
        yue_tv=findViewById(R.id.yue_tv);
        ri_tv=findViewById(R.id.ri_tv);
    }

    public void TiaoYue(){


                Fragment fragment=new YueThreeFragment();
                FragmentManager manager = PerfectthreeActivity.this.getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
                transaction.replace(R.id.data,fragment);
                transaction.commit();


    }
    public void TiaoRi(){
        Fragment fragment=new RiThreeFragment();
        FragmentManager manager = PerfectthreeActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.data,fragment);
        transaction.commit();


    }

    public void onback(View view) {
        onBackPressed();
    }
}
