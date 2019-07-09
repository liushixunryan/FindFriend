package com.example.ryan.findfriend.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.pojo.TuiJianData;

import java.util.List;

public class TuiJianAdapter extends ArrayAdapter<TuiJianData> {
    private Context context;
    private int resource;
    private List<TuiJianData> tuiJianData;
    private ListView listView;
    public TuiJianAdapter(@NonNull Context context, int resource, List<TuiJianData> tuiJianData, ListView listView) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.tuiJianData=tuiJianData;
        this.listView=listView;
    }


    @Override
    public int getCount() {
        return tuiJianData.size();
    }


    @Nullable
    @Override
    public TuiJianData getItem(int position) {
        return tuiJianData.get(position );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
        if (convertView==null){
            convertView=LayoutInflater.from(this.getContext()).inflate(resource,parent,false);
        }
        RelativeLayout tuijiandataRl;
        ImageView headphoto_img,vip_img,geqian_img;
        TextView username_tv,city_tv,age_tv,education_tv,height_tv,geqian_lv;

        tuijiandataRl=convertView.findViewById(R.id.tuijiandataRl);
        headphoto_img=convertView.findViewById(R.id.headphoto_img);
        vip_img=convertView.findViewById(R.id.vip_img);
        geqian_img=convertView.findViewById(R.id.geqian_img);
        username_tv=convertView.findViewById(R.id.username_tv);
        city_tv=convertView.findViewById(R.id.city_tv);
        age_tv=convertView.findViewById(R.id.age_tv);
        education_tv=convertView.findViewById(R.id.education_tv);
        height_tv=convertView.findViewById(R.id.height_tv);
        geqian_lv=convertView.findViewById(R.id.geqian_lv);

        headphoto_img.setImageResource(tuiJianData.get(position).getHeadphoto_img());
        vip_img.setImageResource(tuiJianData.get(position).getVip_img());
        geqian_img.setImageResource(tuiJianData.get(position).getGeqian_img());
        username_tv.setText(tuiJianData.get(position).getUsername_tv());
        city_tv.setText(tuiJianData.get(position).getCity_tv());
        age_tv.setText(tuiJianData.get(position).getAge_tv());
        education_tv.setText(tuiJianData.get(position).getEducation_tv());
        height_tv.setText(tuiJianData.get(position).getHeight_tv());
        geqian_lv.setText(tuiJianData.get(position).getGeqian_lv());

        tuijiandataRl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return convertView;
    }

}
