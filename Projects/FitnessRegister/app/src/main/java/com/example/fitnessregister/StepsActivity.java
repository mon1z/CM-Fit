package com.example.fitnessregister;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class StepsActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sensorManager;
    TextView tv_steps, tv_km;
    boolean running = false;
    BottomNavigationView navigation;
    Sensor count;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps);

        tv_steps = (TextView) findViewById(R.id.tv_steps);
        tv_km = (TextView) findViewById(R.id.tv_km);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationItemView navigationItem = findViewById(R.id.navigation_steps);
        BottomNavigationItemView navigationPerfil = findViewById(R.id.navigation_perfil);
        navigationItem.setChecked(true);
        navigationItem.setTextColor(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationItem.setIconTintList(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationPerfil.setIconTintList(ColorStateList.valueOf(Color.parseColor("#333333")));
        navigationPerfil.setChecked(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        running = true;
        count = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if(count != null){
            sensorManager.registerListener(this, count, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else{
            Toast.makeText(this, "Sensor not found!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        running = false;
        sensorManager.unregisterListener(this, count);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(running){
            tv_steps.setText(String.valueOf((int) event.values[0]));
            tv_km.setText(String.valueOf(getDistanceRun(event.values[0])));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public float getDistanceRun(float steps){
        float distance = (float)(steps*78)/(float)100000;
        return distance;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_perfil:
                    startActivity(new Intent(StepsActivity.this, EditActivity.class));
                    return true;
                case R.id.navigation_imc:
                    startActivity(new Intent(StepsActivity.this, ImcActivity.class));
                    return true;
                case R.id.navigation_gymnasiums:
                    startActivity(new Intent(StepsActivity.this, MapsActivity.class));
                    return true;
                case R.id.navigation_yoga:
                    startActivity(new Intent(StepsActivity.this, YogaActivity.class));
                    return true;
            }
            return false;
        }
    };
}
