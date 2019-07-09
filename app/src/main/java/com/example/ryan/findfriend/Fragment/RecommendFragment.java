package com.example.ryan.findfriend.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ryan.findfriend.Adapter.MyPagerAdapter;
import com.example.ryan.findfriend.Adapter.TuiJianAdapter;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.Util.HttpUtilPost;
import com.example.ryan.findfriend.pojo.TuiJianData;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.Response;

public class RecommendFragment extends Fragment {
    private String address="http://192.168.1.101:20100/home/lasturs";
    private MediaType JSON= MediaType.get("application/json; charset=utf-8");
    private RequestBody requestBody;
    private View view;
    private ViewPager view_pager;
    private ArrayList<View> aList;
    private MyPagerAdapter mAdapter;
    private boolean handler;
    private ListView jinrituijian_lv;
    private TuiJianAdapter tuiJianAdapter;
    private List<TuiJianData> data=new ArrayList<>();
    //下拉刷新组件
    private SwipeRefreshLayout swipe_ly;

    //模拟数据
    private Integer[] Headphoto_img = {R.mipmap.tuijian1,R.mipmap.tuijian21};
    private String Username_tv [] ={ "可爱Baby","林多多"};
    private String City_tv[]={"沈阳","沈阳"};
    private String Education_tv[]={"大学本科","专科"};
    private int[] Age_tv={22,25};
    private String Geqian_lv[]={"回眸一笑百媚生","回眸一笑百媚生"};
    private Integer[] Geqian_img = {R.mipmap.tuijian1,R.mipmap.tuijian21};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_recommend,container,false);
        jinrituijian_lv=view.findViewById(R.id.jinrituijian_lv);


        //轮播图
        Slideshow();
        //显示推荐
        ShowTuijian();
        //下拉刷新
        Dropdownrefresh();

        return view;
    }

    private void ShowTuijian() {
        final JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("beg",0);
            jsonObject.put("count",5);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        requestBody = RequestBody.create(JSON, jsonObject.toString());
        HttpUtilPost.sendOkhttpRequest(address, requestBody, new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.d("it520", "失败");
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String repose=response.body().string();
                Log.i("it520", repose);

                tuiJianAdapter=new TuiJianAdapter(getContext(),R.layout.tuijian_adapter,data,jinrituijian_lv);

                JSONObject jsonObject1= null;
                try {
                    jsonObject1 = new JSONObject(repose);
                    String data=jsonObject1.optString("data");
                    JSONArray jsonArray=null;
                    jsonArray=new JSONArray(data);
                    jsonArray.get(0).toString();
                    jsonObject1=new JSONObject(jsonArray.get(0).toString());

//                    for (int i = 0; i <Username_tv.length ; i++) {
//                    TuiJianData t=new TuiJianData();
//                    t.setHeadphoto_img(Integer.valueOf(jsonObject1.getString("www.leszhenai.com/"+"avatar")));
//                    t.setUsername_tv(jsonObject1.getString("username"));
//                    t.setVip_img(Headphoto_img[i]);
//                    t.setCity_tv(City_tv[i]);
//                    t.setAge_tv(Age_tv[i]+"岁");
//                    t.setEducation_tv(Education_tv[i]);
//                    t.setGeqian_img(Geqian_img[i]);
//                    t.setGeqian_lv(Geqian_lv[i]);
//                    data.add(c);
//                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }
//
//                tuiJianAdapter=new TuiJianAdapter(getContext(),R.layout.tuijian_adapter,data,jinrituijian_lv);
//                jinrituijian_lv.setAdapter(tuiJianAdapter);
//                Looper.prepare();
//                handler=new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//
//
//                    }
//                },3000);



            }
        });
    }

    private void Dropdownrefresh() {

        swipe_ly=view.findViewById(R.id.swipe_ly);
        swipe_ly.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler=new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data=new ArrayList<>();
                        tuiJianAdapter=new TuiJianAdapter(getContext(),R.layout.tuijian_adapter,data,jinrituijian_lv);
                        for (int i = 0; i <Username_tv.length ; i++) {
                            TuiJianData c=new TuiJianData();
                            c.setHeadphoto_img(Headphoto_img[i]);
                            c.setUsername_tv(Username_tv[i]);
                            c.setVip_img(Headphoto_img[i]);
                            c.setCity_tv(City_tv[i]);
                            c.setAge_tv(Age_tv[i]+"岁");
                            c.setEducation_tv(Education_tv[i]);
                            c.setGeqian_img(Geqian_img[i]);
                            c.setGeqian_lv(Geqian_lv[i]);
                            data.add(c);
                        }
                        tuiJianAdapter=new TuiJianAdapter(getContext(),R.layout.tuijian_adapter,data,jinrituijian_lv);
                        jinrituijian_lv.setAdapter(tuiJianAdapter);
                        swipe_ly.setRefreshing(false);
                    }
                },3000);

                Toast.makeText(getActivity(), "qweqwe", Toast.LENGTH_SHORT).show();
                Looper.loop();
            }
        });

    }

    private void Slideshow() {
        //轮播图
        view_pager=view.findViewById(R.id.view_pager);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.slideshow_one,null,false));
        aList.add(li.inflate(R.layout.slideshow_two,null,false));
        aList.add(li.inflate(R.layout.slideshow_three,null,false));
        mAdapter=new MyPagerAdapter(aList);
        view_pager.setAdapter(mAdapter);
    }
}
