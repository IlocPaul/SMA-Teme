package com.example.fitnessapp.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import com.example.fitnessapp.R;
public class RecyclerViewMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    //arrays with exercises & images
    String s1[],s2[];
    int images[]={R.drawable.bench,R.drawable.ohp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_main);

        //id of recyclerview
        recyclerView = findViewById(R.id.recyclerView);

        //store strings of exercises & description
        s1 = getResources().getStringArray(R.array.List_of_Exercises);
        s2 = getResources().getStringArray(R.array.description);


        Adapter adapter = new Adapter(this,s1,s2,images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}