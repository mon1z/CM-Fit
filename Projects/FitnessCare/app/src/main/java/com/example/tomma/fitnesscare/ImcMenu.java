package com.example.tomma.fitnesscare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class ImcMenu extends AppCompatActivity {

    private Button calculateButton;
    private EditText pes;
    private EditText alt;
    private double indiceMassa;
    private TextView imc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc_menu);

        calculateButton = findViewById(R.id.calculate_Button);

        pes = findViewById(R.id.peso_inserir);
        alt = findViewById(R.id.altura_inserir);





        calculateButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                imc = findViewById(R.id.imc_result_id);
                String peso =  pes.getText().toString();
                String altura = alt.getText().toString();
                indiceMassa =  calcularImc(ParseDouble(peso), ParseDouble(altura));
                imc.setText("IMC: " + indiceMassa);
            }
        });
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

    private double calcularImc(double p, double a){//NAO FUNCIONA CORRETAMENTE ALTERAR A FORMULA DO IMC
        double imc = p/(a*a);
        return imc;
    }
}
