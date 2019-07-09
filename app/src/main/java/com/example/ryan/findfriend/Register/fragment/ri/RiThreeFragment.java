package com.example.ryan.findfriend.Register.fragment.ri;

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

public class RiThreeFragment extends Fragment {
    private RecyclerView ridata_rv;
    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_ri,container,false);
        init();
        return view;
    }

    private void init() {

        ridata_rv=view.findViewById(R.id.ridata_rv);

        final List<String> item = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            item.add("" + i);
        }
        ridata_rv.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);

        ridata_rv.setLayoutManager(manager);


        RiRecclerAdapter adapter = new RiRecclerAdapter(getActivity(), item);


        ridata_rv.setAdapter(adapter);
    }
}
