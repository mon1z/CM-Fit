package com.example.tomma.fitnesscare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*A INFORMAÇÃO DO LOGIN /REGISTAR NAO ESTÀ A SER BEM ARMAZENADA.*/
public class MainActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "preferences";
    private static final String PREF_UNAME = "Username";
    private static final String PREF_PASSWORD = "Password";

    private final String DefaultUnameValue = "";
    private String UnameValue;

    private final String DefaultPasswordValue = "";
    private String PasswordValue;


    private Button enterButton;
    private Button registerButton;

    private EditText mail;
    private EditText pass;

    // novos atributos para contagem dos passos, serviços
    private TextView textView;
    private StepDetector stepDetector;
    private SensorManager sensorManager;
    private Sensor sensorDetector;
    private Sensor sensorCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.activity_main);

        mail = findViewById(R.id.login_mail_id);
        pass = findViewById(R.id.login_pass_id);

        enterButton = findViewById(R.id.enterButton);
        enterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openUserMenu();
            }
        });

        registerButton = findViewById(R.id.registButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openRegister();
            }
        });
        // intanciar os serviços
        stepDetector = new StepDetector();
        textView = (TextView) findViewById(R.id.totalPassos);
        sensorManager= (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorDetector= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
        sensorCounter= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
    }


    private void savePreferences() {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        // Edit and commit
        mail.getText();
        UnameValue = mail.toString();

        pass.getText();
        PasswordValue = pass.toString();
        editor.putString(PREF_UNAME, UnameValue);
        editor.putString(PREF_PASSWORD, PasswordValue);
        editor.commit();
    }

    private void loadPreferences() {

        SharedPreferences settings = getSharedPreferences(PREFS_NAME,
                Context.MODE_PRIVATE);

        // Get value
        UnameValue = settings.getString(PREF_UNAME, DefaultUnameValue);
        PasswordValue = settings.getString(PREF_PASSWORD, DefaultPasswordValue);

        mail.setText(UnameValue);

        pass.setText(PasswordValue);
    }

    @Override
    public void onPause() {
        super.onPause();
        savePreferences();

    }

    @Override
    public void onResume() {
        super.onResume();
        loadPreferences();
        //verificar as mudanças dos passos
        sensorManager.registerListener(stepDetector, sensorDetector, SensorManager.SENSOR_DELAY_NORMAL);// chamada  de sensor detector
        sensorManager.registerListener(stepDetector,sensorCounter, 0);
        //stepDetector.onSensorChanged(sensorCounter);
    }
    @Override
    public void onStop(){
        super.onStop();;
        sensorManager.unregisterListener(stepDetector, sensorDetector);
    }


    public void openUserMenu() {
        Intent intent = new Intent(this, UserMenu.class);
        startActivity(intent);
    }

    public void openRegister() {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


}
