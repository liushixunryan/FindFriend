package com.example.ryan.findfriend.Register;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ryan.findfriend.Guangbo;
import com.example.ryan.findfriend.LoginActivity;
import com.example.ryan.findfriend.MainActivity;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.Util.HttpUtilPost;
import com.example.ryan.findfriend.Util.Md5Helper;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class    CreatActivity extends AppCompatActivity {
    private Intent intent;
    private RequestBody requestBody;
    private String nian,yue,gender,sheng,height,xl,hun,gz,ri;
    private MediaType JSON= MediaType.get("application/json; charset=utf-8");
    private EditText editText,editText2,editText3,editText4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creat);

        intent=getIntent();

        editText2=findViewById(R.id.mm);
        editText=findViewById(R.id.username);
        editText3=findViewById(R.id.phone);
        editText4=findViewById(R.id.email);
        gz=intent.getStringExtra("gz");
        ri=intent.getStringExtra("ri");
        nian=intent.getStringExtra("nian");//年
        yue=intent.getStringExtra("yue");//月
        gender=intent.getStringExtra("gender");//
        sheng=intent.getStringExtra("sheng");//省
        height=intent.getStringExtra("height");//身高
        xl=intent.getStringExtra("xl");//学历
        hun=intent.getStringExtra("hun");//已婚未婚
        gz=intent.getStringExtra("gz");//工资
        Toast.makeText(this, intent.getStringExtra("nian")+intent.getStringExtra("gz"), Toast.LENGTH_SHORT).show();
//        String gender= intent.getStringExtra("gender");
//

    //        Toast.makeText(this, , Toast.LENGTH_SHORT).show();
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void setCurrentTime1(String dataTime) {
//        Toast.makeText(this, dataTime, Toast.LENGTH_SHORT).show();
//    }

    public void Intent_creat(View view) {
        editText.getText();
        editText2.getText();

        String password=Md5Helper.toMD5(String.valueOf(editText2.getText()));
        JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("username",editText.getText());
            jsonObject.put("password",editText2.getText());
            jsonObject.put("email",editText4.getText());
            jsonObject.put("mobile",editText3.getText());
            jsonObject.put("gender",Integer.valueOf(gender));
            jsonObject.put("provinceid",22);
            jsonObject.put("cityid",34);
            jsonObject.put("distid",33);
            jsonObject.put("ageyear",Integer.valueOf(nian));
            jsonObject.put("agemonth",Integer.valueOf(yue));
            jsonObject.put("ageday",Integer.valueOf(ri));
            jsonObject.put("astro","人肉座");
            jsonObject.put("lunar","虎");
            jsonObject.put("marrystatus",Integer.valueOf(hun));
            jsonObject.put("height",Integer.valueOf(height));
            jsonObject.put("education",Integer.valueOf(xl));
            jsonObject.put("salary",Integer.valueOf(gz));

            Log.i("it520",jsonObject.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        "{\"loginname\":\"" + phonenumber + "\",\"password\":\""+ password +"\",\"devicecode\":\"M\",\"logintype\":\"username\"}";


        requestBody = RequestBody.create(JSON, jsonObject.toString());
        HttpUtilPost.sendOkhttpRequest("http://192.168.1.101:20100/user/regist", requestBody, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Looper.prepare();
                Toast.makeText(CreatActivity.this, "网络未连接或网络不稳定", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String reposes=response.body().string();
                Log.i("LoginActivityit520",reposes);
                Intent intent=new Intent(CreatActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });



//        startActivity(new Intent(this,MainActivity.class));
//        finish();
    }

    public void onback(View view) {
        onBackPressed();
    }
}
