package com.example.ryan.findfriend;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ryan.findfriend.Fragment.JingZhunssFragment;
import com.example.ryan.findfriend.Fragment.TiaoJianssFragment;

import java.util.ArrayList;
import java.util.List;

public class SouSuoActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Button button1,button2;
    private TextView textView1,textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sou_suo);
        viewPager=findViewById(R.id.viewpage);
        textView1=findViewById(R.id.dyi);
        textView2=findViewById(R.id.der);
        button1=findViewById(R.id.yi);
        button2=findViewById(R.id.er);


        final List<Fragment> fragmentList=new ArrayList<>();
        fragmentList.add(new TiaoJianssFragment());
        fragmentList.add(new JingZhunssFragment());
        final List<TextView> textViewList=new ArrayList<>();
        textViewList.add(textView1);
        textViewList.add(textView2);
        final List<Button> buttonList=new ArrayList<>();
        buttonList.add(button1);
        buttonList.add(button2);

        PagerAdapter pagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(Button button:buttonList){
                    button.setBackgroundColor(Color.WHITE);
                    button.setTextColor(Color.BLACK);
                }
                for (TextView textView:textViewList){
                    textView.setBackgroundColor(Color.BLACK);
                }
                switch (position){
                    case 0:
                        button1.setTextColor(Color.YELLOW);
                        textView1.setBackgroundColor(Color.YELLOW);
                        break;
                    case 1:
                        button2.setTextColor(Color.YELLOW);
                        textView2.setBackgroundColor(Color.YELLOW);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        button1.setTextColor(Color.YELLOW);
        textView1.setTextColor(Color.BLACK);
        textView1.setBackgroundColor(Color.WHITE);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
                button1.setTextColor(Color.YELLOW);
                textView1.setBackgroundColor(Color.YELLOW);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
                button2.setTextColor(Color.YELLOW);
                textView2.setBackgroundColor(Color.YELLOW);

            }
        });
    }
}
