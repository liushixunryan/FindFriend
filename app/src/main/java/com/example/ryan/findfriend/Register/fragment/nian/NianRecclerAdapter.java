package com.example.ryan.findfriend.Register.fragment.nian;

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
import com.example.ryan.findfriend.Register.fragment.yue.YueRecclerAdapter;

import java.util.List;

public class NianRecclerAdapter extends RecyclerView.Adapter<NianRecclerAdapter.NianViewHolder> {
    private Context context;
    private List<String> list;
    private List<String> list1;
    private PerfectthreeActivity perfectthreeActivity;
    private Intent intent;
    String gender,sheng;
    public NianRecclerAdapter(Context context, List<String> list,List<String>list1) {
        this.context=context;
        this.list=list;
        this.list1=list1;
        this.perfectthreeActivity= (PerfectthreeActivity) context;
    }

    @NonNull
    @Override
    public NianViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NianViewHolder(LayoutInflater.from(context).inflate(R.layout.nian_recycleview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(final NianViewHolder holder, int position) {
        holder.textView.setText(list.get(position));

        int i=Integer.parseInt(list1.get(position));
        holder.textView1.setText(i+"");
        intent=perfectthreeActivity.getIntent();
        gender=intent.getStringExtra("gender");
        sheng=intent.getStringExtra("sheng");
//        intent.putExtra("sheng",sheng);
//        intent.putExtra("gender",gender);
        Toast.makeText(context, gender+sheng, Toast.LENGTH_SHORT).show();
        i=i+1;
        holder.textView2.setText(i+"");
        i=i+1;
        holder.textView3.setText(i+"");
        i=i+1;
        holder.textView4.setText(i+"");
        i=i+1;
        holder.textView5.setText(i+"");
        i=i+1;
        holder.textView6.setText(i+"");
        i=i+1;
        holder.textView7.setText(i+"");
        i=i+1;
        holder.textView8.setText(i+"");
        i=i+1;
        holder.textView9.setText(i+"");
        i=i+1;
        holder.textView10.setText(i+"");


        holder.textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //外部直接调用方法,跳转到月

                perfectthreeActivity.TiaoYue();
//                Log.i("qweqweqwe","adapter");
//                Intent editpro=new Intent(context,PerfectoneActivity.class);
//                context.startActivity(editpro);

//                Log.i("qweqweqwe","adapter");
//                Intent editpro=new Intent(context,PerfectoneActivity.class);
//                context.startActivity(editpro);
//                Fragment fragment=new YueThreeFragment();
//                FragmentManager manager = perfectthreeActivity.qweeqwe().getSupportFragmentManager();
//                android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
//                transaction.replace(R.id.data,fragment);
//                transaction.commit();


                intent.putExtra("nian",holder.textView1.getText());


                Toast.makeText(context,sheng , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView2.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView2.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView3.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView3.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView4.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView4.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView5.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView5.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView6.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView6.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView7.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView7.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView8.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView8.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView9.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView9.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                intent.putExtra("nian",holder.textView10.getText());
                perfectthreeActivity.TiaoYue();
                Toast.makeText(context,holder.textView10.getText() , Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return  list.size();
    }

    public class NianViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView textView1;
        TextView textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;
        public NianViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.hhhhhh);
            textView1=itemView.findViewById(R.id.bai);
            textView2=itemView.findViewById(R.id.ye);
            textView3=itemView.findViewById(R.id.ye1);
            textView4=itemView.findViewById(R.id.ye2);
            textView5=itemView.findViewById(R.id.ye3);
            textView6=itemView.findViewById(R.id.ye4);
            textView7=itemView.findViewById(R.id.ye5);
            textView8=itemView.findViewById(R.id.ye6);
            textView9=itemView.findViewById(R.id.ye7);
            textView10=itemView.findViewById(R.id.ye8);

        }
    }

}
