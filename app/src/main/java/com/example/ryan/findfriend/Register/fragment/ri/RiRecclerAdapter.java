package com.example.ryan.findfriend.Register.fragment.ri;

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
import com.example.ryan.findfriend.Register.PerfectfourActivity;
import com.example.ryan.findfriend.Register.PerfectsixActivity;
import com.example.ryan.findfriend.Register.PerfectthreeActivity;

import java.util.List;

public class RiRecclerAdapter extends RecyclerView.Adapter<RiRecclerAdapter.RiViewHolder> {
    private Context context;
    private List<String> list;
    private Intent intent;
    private String nian,yue,gender,sheng;
    private PerfectthreeActivity perfectthreeActivity;
    public RiRecclerAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
        this.perfectthreeActivity=(PerfectthreeActivity) context;
    }

    @NonNull
    @Override
    public RiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RiViewHolder(LayoutInflater.from(context).inflate(R.layout.ri_recycleview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final RiViewHolder riViewHolder, int i) {
        riViewHolder.ri.setText(list.get(i));
        intent=perfectthreeActivity.getIntent();
        nian=intent.getStringExtra("nian");
        yue=intent.getStringExtra("yue");
        gender=intent.getStringExtra("gender");
        sheng=intent.getStringExtra("sheng");
//        Toast.makeText(context,nian+yue+gender+sheng , Toast.LENGTH_SHORT).show();
        intent=new Intent(context,PerfectfourActivity.class);

                intent.putExtra("sheng",sheng);
        intent.putExtra("nian",nian);
        intent.putExtra("gender",gender);
        intent.putExtra("yue",yue);
        riViewHolder.ri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("ri",riViewHolder.ri.getText());

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class RiViewHolder extends RecyclerView.ViewHolder {
        TextView ri;
        public RiViewHolder(@NonNull View itemView) {
            super(itemView);
            ri=itemView.findViewById(R.id.ri);
        }
    }
}
