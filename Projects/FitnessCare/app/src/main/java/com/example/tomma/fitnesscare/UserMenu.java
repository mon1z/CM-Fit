package com.example.tomma.fitnesscare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserMenu extends AppCompatActivity {

    private Button imcButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);

        imcButton = findViewById(R.id.imcButton);

       setButtonsBehavior();
    }

    public void setButtonsBehavior() {
        imcButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openImcMenu();
            }
        });
    }

    public void openImcMenu() {
        Intent intent = new Intent(this, ImcMenu.class);
        startActivity(intent);
    }
}
