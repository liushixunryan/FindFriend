package com.example.ryan.findfriend.Fragment;

import android.content.Intent;
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
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.Adapter.MyPagerAdapter;
import com.example.ryan.findfriend.Adapter.TuiJianAdapter;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.SouSuoActivity;
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
    private Handler handler;
    private ListView jinrituijian_lv;
    private TuiJianAdapter tuiJianAdapter;
    private List<TuiJianData> data;
    private Intent intent;
    //下拉刷新组件
    private SwipeRefreshLayout swipe_ly;
    private String wangzhi="http://leszhenai.com/";
    private int EDUTATION;
    private String xueli=null;
    private TextView sousuo;;
    private int countrecord = 10;
    private int nbottomcount = 0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_recommend,container,false);
        sousuo=view.findViewById(R.id.sousuo);

        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SouSuoActivity.class);
                startActivity(intent);
            }
        });
//        intent=getActivity().getIntent();
        data =  new ArrayList<>();
        boolean binit = false;
        jinrituijian_lv=view.findViewById(R.id.jinrituijian_lv);
        swipe_ly=view.findViewById(R.id.swipe_ly);
        //轮播图
        Slideshow();
        //显示推荐
        int num=(int)(0+Math.random()*(50-1+1));
        ShowTuijian(true,num,countrecord);
        //下拉和上拉加载
        updown();

        //while (data==null){
     //   }
        tuiJianAdapter=new TuiJianAdapter(getContext(),R.layout.tuijian_adapter,data,jinrituijian_lv);
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if (msg.what==1){
                    tuiJianAdapter.notifyDataSetChanged();
                }
            }
        };
        jinrituijian_lv.setAdapter(tuiJianAdapter);


        binit = true; //初始化完成
        return view;

    }

    private void updown() {
        swipe_ly.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                handler1.sendEmptyMessageDelayed(199,1000);
            }
        });

        jinrituijian_lv.setOnScrollListener(new AbsListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        if (view.getLastVisiblePosition() == (view.getCount()-1)) {
                            Toast.makeText(getActivity(), "滑倒底部", Toast.LENGTH_SHORT).show();
                            nbottomcount++;
                            if(nbottomcount > 1){
                                int num=(int)(100+Math.random()*(300-1+1));
                                ShowTuijian(false, num,countrecord);
                                nbottomcount =0 ;
                            }

                            // 可添加操作
                        }else
                            if(view.getFirstVisiblePosition() ==0){
                            Toast.makeText(getActivity(), "滑倒顶部", Toast.LENGTH_SHORT).show();

                        }
                        break;
                }

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                View firstView = view.getChildAt(firstVisibleItem);
                if(firstVisibleItem ==0 && (firstView == null || firstView.getTop() == 0))
                {
                    /*上滑到listView的顶部时，下拉刷新组件可见*/
                    swipe_ly.setEnabled(true);
                }
                else
                {
                    /*不是listView的顶部时，下拉刷新组件不可见*/
                    swipe_ly.setEnabled(false);
                }
            }
        });

    }

    private void ShowTuijian(boolean btop, int nbeg, int nCount) {

       if(btop){
            if(data != null){
                data.clear();
           }
       }
        final JSONObject jsonObject=new JSONObject();
        try {
            jsonObject.put("beg",nbeg);
            jsonObject.put("count",nCount);
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
                try {
                    ///data=new ArrayList<>();

                    JSONObject jsonObject1 = new JSONObject(repose);
                    String data1=jsonObject1.optString("data");
                    JSONArray jsonArray=new JSONArray(data1);
                    for (int i=0;i<jsonArray.length();i++){
                        String qwe= jsonArray.get(i).toString();
                        jsonObject1=new JSONObject(jsonArray.get(i).toString());
                        TuiJianData t=new TuiJianData();

//                        Log.i("it520", jsonObject1.getInt("ageyear")+"");
                        String age= String.valueOf(2019-jsonObject1.getInt("ageyear"));
                        t.setAge_tv(age+"岁");
                        t.setHeadphoto_img(wangzhi+jsonObject1.getString("avatar"));
                        t.setUsername_tv(jsonObject1.getString("username"));
                        t.setHeight_tv(jsonObject1.getString("height"));
                        Log.i("it520", jsonObject1.getInt("education")+"");
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
                        t.setEducation_tv(xueli);
                        data.add(t);
                    }

                    handler.sendEmptyMessage(1);
                }catch (JSONException e) {
                    e.printStackTrace();
                }

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

    private Handler handler1=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==199){
                int num=(int)(50+Math.random()*(100-1+1));
                ShowTuijian(true,num,10);
                tuiJianAdapter.notifyDataSetChanged();
                //设置组件的刷洗状态；false代表关闭
                swipe_ly.setRefreshing(false);
            }
        }
    };
}
