package com.example.ryan.findfriend.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ryan.findfriend.Adapter.MyFramentAdpater;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.pojo.my;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harm on 2019/7/8.
 */

public class MyFragment extends Fragment {
    private List<my> myList;
    private MyFramentAdpater myFramentAdpater;
    ListView listView;
    private String[] strings = {"谁看过我", "赞过我","关注我","守护我","收到的礼物","我的钱包","会员中心","星级特权","直营门店","安全中心","设置"};
    private int[] ints = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground,
            R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground
            ,R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_foreground};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myframent, container, false);
        listView = view.findViewById(R.id.grz);
        myList = new ArrayList<>();
//        Toast.makeText(getContext(), "哈哈哈哈", Toast.LENGTH_SHORT).show();

        for (int i = 0; i < strings.length; i++) {
            my my = new my();
            my.setImage1(ints[i]);
            my.setImage2(ints[i]);
            my.setName(strings[i]);
            myList.add(my);
        }
        myFramentAdpater=new MyFramentAdpater(getActivity(),R.layout.my,myList,listView);
        listView.setAdapter(myFramentAdpater);
        return view;




    }
}

