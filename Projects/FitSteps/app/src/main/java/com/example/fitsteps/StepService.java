package com.example.fitsteps;

import android.app.Service;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class StepService  extends Service {

    private SensorManager sensorManager;
    private Sensor sensorDetector;
    private Sensor sensorContador;

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorDetector = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorContador = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }
}
