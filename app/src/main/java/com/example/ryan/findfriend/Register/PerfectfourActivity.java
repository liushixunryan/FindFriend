package com.example.ryan.findfriend.Register;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.ryan.findfriend.Adapter.ShengaoAdpater;
import com.example.ryan.findfriend.R;

import java.util.ArrayList;
import java.util.List;

public class PerfectfourActivity extends AppCompatActivity {
    private RecyclerView shengao_rv;
    private List<String> list,list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfectfour);



        shengao_rv=findViewById(R.id.shengao_rv);
//        recyclerView1=findViewById(R.id.recy1);
        list2=new ArrayList<>();
        list2.add("130");
        list2.add("140");
        list2.add("150");
        list2.add("160");
        list2.add("170");
        list2.add("180");
        list2.add("190");
        list2.add("200");
        list=new ArrayList<>();
        list.add("130cm");
        list.add("140cm");
        list.add("150cm");
        list.add("160cm");
        list.add("170cm");
        list.add("180cm");
        list.add("190cm");
        list.add("200cm");
//        list2=new ArrayList<>();
//        list2.add("hhh");
//        list2.add("hhh");
//        list2.add("hhh");
//        list2.add("hhh");
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,1);
//        GridLayoutManager gridLayoutManager2=new GridLayoutManager(this,1);
        shengao_rv.setLayoutManager(gridLayoutManager);
//        recyclerView1.setLayoutManager(gridLayoutManager2);
        ShengaoAdpater hslbAdpater=new ShengaoAdpater(this,list,list2);
//        hslb2Adpater hslb2Adpater=new hslb2Adpater(this,list2);
        shengao_rv.setAdapter(hslbAdpater);

    }

    public void onback(View view) {
        onBackPressed();
    }
}
