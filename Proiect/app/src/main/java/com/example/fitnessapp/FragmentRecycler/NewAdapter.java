package com.example.fitnessapp.FragmentRecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fitnessapp.R;

import java.util.List;

//used to insert items in recycler view
public class NewAdapter extends RecyclerView.Adapter<NewAdapter.ViewHolder> {


    List<ModalClass> mList;
    Context context;

    public NewAdapter(List<ModalClass> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //returns a view from the selected layout
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_file,parent, false);


        return new ViewHolder(view);
    }

    //holds item from recycler
    //used to update the contents of the itemView to reflect the item at the given position.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(mList.get(position).getImage());
        holder.textView.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        //returns items from recycler
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView= itemView.findViewById(R.id.layoutImageId);
            textView = itemView.findViewById(R.id.nameTextViewId);

        }
    }
}
