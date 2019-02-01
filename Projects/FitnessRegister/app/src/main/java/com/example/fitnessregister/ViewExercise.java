package com.example.fitnessregister;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewExercise extends AppCompatActivity {

    int image_id;
    String name;

    TextView timer, title;
    ImageView detail_image;

    Button startBtn;

    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        timer = (TextView) findViewById(R.id.timer);
        title = (TextView) findViewById(R.id.title);
        detail_image = (ImageView) findViewById(R.id.detail_image);
        startBtn = (Button) findViewById(R.id.startBtn);


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isRunning)
                {
                    startBtn.setText("ACABOU");
                    new CountDownTimer(20000, 1000) {

                        @Override
                        public void onTick(long millisUntilFinished) {
                            timer.setText("" + millisUntilFinished / 1000);
                        }

                        @Override
                        public void onFinish() {
                            Toast.makeText(ViewExercise.this, "Terminou!!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }.start();
                }else
                {
                    Toast.makeText(ViewExercise.this, "Terminou!!", Toast.LENGTH_SHORT).show();
                    finish();
                }

                isRunning = !isRunning;
            }
        });


        timer.setText("");

        if(getIntent() != null){
            image_id = getIntent().getIntExtra("image_id", -1);
            name = getIntent().getStringExtra("name");

            detail_image.setImageResource(image_id);
            title.setText(name);

        }

    }
}
