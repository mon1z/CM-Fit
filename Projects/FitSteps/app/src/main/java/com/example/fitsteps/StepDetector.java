package com.example.fitsteps;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class StepDetector implements SensorEventListener {

    private int mProximoPassos;
    private int numPassos;
    private int contadorPassos;
    private TextView textView;

    public void setNumPassos(int numPassos) {
        this.numPassos = numPassos;
    }

    public int getNumPassos() {
        return numPassos;
    }


    public void setContadorPassos(int contadorPassos) {
        this.contadorPassos = contadorPassos;
    }

    public int getContadorPassos() {
        return contadorPassos;
    }

    /**
     * metodo com evento para detetar os passos que houver a alteração
     *
     * @param event
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor sensor = event.sensor;
        if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
            numPassos++;
            textView.setText("" + numPassos);
        }
        if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
            if (contadorPassos < 1) {
                contadorPassos = (int) event.values[0];
            }
            numPassos = (int) event.values[0] - contadorPassos;
            numPassos = numPassos + mProximoPassos;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


}
