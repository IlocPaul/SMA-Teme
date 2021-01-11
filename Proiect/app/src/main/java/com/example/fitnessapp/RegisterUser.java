package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterUser extends AppCompatActivity implements View.OnClickListener{

    private TextView registerUser;
    private ImageView banner;
    private EditText editTextFullName,editTextEmail,editTextPassword,editGender,editHeight,editWeight;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        //initializing authentication to firebase
        mAuth = FirebaseAuth.getInstance();


        //initializing the id of UI elements
        banner=(ImageView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        registerUser=(Button)findViewById(R.id.registerUser);
        registerUser.setOnClickListener(this);

        editTextFullName=(EditText)findViewById(R.id.fullName);
        editTextEmail=(EditText)findViewById(R.id.email);
        editTextPassword=(EditText)findViewById(R.id.password);
        editGender=(EditText)findViewById(R.id.gender);
        editHeight=(EditText)findViewById(R.id.height);
        editWeight=(EditText)findViewById(R.id.weight);
    }



    //clicking on buttons of the register screen
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.banner:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.registerUser:
                registerUser();
                break;
        }
    }

    private void registerUser() {

        //we take the string from the text, convert it to string and remove whitespaces and store it to new variables
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String name = editTextFullName.getText().toString().trim();
        String gender = editGender.getText().toString().trim();
        String height = editHeight.getText().toString().trim();
        String weight = editWeight.getText().toString().trim();

        //making sure no field is left empty / validation
        if(name.isEmpty())
        {
            editTextFullName.setError("Name is required");
            editTextFullName.requestFocus();
            return;
        }

        if(email.isEmpty())
        {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        //used for making sure that the email is valid:  @ etc
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Provide a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty())
        {
            editTextPassword.setError("Email is required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6)
        {
            editTextPassword.setError("Min password length should be 6 chars");
            editTextPassword.requestFocus();
            return;
        }

        if(gender.isEmpty())
        {
            editTextFullName.setError("Gender is required");
            editTextFullName.requestFocus();
            return;
        }

        if(height.isEmpty())
        {
            editTextFullName.setError("Height is required");
            editTextFullName.requestFocus();
            return;
        }


        if(weight.isEmpty())
        {
            editTextFullName.setError("Weight is required");
            editTextFullName.requestFocus();
            return;
        }

        //
        //
        //
    //To handle success and failure in the same listener, attach an OnCompleteListener:
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //if user doesnt exist we create a new user
                        if(task.isSuccessful())
                        {
                            User user = new User(name,email,gender,height,weight);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    //returns the id for the user that we registered
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    ///then we set it to the database
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful())
                                {
                                    Toast.makeText(RegisterUser.this,"User has been registered successfully",Toast.LENGTH_LONG).show();

                                    //redirect login layout
                                }
                                else
                                {
                                    Toast.makeText(RegisterUser.this,"Failed to register!",Toast.LENGTH_LONG).show();

                                }
                            }
                        });
                    }
                    else
                    {
                        Toast.makeText(RegisterUser.this,"User already exists, provide a new one!",Toast.LENGTH_LONG).show();
                    }
                }
    });


    }
}