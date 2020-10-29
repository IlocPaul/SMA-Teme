package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Tema2 extends AppCompatActivity {

    private ArrayList<ExampleItem> mExampleList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button buttonInsert;
    private Button buttonRemove;
    private EditText editTextInsert;
    private EditText editTextRemove;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tema2);

        getSupportActionBar().setTitle("Tema 2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        createExampleList();
        buildRecyclerView();

        buttonInsert = findViewById(R.id.button_insert);
        buttonRemove = findViewById(R.id.button_remove);
        editTextInsert = findViewById(R.id.edittext_insert);
        editTextRemove = findViewById(R.id.edittext_remove);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextInsert.getText().toString());
                insertItem(position);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextRemove.getText().toString());
                removeItem(position);
            }
        });
    }
    public void insertItem(int position) {
        mExampleList.add(position, new ExampleItem(R.drawable.ic_fire, "New Item At Line " + position, "This is a new line"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mExampleList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void createExampleList() {
        mExampleList = new ArrayList<>();
        mExampleList.add(new ExampleItem(R.drawable.ic_fire, "Line 1", "Line 2"));
        mExampleList.add(new ExampleItem(R.drawable.ic_bell, "Line 3", "Line 4"));
        mExampleList.add(new ExampleItem(R.drawable.ic_face, "Line 5", "Line 6"));
    }

    public void buildRecyclerView() {
        //initialize recycle view
        mRecyclerView = findViewById(R.id.recyclerView);
        //performance
        mRecyclerView.setHasFixedSize(true);
        //initialize
        mLayoutManager = new LinearLayoutManager(this);
        //we pass the list to the adapter and the adapter passes the list to the view holder
        mAdapter = new ExampleAdapter(mExampleList);
        //le punem in view sa ni le afiseze
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}