package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitnessapp.Fragment.FragmentMainActivity;
import com.example.fitnessapp.FragmentRecycler.FragmentRecyclerMainActivity;
import com.example.fitnessapp.MainMenu.MenuMainActivity;
import com.example.fitnessapp.Storage.StorageMainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    private EditText editTextEmail, editTextPassword;
    private Button signIn;

    private String name;

    private FirebaseAuth mAuth;

    private FirebaseUser user;
    private DatabaseReference reff;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing the id of UI elements
        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);


        signIn = (Button) findViewById(R.id.signIn);
        signIn.setOnClickListener(this);

        editTextEmail = (EditText) findViewById(R.id.email);
        editTextPassword = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        //
        user=FirebaseAuth.getInstance().getCurrentUser();
        reff=FirebaseDatabase.getInstance().getReference("Users");
        userId=user.getUid();

        reff.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if(userProfile!=null)
                {
                    name=userProfile.fullName;
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_LONG).show();
            }
        });

    }




    //clicking on buttons of the login screen
    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.register:
                startActivity(new Intent(this,RegisterUser.class));
                break;

            case R.id.signIn:
                userLogin();
                break;
        }
    }


    //method that takes care of the login
    private void userLogin()
    {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if(email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            editTextEmail.setError("Enter a valid email");
            editTextEmail.requestFocus();
            return;
        }
        if(password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if(password.length()<6) {
            editTextPassword.setError("Min password length is 6 chars");
            editTextPassword.requestFocus();
            return;
        }



        //To handle success and failure in the same listener, attach an OnCompleteListener:
        //callback method
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful())
                {
                    //redirect to user profile
                  //  startActivity(new Intent(MainActivity.this, MenuMainActivity.class));
                    Intent intentt = new Intent(new Intent(MainActivity.this, MenuMainActivity.class));
                    intentt.putExtra("name",name);
                    startActivity(intentt);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Failed to login, check credentials",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
