package com.example.ryan.findfriend.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.Util.HttpUtilPost;
import com.example.ryan.findfriend.pojo.TuiJianData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JingZhunssFragment extends Fragment {
    private String imgurl;
    private String user,city,age,height;
    private String  address="http://192.168.1.102:20100/home/searchuid";
    private RequestBody requestBody;
    private MediaType JSON= MediaType.get("application/json; charset=utf-8");
    private ImageView headphoto_img;
    private TextView username_tv,city_tv,age_tv,education_tv,height_tv;
    private Button select_btn;
    private View view;
    private Handler handler;
    private RelativeLayout xiaoshi;
    private EditText inputID_et;
    private int EDUTATION;
    private String xueli;
    private String wangzhi="http://leszhenai.com/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_jingzhun,container,false);
        init();
        select_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputID= inputID_et.getText().toString();
                JSONObject jsonObject = new JSONObject();
                try {
//                    jsonObject.put("userid",inputID);
                    jsonObject.put("userid",inputID);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                requestBody = RequestBody.create(JSON, jsonObject.toString());
                HttpUtilPost.sendOkhttpRequest(address, requestBody, new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {

                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        String reposes = response.body().string();
                        Log.i("LoginActivity", reposes);
                        try {
                            JSONObject jsonObject1 = new JSONObject(reposes);
                            String data1=jsonObject1.optString("data");
                            JSONArray jsonArray=new JSONArray(data1);
                            for (int i=0;i<jsonArray.length();i++){
                                String qwe= jsonArray.get(i).toString();
                                Log.i("it520", qwe);
                                jsonObject1=new JSONObject(jsonArray.get(i).toString());

                                imgurl=wangzhi+jsonObject1.getString("avatar");
//                                username_tv.setText(jsonObject1.getString("username"));
                                user=jsonObject1.getString("username");
//                                city_tv.setText(jsonObject1.getString("沈阳"));
//                                city=jsonObject1.getString("沈阳");
                                age= String.valueOf(2019-jsonObject1.getInt("ageyear"));
//                                age_tv.setText(age);
//                                Log.i("it520", jsonObject1.getInt("education")+"");
                                EDUTATION=jsonObject1.getInt("education");
                                switch (EDUTATION){
                                    case 1:
                                        xueli="中专以下学历";
                                        break;
                                    case 2:
                                        xueli="中专";
                                        break;
                                    case 3:
                                        xueli="大专";
                                        break;
                                    case 4:
                                        xueli="本科";
                                        break;
                                    case 5:
                                        xueli="硕士";
                                        break;
                                    case 6:
                                        xueli="博士";
                                        break;
                                    case 7:
                                        xueli="博士后";
                                        break;
                                }
//                                education_tv.setText(xueli);
                                height= String.valueOf(jsonObject1.getInt("height"));
                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(1);
                    }

                });
                xiaoshi.setVisibility(View.VISIBLE);
            }
        });

        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==1){
                    Glide.with(getContext()).load(imgurl).into(headphoto_img);
                    username_tv.setText(user);
                    city_tv.setText("shenyang");
                    age_tv.setText(age+"");
                    education_tv.setText(xueli);
                    height_tv.setText(height);
                }
            }
        };


        return view;
    }

    private void init() {
        inputID_et=view.findViewById(R.id.inputID_et);
        select_btn=view.findViewById(R.id.select_btn);
        xiaoshi=view.findViewById(R.id.xiaoshi);
        headphoto_img=view.findViewById(R.id.headphoto_img);
        username_tv=view.findViewById(R.id.username_tv);
        city_tv=view.findViewById(R.id.city_tv);
        age_tv=view.findViewById(R.id.age_tv);
        education_tv=view.findViewById(R.id.education_tv);
        height_tv=view.findViewById(R.id.height_tv);
    }


}
