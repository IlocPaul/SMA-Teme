package com.example.tema1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DialogBox extends AppCompatDialogFragment  {

    private EditText editTexts;

    private String text;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_dialog_box, null);
        builder.setView(view)
                .setTitle("Dialog Box")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        showToast();
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {



                        text = editTexts.getText().toString();
                        if(text.isEmpty()) {
                            showToast2();

                        }
                      else

                        openActivity2();

                    }
                });

        editTexts = view.findViewById(R.id.editText);

        return builder.create();

    }



    public void openActivity2() {


        Intent intent = new Intent(getContext(), MainActivity2.class);
        //trimit data in activity2
        intent.putExtra("key",text);
        getContext().startActivity(intent);

    }

    public void showToast() {
        Toast.makeText(this.getActivity(), "You pressed cancel", Toast.LENGTH_SHORT).show();
    }

    public void showToast2() {
        Toast.makeText(this.getActivity(), "No Text", Toast.LENGTH_SHORT).show();
    }

}