package com.example.tomma.fitnesscare;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class StepDetector implements SensorEventListener {

    private int mProxPassos;
    private int numPassos;
    private int contadorPassos;
    private TextView textView;

    public StepDetector() {
        numPassos = 0;
        mProxPassos = 0;
        contadorPassos = 0;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR){
            numPassos++;
            textView.setText("" + numPassos);
        }
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (contadorPassos < 1) {
                contadorPassos = (int) event.values[0];
            }
            numPassos = (int) event.values[0] - contadorPassos;
            numPassos = numPassos + mProxPassos;
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
