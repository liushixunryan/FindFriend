package com.example.ryan.findfriend.Register.fragment.nian;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.findfriend.R;

import java.util.ArrayList;
import java.util.List;

public class NianThreeFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    private List<String> list,list2;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_nian,container,false);

        init();

        return view;
    }



    private void init() {

        recyclerView=view.findViewById(R.id.recy);
//        recyclerView1=findViewById(R.id.recy1);
        list2=new ArrayList<>();
        list2.add("1930");
        list2.add("1940");
        list2.add("1950");
        list2.add("1960");
        list2.add("1970");
        list2.add("1980");
        list2.add("1990");
        list2.add("2000");
        list=new ArrayList<>();
        list.add("30后");
        list.add("40后");
        list.add("50后");
        list.add("60后");
        list.add("70后");
        list.add("80后");
        list.add("90后");
        list.add("00后");
//        list2=new ArrayList<>();
//        list2.add("hhh");
//        list2.add("hhh");
//        list2.add("hhh");
//        list2.add("hhh");
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),1);
//        GridLayoutManager gridLayoutManager2=new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
//        recyclerView1.setLayoutManager(gridLayoutManager2);
        NianRecclerAdapter hslbAdpater=new NianRecclerAdapter(getActivity(),list,list2);
//        hslb2Adpater hslb2Adpater=new hslb2Adpater(this,list2);
        recyclerView.setAdapter(hslbAdpater);

    }
//    TextView bai=view.findViewById(R.id.bai);


}
