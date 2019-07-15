package com.example.ryan.findfriend;
/**
 *  登陆界面
 *  此界面完美了
 * */

import android.content.ContentValues;
import android.content.Intent;

import android.database.sqlite.SQLiteDatabase;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.ryan.findfriend.Util.HttpUtilPost;
import com.example.ryan.findfriend.Util.Md5Helper;
import com.example.ryan.findfriend.db.Db;

import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText phonenumber_et,password_et;
    private String address="http://192.168.1.101:20100/user/login";
    private RequestBody requestBody;
    private  MediaType JSON= MediaType.get("application/json; charset=utf-8");
    private int code;
//    private String mobile,username,email;
    //判断是否为手机号
    public static final String PHONE="^((13[0-9])|(15[^4,\\D])|(18[0,2,3,5-9])|(17[6]))\\d{8}$";
    //判断是否为邮箱
    public static final String EMAIL="\\w+@(\\w+.)+[a-z]{2,3}";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        phonenumber_et=findViewById(R.id.phonenumber_et);
        password_et=findViewById(R.id.password_et);


    }

    public void login(View view) {
        String phonenumber = phonenumber_et.getText().toString();
        String password = password_et.getText().toString();
        password = Md5Helper.toMD5(password);
        String logintype;
        //判断什么登录类型
        if (phonenumber.matches(PHONE)) {
            logintype = "mobile";
        } else if (phonenumber.matches(EMAIL)) {
            logintype = "email";
        } else {
            logintype = "username";
        }

//        username mobile email
//        Log.i("LoginActivityit520",password);
//        "{\"loginname\":\"13683293106\",\"password\":\"2c9f740fdf8618250973d9328e162ced\",\"devicecode\":\"M\",\"logintype\":\"mobile\"}"
//        String json="{\"loginname\":\"" + phonenumber + "\",\"password\":\""+ password +"\",\"devicecode\":\"M\",\"logintype\":\""+logintype+"\"}";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("loginname", phonenumber);
            jsonObject.put("password", password);
            jsonObject.put("devicecode", "M");
            jsonObject.put("logintype", logintype);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        requestBody = RequestBody.create(JSON, jsonObject.toString());

        HttpUtilPost.sendOkhttpRequest(address, requestBody, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //异常处理
                Looper.prepare();
                Toast.makeText(LoginActivity.this, "网络未连接或网络不稳定", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                //返回的数据
                String reposes = response.body().string();
                String data=null,username=null,height=null,education=null,avatar=null;
                int ageyear;
                Log.i("LoginActivityit520", reposes);
//                parseJsonWithPull(reposes);
                JSONObject jsonObject = null;
                JSONObject jsonObject1=null;
                try {


                    switch (code) {
                        case 0:
                            jsonObject = new JSONObject(reposes);
                            data=jsonObject.getString("data");
                            Log.i("LoginActivityit520", data);
                            code = jsonObject.getInt("code");
                            jsonObject1=new JSONObject(data);
                            username=jsonObject1.getString("username");
                            height=jsonObject1.getString("height");
                            ageyear=2019-jsonObject1.getInt("ageyear");
                            education=jsonObject1.getString("education");
                            avatar=jsonObject1.getString("avatar");
                            Log.i("LoginActivityit520", username+height+ageyear+education);
                            Db db = new Db(LoginActivity.this);
//                            //插入数据
                            SQLiteDatabase database=db.getReadableDatabase();
                            database.delete("user",null,null);
                            ContentValues cv=new ContentValues();
                            cv.put("height",height);
                            cv.put("ageyear",ageyear);
                            cv.put("education",education);
                            cv.put("username",username);
                            cv.put("avatar",avatar);

//                            cv.put("uploadfiles",uploadfiles);
                            database.insert("user",null,cv);
                            Looper.prepare();

                            Toast.makeText(LoginActivity.this, "成功登陆", Toast.LENGTH_SHORT).show();

                            Intent intent =new Intent(LoginActivity.this,MainActivity.class);

                            startActivity(intent);
                            Looper.loop();
                            break;
                        case 704:
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, "用户中心用户不存在", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                            break;
                        case 202:
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                            break;
                        case 231:
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, "登录名密码不能为空", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                            break;
                        case 4:
                            Looper.prepare();
                            Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                            break;
                    }
//                    if(phonenumber_et.getText().equals("equals(jsonObject.getInt(\"code\"))")){
//
//                    }else {
//                        Toast.makeText(LoginActivity.this, "shibai", Toast.LENGTH_SHORT).show();
//                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
