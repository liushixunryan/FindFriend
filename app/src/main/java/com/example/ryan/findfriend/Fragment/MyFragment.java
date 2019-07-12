package com.example.ryan.findfriend.Fragment;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.Adapter.MyFramentAdpater;
import com.example.ryan.findfriend.MainActivity;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.db.Db;
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
    TextView textView,textView2,textView3;
    String data=null,username=null,height=null,education=null,avatar=null,xueli=null;
    int ageyear;
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
        textView=view.findViewById(R.id.myusername);
        textView2=view.findViewById(R.id.dagex);
        textView3=view.findViewById(R.id.heightt);
        listView = view.findViewById(R.id.grz);
        myList = new ArrayList<>();
//        Toast.makeText(getContext(), "哈哈哈哈", Toast.LENGTH_SHORT).show();
        Db db=new Db(getContext());
        SQLiteDatabase dbread = db.getReadableDatabase();
        Cursor c = dbread.query("user", null, null, null, null, null, null);
        while (c.moveToNext()) {
            height = c.getString(c.getColumnIndex("height"));
//            data = c.getString(c.getColumnIndex("data"));
            education = c.getString(c.getColumnIndex("education"));
            avatar = c.getString(c.getColumnIndex("avatar"));
            username = c.getString(c.getColumnIndex("username"));
            ageyear= Integer.parseInt(c.getString(c.getColumnIndex("ageyear")));

            Log.i("harm", ageyear+"gggfdsfd");

        }
        switch (Integer.valueOf(education)){
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
        textView.setText(username);
        textView2.setText("沈阳"+"|"+ageyear+"|"+xueli);
        textView3.setText(height+"cm");
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

