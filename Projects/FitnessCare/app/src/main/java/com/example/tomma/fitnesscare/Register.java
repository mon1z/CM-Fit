package com.example.tomma.fitnesscare;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class Register extends AppCompatActivity {

    private Button registButton;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registButton = findViewById(R.id.registConfirm);
        //Completar serializable de hashMap para registar usuario escrever e ler o ficheiro


        registButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                openLogin();
            }
        });

        //Capturar com camera

    }


        public void openLogin(){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }



