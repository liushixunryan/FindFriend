package com.example.ryan.findfriend.Register.fragment.yue;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ryan.findfriend.R;
import com.example.ryan.findfriend.Register.CreatActivity;
import com.example.ryan.findfriend.Register.PerfectsixActivity;
import com.example.ryan.findfriend.Register.PerfectthreeActivity;
import com.example.ryan.findfriend.Register.fragment.ri.RiRecclerAdapter;

import java.util.List;

public class YueRecclerAdapter extends RecyclerView.Adapter<YueRecclerAdapter.YueViewHolder> {
    private Context context;
    private List<String> list;
    private PerfectthreeActivity perfectthreeActivity;
    private Intent intent;
    private String nian,gender,sheng;
    public YueRecclerAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        this.perfectthreeActivity= (PerfectthreeActivity) context;
    }

    @NonNull
    @Override
    public YueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new YueViewHolder(LayoutInflater.from(context).inflate(R.layout.yue_recycleview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final YueViewHolder yueViewHolder, int i) {
        yueViewHolder.yue.setText(list.get(i));
        intent=perfectthreeActivity.getIntent();
        sheng=intent.getStringExtra("sheng");
        nian=intent.getStringExtra("nian");
        gender=intent.getStringExtra("gender");
//        Toast.makeText(context, gender+sheng+nian, Toast.LENGTH_SHORT).show();
//        intent=new Intent(context,RiRecclerAdapter.class);
//        intent.putExtra("sheng",sheng);
//        intent.putExtra("nian",nian);
//        intent.putExtra("gender",gender);

        yueViewHolder.yue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("yue",yueViewHolder.yue.getText());
                perfectthreeActivity.TiaoRi();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class YueViewHolder extends RecyclerView.ViewHolder {
        TextView yue;
        public YueViewHolder(@NonNull View itemView) {
            super(itemView);
            yue=itemView.findViewById(R.id.yue);
        }
    }
}
