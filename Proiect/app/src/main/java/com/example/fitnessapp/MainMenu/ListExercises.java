package com.example.fitnessapp.MainMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitnessapp.MainMenu.Adapter.RecyclerViewAdapter;
import com.example.fitnessapp.MainMenu.Model.Exercise;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;

public class ListExercises extends AppCompatActivity {


    List<Exercise> exercisesList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises2);

        initData();

        recyclerView = (RecyclerView) findViewById(R.id.list_ex);
        adapter= new RecyclerViewAdapter(exercisesList,getBaseContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {

        exercisesList.add(new Exercise(R.drawable.bench,"Bench press"));
        exercisesList.add(new Exercise(R.drawable.ohp,"Overhead press"));

    }
}