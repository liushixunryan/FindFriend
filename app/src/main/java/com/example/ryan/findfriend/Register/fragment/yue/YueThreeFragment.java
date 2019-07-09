package com.example.ryan.findfriend.Register.fragment.yue;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ryan.findfriend.R;

import java.util.ArrayList;
import java.util.List;

public class YueThreeFragment extends Fragment {
    private RecyclerView yuedata_rv;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            view=inflater.inflate(R.layout.fragment_yue,container,false);
        init();
        return view;
    }

    private void init() {
        yuedata_rv=view.findViewById(R.id.yuedata_rv);

        final List<String> item = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            item.add("" + i);
        }
        yuedata_rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);

        yuedata_rv.setLayoutManager(manager);


        YueRecclerAdapter adapter = new YueRecclerAdapter(getActivity(), item);


        yuedata_rv.setAdapter(adapter);

    }
}
