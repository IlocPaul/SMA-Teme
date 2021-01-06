package com.example.fitnessapp.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    //hold values that are passed trough constructor
    String data1[],data2[];
    int images[];
    Context context;


  public Adapter (Context ct, String s1[], String s2[], int img[])

    {   context = ct;
        data1=s1;
        data2=s2;
        images=img;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Text1.setText(data1[position]);
        holder.Text2.setText(data2[position]);
        holder.Image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }


     public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView Text1, Text2;
        ImageView Image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Text1= itemView.findViewById(R.id.exercises_list_id);
            Text2= itemView.findViewById(R.id.description_id);
            Image= itemView.findViewById(R.id.imageView_id);

        }


    }

}
