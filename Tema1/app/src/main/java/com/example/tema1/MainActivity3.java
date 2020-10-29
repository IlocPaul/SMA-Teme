package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    private Button buttonTema2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportActionBar().setTitle("Activity 3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonTema2 = (Button) findViewById(R.id.button2);

        buttonTema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTema2();
            }
        });
    }

    public void openTema2() {
        Intent intent = new Intent(this, Tema2.class);
        startActivity(intent);
    }
}