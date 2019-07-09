package com.example.ryan.findfriend.Adapter;

/**
 * Created by harm on 2019/7/4.
 */

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
import com.example.ryan.findfriend.Register.PerfectfiveActivity;
import com.example.ryan.findfriend.Register.PerfectfourActivity;
import com.example.ryan.findfriend.Register.PerfectsixActivity;
import com.example.ryan.findfriend.Register.PerfectthreeActivity;

import java.util.List;

/**
 * Created by harm on 2019/7/4.
 */
public class ShengaoAdpater extends RecyclerView.Adapter<ShengaoAdpater.NianViewHolder> {
    private Context context;
    private List<String> list;
    private List<String> list1;
    private PerfectfourActivity perfectthreeActivity;
    private Intent editpro;
    private String gender,sheng,nian,yue,ri;
    public ShengaoAdpater(Context context, List<String> list,List<String>list1) {
        this.context=context;
        this.list=list;
        this.list1=list1;
        this.perfectthreeActivity=(PerfectfourActivity) context;
    }

    @NonNull
    @Override
    public NianViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new NianViewHolder(LayoutInflater.from(context).inflate(R.layout.nian_recycleview,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(final NianViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
        editpro=perfectthreeActivity.getIntent();
        Toast.makeText(context, editpro.getStringExtra("ri"), Toast.LENGTH_SHORT).show();
        gender=editpro.getStringExtra("gender");
        nian=editpro.getStringExtra("nian");

        yue=editpro.getStringExtra("yue");

        ri=editpro.getStringExtra("ri");

        sheng=editpro.getStringExtra("sheng");
        editpro=new Intent(context,PerfectfiveActivity.class);
        editpro.putExtra("gender",gender);

        editpro.putExtra("nian",nian);

        editpro.putExtra("yue",yue);

        editpro.putExtra("ri",ri);

        editpro.putExtra("sheng",sheng);


        int i=Integer.parseInt(list1.get(position));
        holder.textView1.setText(i+"");

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
//                Log.i("qweqweqwe","adapter");
//                Intent editpro=new Intent(context,PerfectoneActivity.class);
//                context.startActivity(editpro);
//                Fragment fragment=new YueThreeFragment();
//                FragmentManager manager = perfectthreeActivity.qweeqwe().getSupportFragmentManager();
//                android.support.v4.app.FragmentTransaction transaction=manager.beginTransaction();
//                transaction.replace(R.id.data,fragment);
//                transaction.commit();
                editpro.putExtra("height",holder.textView1.getText());

                context.startActivity(editpro);

            }
        });
        holder.textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editpro.putExtra("height",holder.textView2.getText());

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView2.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView3.getText());

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView3.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView4.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView4.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView5.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView5.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView6.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView6.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView7.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView7.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView8.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView8.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView9.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView9.getText() , Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                editpro=new Intent(context,PerfectsixActivity.class);
                editpro.putExtra("height",holder.textView10.getText());
//                editpro=new Intent(context, PerfectfiveActivity.class);

                context.startActivity(editpro);
//                Toast.makeText(context,holder.textView10.getText() , Toast.LENGTH_SHORT).show();
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
