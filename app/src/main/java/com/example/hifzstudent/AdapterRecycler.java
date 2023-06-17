package com.example.hifzstudent;
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

    public AdapterRecycler(ArrayList<Student> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.designrecycler,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.roll.setText(data.get(position).getRollNo());
        holder.name.setText(data.get(position).getName());
        holder.age.setText(data.get(position).getClas()+" " +data.get(position).getAge());
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
