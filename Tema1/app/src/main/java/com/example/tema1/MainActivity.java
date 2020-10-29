package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private Button buttonTema2;
    private Button buttonTema3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview1);
        button = (Button) findViewById(R.id.button1);

        buttonTema2 = (Button) findViewById(R.id.button2);

        buttonTema3 = (Button) findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        //Tema 2
        buttonTema2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTema2();
            }
        });

        buttonTema3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTema3();
            }
        });
    }

    public void openDialog() {
        DialogBox exampleDialog = new DialogBox();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }


    public void openTema2() {
        Intent intent = new Intent(this, Tema2.class);
        startActivity(intent);
    }

    public void openTema3() {
        Intent intent = new Intent(this, Tema3.class);
        startActivity(intent);
    }


}