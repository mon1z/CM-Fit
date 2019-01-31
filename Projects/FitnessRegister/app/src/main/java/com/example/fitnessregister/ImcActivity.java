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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.NumberFormat;

public class ImcActivity extends AppCompatActivity {

    private Button calculateButton;
    private EditText pes;
    private EditText alt;
    private double indiceMassa;
    private TextView imc;
    private char sexo;
    private RadioGroup rg;
    private RadioButton rb;
    BottomNavigationView navigation;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_activity);

        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationItemView navigationItem = findViewById(R.id.navigation_imc);
        BottomNavigationItemView navigationPerfil = findViewById(R.id.navigation_perfil);
        navigationItem.setChecked(true);
        navigationItem.setTextColor(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationItem.setIconTintList(ColorStateList.valueOf(Color.parseColor("#1BA1E2")));
        navigationPerfil.setIconTintList(ColorStateList.valueOf(Color.parseColor("#333333")));
        navigationPerfil.setChecked(false);

        calculateButton = findViewById(R.id.calculate_Button);
        rg = findViewById(R.id.radio_group_id);
        rb = findViewById(R.id.check_male);
        pes = findViewById(R.id.peso_inserir);
        alt = findViewById(R.id.altura_inserir);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imc = findViewById(R.id.imc_result_id);
                String peso =  pes.getText().toString();
                String altura = alt.getText().toString();
                indiceMassa =  calcularImc(ParseDouble(peso), ParseDouble(altura)* 0.01);
                imc.setText("IMC:  " + String.format("%.2f", indiceMassa) + verificarImc(indiceMassa));
            }
        });
    }

    public void rbClick(View view){
        int radioButtonid = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(radioButtonid);
    }

    double ParseDouble(String strNumber) {
        if (strNumber != null && strNumber.length() > 0) {
            try {
                return Double.parseDouble(strNumber);
            } catch(Exception e) {
                return -1;   // or some value to mark this field is wrong. or make a function validates field first ...
            }
        }
        else return 0;
    }

    private char verificarSexo(){

        if(rb.isSelected()){
            return 'M';
        }else{
            return 'F';
        }
    }

    private double calcularImc(double p, double a){
        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(4);
        format.setRoundingMode(RoundingMode.HALF_UP);

        //CARACTERES A MAIS - rESOLVER

        //return Double.valueOf(format.format(p / (a*a)));

        return p / (a*a);
    }

    private String verificarImc(double imc){
        sexo = verificarSexo();
        if(sexo == 'F') {
            if(imc <= 19.1) {
                return(" --> Abaixo do peso ideal");
            }else if(imc > 19.1 && imc <= 25.8){
                return(" --> Peso ideal");
            }else if(imc > 25.8 && imc <= 27.3 ) {
                return(" --> Ligeiramente acima do peso ideal");
            }else if(imc > 27.3 && imc <= 32.3) {
                return(" --> Acima do peso ideal");
            }else {
                return(" --> Obesidade");
            }
        }else if (sexo == 'M') {
            if (imc <= 20.7) {
                return (" --> Abaixo do peso ideal");
            } else if (imc > 20.7 && imc <= 26.4) {
                return (" --> Peso ideal");
            } else if (imc > 26.4 && imc <= 27.8){
                return (" --> Ligeiramente acima do peso ideal");
            } else if (imc > 27.8 && imc <= 31.1) {
                return (" --> Acima do peso ideal");
            } else {
                return (" --> Obesidade");
            }

        }
        return "";
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_perfil:
                    startActivity(new Intent(ImcActivity.this, EditActivity.class));
                    return true;
                case R.id.navigation_imc:
                    startActivity(new Intent(ImcActivity.this, ImcActivity.class));
                    return true;
                case R.id.navigation_gymnasiums:
                    startActivity(new Intent(ImcActivity.this, MapsActivity.class));
                    return true;
                case R.id.navigation_steps:
                    startActivity(new Intent(ImcActivity.this, StepsActivity.class));
                    return true;
            }
            return false;
        }
    };
}
