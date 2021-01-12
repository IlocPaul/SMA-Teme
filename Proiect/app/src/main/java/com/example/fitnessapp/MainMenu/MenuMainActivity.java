package com.example.fitnessapp.MainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fitnessapp.FragmentRecycler.FragmentRecyclerMainActivity;
import com.example.fitnessapp.R;
import com.example.fitnessapp.Storage.StorageMainActivity;

public class MenuMainActivity extends AppCompatActivity {


    Button btnExercises, btnSetting, btnCalendar;
    TextView nameTextBox,genderTextBox, heightTextBox,weightTextBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        btnExercises = (Button) findViewById(R.id.btnExercises);
        btnSetting = (Button) findViewById(R.id.btnFragment);
        btnCalendar = (Button) findViewById(R.id.btnFood);
        nameTextBox=(TextView) findViewById(R.id.nameUser);
        genderTextBox=(TextView) findViewById(R.id.gender);
        heightTextBox=(TextView) findViewById(R.id.height);
        weightTextBox=(TextView) findViewById(R.id.weight);


        String username = getIntent().getStringExtra("name");
        String gender= getIntent().getStringExtra("gender");
        String height= getIntent().getStringExtra("height");
        String weight= getIntent().getStringExtra("weight");

        nameTextBox.setText(username);
        genderTextBox.setText(gender);
        heightTextBox.setText(height);
        weightTextBox.setText(weight);

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