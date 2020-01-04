package com.example.studentdiary2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class feespaidadeptor extends RecyclerView.Adapter<feespaidadeptor.ViewHolder> {

    List <Model> list=new ArrayList<>();

    public void add(Model s){

        list.add(s);


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listviewforfeespaid,parent,false);

        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.t1.setText(list.get(position).getE11());

        holder.t2.setText(list.get(position).getE21());

        holder.t3.setText(list.get(position).getE31());

        holder.t4.setText(list.get(position).getE41()
        );

        holder.t5.setText(list.get(position).getE51());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView t1,t2,t3,t4,t5;

         ViewHolder(@NonNull View itemView) {
            super(itemView);

            t1=itemView.findViewById(R.id.t1);
            t2=itemView.findViewById(R.id.t2);
             t3=itemView.findViewById(R.id.t3);
             t4=itemView.findViewById(R.id.t4);
             t5=itemView.findViewById(R.id.t5);


        }
    }
}

