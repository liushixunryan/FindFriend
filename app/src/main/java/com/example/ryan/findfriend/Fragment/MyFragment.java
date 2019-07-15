package com.example.ryan.findfriend.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.content.DialogInterface;

import com.example.ryan.findfriend.Adapter.MyFramentAdpater;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.db.CustomHelper;
import com.example.ryan.findfriend.pojo.my;

import org.devio.takephoto.app.TakePhotoFragment;
import org.devio.takephoto.model.TResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harm on 2019/7/8.
 */

public class MyFragment extends TakePhotoFragment implements View.OnClickListener {
    private List<my> myList;
    private MyFramentAdpater myFramentAdpater;
    ListView listView;
    private CustomHelper customHelper;
    private AlertDialog alertDialog;

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


        customHelper = new CustomHelper();


        ImageView headImgView = view.findViewById(R.id.shangchuantouxiang);//控件的获取
        headImgView.setOnClickListener(MyFragment.this);

        for (int i = 0; i < strings.length; i++) {
            my my = new my();
            my.setImage1(ints[i]);
            my.setImage2(ints[i]);
            my.setName(strings[i]);
            myList.add(my);
        }
        myFramentAdpater=new MyFramentAdpater(getActivity(),R.layout.my,myList,listView);
        listView.setAdapter(myFramentAdpater);
        initDialog();
        return view;

    }

    /*
   初始化AlertDialog
    */
    public void initDialog()
    {
        //创建AlertDialog的构造器的对象
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("提示");
        builder.setMessage("请选择头像图片来源？");
        builder.setPositiveButton("拍 照", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                //第一个参数dialog是点击的确定按钮所属的Dialog对象,第二个参数which是按钮的标示值
              //  finish();//结束当前Activity
                customHelper.onClick(true, getTakePhoto());
            }
        });

        builder.setNeutralButton("相册",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which){
                customHelper.onClick(false, getTakePhoto());
            }
        });

        //builder.setNeutralButton("稍后提醒",null);
        alertDialog=builder.create();

    }

    public void onClick(View view){
        Toast.makeText(getContext(), "哈哈哈哈", Toast.LENGTH_SHORT).show();
        switch (view.getId()){
            case R.id.shangchuantouxiang:
                alertDialog.show();
                break;
        }
    }

    @Override
    public void takeCancel() {
        super.takeCancel();
    }

    @Override
    public void takeFail(TResult result, String msg) {
        super.takeFail(result, msg);
    }

    @Override
    public void takeSuccess(TResult result) {
        super.takeSuccess(result);
       // showImg(result.getImages());
    }



}

