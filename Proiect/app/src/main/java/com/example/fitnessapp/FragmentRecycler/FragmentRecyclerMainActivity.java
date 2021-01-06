package com.example.fitnessapp.FragmentRecycler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.fitnessapp.Fragment.ExercisesFragment;
import com.example.fitnessapp.Fragment.HomeFragment;
import com.example.fitnessapp.Fragment.NutritionFragment;
import com.example.fitnessapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FragmentRecyclerMainActivity extends AppCompatActivity {

    BottomNavigationView btnavViewid;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_recycler_main);

        btnavViewid = findViewById(R.id.bottom_navigation2);
        frameLayout = findViewById(R.id.frameLayoutId);

        setFragment(new HomeFragment());


        btnavViewid.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {



            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        setFragment(new HomeFragment());
                        return true;

                    case R.id.nav_favorites:
                        setFragment(new ExercisesFragment());
                        return true;

                    case R.id.nav_search:
                        setFragment(new NutritionFragment());
                        return true;

                    default:
                        return false;
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, fragment);
        fragmentTransaction.commit();
    }


}