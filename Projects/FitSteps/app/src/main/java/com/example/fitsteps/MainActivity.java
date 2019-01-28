package com.example.fitsteps;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private TextView textView;
    private StepDetector stepDetector;
    private StepService stepService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView =  findViewById(R.id.totalPassos);
        stepDetector
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionItemsSeleted(MenuItem item) {
        int id = item.getGroupId();
        if (id == R.id.action_setings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    /**
     * registerListener: recuperar os passos quando o utiliza faz mudanças ou alteração na aplicação.
     * sensorManager.SENSOR_DELAY_NORMAL: detectar os passos de forma normal ou seja quando não é continua para economizar a carga
     * se for zero (0) : o sensor deteta de forma continua
     */
    @Override
    protected void onResume() {
        super.onResume();

        sensorManager.registerListener(this, sensorDetector, 0);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // serve para deligar o sensor quando o utilizador sair da aplicação
        sensorManager.unregisterListener(this, sensorDetector);
    }

}
