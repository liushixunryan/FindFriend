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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.MainActivity;
import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.pojo.my;

import java.util.List;

/**
 * Created by harm on 2019/7/8.
 */

public class MyFramentAdpater extends ArrayAdapter<my> {
    private Context context;
    private int resource;
    private List<my> myList;
    private ListView listView;
    private LinearLayout linearLayout;
    private MainActivity mainActivity;
    public MyFramentAdpater(@NonNull Context context, int resource, List<my> myList, ListView listView) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.myList=myList;
        this.listView=listView;
    }
    @NonNull
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Nullable
    @Override
    public my getItem(int position) {
        return myList.get(position);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(this.getContext()).inflate(resource,parent,false);
        ImageView imageView1=convertView.findViewById(R.id.tt1);
        ImageView imageView2=convertView.findViewById(R.id.tt2);
        final TextView textView=convertView.findViewById(R.id.zzz);

        imageView1.setImageResource(myList.get(position).getImage1());
        imageView2.setImageResource(myList.get(position).getImage2());
        textView.setText(myList.get(position).getName());
        linearLayout=convertView.findViewById(R.id.hhh);
//        String dian=textView.getText().toString();
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Toast.makeText(context, "开发中", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(context, SkgwActivity.class);
//                        context.startActivity(intent);
                        break;
                        case 1:
                            Toast.makeText(context, "sss", Toast.LENGTH_SHORT).show();
                            break;
                    case 2:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;

                    case 6:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;
                    case 10:
                        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
                        break;


                }
//                if (textView.getText().equals("谁看过我")){
//                    Intent intent=new Intent(context, SkgwActivity.class);
//                   context.startActivity(intent);
//                }
//                else {
//                    Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show();
//                }

            }
        });
        return convertView;
    }


}