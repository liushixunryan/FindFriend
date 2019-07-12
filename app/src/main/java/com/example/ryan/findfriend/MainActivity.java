package com.example.ryan.findfriend;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.ryan.findfriend.Fragment.MyFragment;
import com.example.ryan.findfriend.Fragment.RecommendFragment;
import com.example.ryan.findfriend.db.Db;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private Fragment Rfragment=new RecommendFragment();
    private RecommendFragment recommendFragmen;

    private ImageView tuijian_img,zhibo_img,dongtai_img,xiaoxi_img,wode_img;
    public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        //假装已经点击
        tuijian_img.setImageDrawable(getResources().getDrawable(R.drawable.tuijian_select));
        Fragment fragment=new RecommendFragment();
        FragmentManager manager=MainActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.lunbo,fragment);
        transaction.commit();

    }


    private void init() {
        tuijian_img=findViewById(R.id.tuijian_img);
        zhibo_img=findViewById(R.id.zhibo_img);
        dongtai_img=findViewById(R.id.dongtai_img);
        xiaoxi_img=findViewById(R.id.xiaoxi_img);
        wode_img=findViewById(R.id.wode_img);
    }

    public void tuijian(View view) {
        ft();
        tuijian_img.setImageDrawable(getResources().getDrawable(R.drawable.tuijian_select));
        Fragment Rfragment=new RecommendFragment();
        FragmentManager manager=MainActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.lunbo,Rfragment);
        transaction.commit();
    }


    public void dongtai(View view) {
        ft();
        dongtai_img.setImageDrawable(getResources().getDrawable(R.drawable.dongtai_select));

    }

    public void zhibo(View view) {
        ft();
        zhibo_img.setImageDrawable(getResources().getDrawable(R.drawable.zhibo_select));
    }

    public void xiaoxi(View view) {
        ft();
        xiaoxi_img.setImageDrawable(getResources().getDrawable(R.drawable.xiaoxi_select));
    }

    public void wode(View view) {
        ft();
        wode_img.setImageDrawable(getResources().getDrawable(R.drawable.wode_select));

        Fragment fragment=new MyFragment();
        FragmentManager manager=MainActivity.this.getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.lunbo,fragment);
        transaction.commit();
    }
    public void ft(){
        //图片进行复位
        tuijian_img.setImageDrawable(getResources().getDrawable(R.drawable.tuijian));
        zhibo_img.setImageDrawable(getResources().getDrawable(R.drawable.zhibo));
        dongtai_img.setImageDrawable(getResources().getDrawable(R.drawable.dongtai));
        xiaoxi_img.setImageDrawable(getResources().getDrawable(R.drawable.xiaoxi));
        wode_img.setImageDrawable(getResources().getDrawable(R.drawable.wode));

    }
}
