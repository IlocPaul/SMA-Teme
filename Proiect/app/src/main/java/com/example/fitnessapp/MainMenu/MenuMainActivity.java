package com.example.fitnessapp.MainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapp.FragmentRecycler.FragmentRecyclerMainActivity;
import com.example.fitnessapp.MainActivity;
import com.example.fitnessapp.MainMenu.Adapter.RecyclerViewAdapter;
import com.example.fitnessapp.R;
import com.example.fitnessapp.RecyclerView.RecyclerViewMainActivity;
import com.example.fitnessapp.Storage.StorageMainActivity;

public class MenuMainActivity extends AppCompatActivity {


    Button btnExercises, btnSetting, btnCalendar;
    TextView nameTextBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        btnExercises = (Button) findViewById(R.id.btnExercises);
        btnSetting = (Button) findViewById(R.id.btnSetting);
        btnCalendar = (Button) findViewById(R.id.btnCalendar);
        nameTextBox=(TextView) findViewById(R.id.nameUser);

        String username = getIntent().getStringExtra("name");

        nameTextBox.setText(username);

        btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MenuMainActivity.this,ListExercises.class));
            }
        });



        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MenuMainActivity.this, FragmentRecyclerMainActivity.class));
            }
        });



        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MenuMainActivity.this, StorageMainActivity.class));
            }
        });

    }
}