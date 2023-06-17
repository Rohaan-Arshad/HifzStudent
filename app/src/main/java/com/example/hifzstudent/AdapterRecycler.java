package com.example.hifzstudent;
import android.content.Context;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder>
{

    ArrayList<Student> data;
    Context c;
    public AdapterRecycler(ArrayList<Student> data,Context c) {
        this.data = data;
        this.c=c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designrecycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Student temp = data.get(position);

        holder.roll.setText(data.get(position).getRollNo());
        holder.name.setText(data.get(position).getName());
        holder.age.setText(data.get(position).getClas()+"   " +data.get(position).getAge());

        holder.roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ig =new Intent(c,MainActivity4.class);
                ig.putExtra("rol",temp.getRollNo());
                ig.putExtra("nam",temp.getName());
                ig.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                c.startActivity(ig);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
            TextView roll,name,age;

            public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                roll = (TextView) itemView.findViewById(R.id.displayname);
                name = (TextView) itemView.findViewById(R.id.displaycontact);
                age = (TextView) itemView.findViewById(R.id.displayemail);
            }
    }
}
