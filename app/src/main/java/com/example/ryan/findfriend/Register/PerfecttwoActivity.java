package com.example.ryan.findfriend.Register;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.Guangbo;
import com.example.ryan.findfriend.R;
//import com.example.ryan.findfriend.pojo.Data;
import com.lljjcoder.citypickerview.widget.CityPicker;


public class PerfecttwoActivity extends AppCompatActivity {
    private TextView mContent;
    private Intent intent;
    private String youbian,gender;
    int code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfecttwo);
        TextView mBtn = findViewById(R.id.tv_btn);
        mContent =findViewById(R.id.tv_content);
       intent=getIntent();
       gender=intent.getStringExtra("gender");
        intent=new Intent(PerfecttwoActivity.this,PerfectthreeActivity.class);

        intent.putExtra("gender",gender);
//        Data data=new Data();
//        String genter=data.getGender();
        Toast.makeText(this,gender+"", Toast.LENGTH_SHORT).show();
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAddress();
            }
        });
    }


    private void getAddress()   {
        CityPicker cityPicker=new CityPicker.Builder(PerfecttwoActivity.this)
                .textSize(14)
                .title("地址选择")
                .titleBackgroundColor("#FFFFFF")
                .confirTextColor("#696969")
                .cancelTextColor("#696969")
                .province("辽宁省")
                .city("沈阳市")
                .district("沈河区")
                .textColor(Color.parseColor("#000000"))
                .provinceCyclic(true)
                .cityCyclic(false)
                .districtCyclic(false)
                .visibleItemsCount(7)
                .itemPadding(10)
                .onlyShowProvinceAndCity(false)
                .build();
        cityPicker.show();

        //监听事件，获取结果
        cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener()   {
            @Override
            public void onSelected(String...   citySelected)   {
                //省份
                String province = citySelected[0];

                //城市
                String city =citySelected[1];
                //区县（如果设定了两级联动，那么该项返回空）
                String district = citySelected[2];
                //邮编
                String code = citySelected[3];
                youbian=code;
                //为展示区赋值
                mContent.setText(province.trim()   +   "-"   +   city.trim()   +   "-"   +   district.trim());

            }
        });

    }

    public void xiayibu(View view) {
//        intent=new Intent(PerfecttwoActivity.this,CreatActivity.class);
        if (youbian == null){
            Toast.makeText(this, "请点击选择地址", Toast.LENGTH_SHORT).show();
        }
        else{
            intent.putExtra("sheng",youbian);
            startActivity(intent);

        }
    }

    public void onback(View view) {
        onBackPressed();
    }
}
