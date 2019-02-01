package com.example.fitnessregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class YogaActivity extends AppCompatActivity {

    Button btnExercises, btnSettings;
    BottomNavigationView navigation;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationItemView navigationItem = findViewById(R.id.navigation_yoga);
        BottomNavigationItemView navigationPerfil = findViewById(R.id.navigation_perfil);
        navigationItem.setChecked(true);
        navigationItem.setTextColor(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationItem.setIconTintList(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationPerfil.setIconTintList(ColorStateList.valueOf(Color.parseColor("#333333")));
        navigationPerfil.setChecked(false);

        btnExercises = (Button) findViewById(R.id.exerciseBtn);
        btnExercises.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YogaActivity.this, ListExercises.class);
                startActivity(intent);
            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_perfil:
                    startActivity(new Intent(YogaActivity.this, EditActivity.class));
                    return true;
                case R.id.navigation_imc:
                    startActivity(new Intent(YogaActivity.this, ImcActivity.class));
                    return true;
                case R.id.navigation_gymnasiums:
                    startActivity(new Intent(YogaActivity.this, MapsActivity.class));
                    return true;
                case R.id.navigation_steps:
                    startActivity(new Intent(YogaActivity.this, StepsActivity.class));
                    return true;

            }
            return false;
        }
    };
}
