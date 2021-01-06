package com.example.fitnessapp.Fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fitnessapp.R;
import com.example.fitnessapp.RecyclerView.RecyclerViewMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        //we pass the navigation bottom that we instantiated above
        //in order to handle the selection of events (fragments)
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        // keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            //open 1 default fragment when we start the app
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }

    //handling selection of events(fragments) in the bottom navigation row
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    //create the fragments
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new ExercisesFragment();
                             break;
                            /*
                            startActivity(new Intent(getApplicationContext(), RecyclerViewMainActivity.class));
                            overridePendingTransition(0,0);
                            return true;
                            */

                        case R.id.nav_search:
                            selectedFragment = new NutritionFragment();
                            break;
                    }
                    //and then we return the selected fragment
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}