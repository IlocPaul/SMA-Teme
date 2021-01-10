package com.example.fitnessapp.MainMenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fitnessapp.MainActivity;
import com.example.fitnessapp.R;

public class MenuMainActivity extends AppCompatActivity {


    Button btnExercises, btnSetting, btnCalendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        btnExercises = (Button) findViewById(R.id.btnExercises);


        btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MenuMainActivity.this,ListExercises.class));
            }
        });



    }
}