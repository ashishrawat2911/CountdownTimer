package com.example.ashish.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.budiyev.android.circularprogressbar.CircularProgressBar;

public class MainActivity extends AppCompatActivity {
    CircularProgressBar progressBar;
    TextView textView;
    CountDownTimer countDownTimer;
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start = findViewById(R.id.start_button);
        stop = findViewById(R.id.stop_button);
        progressBar = findViewById(R.id.progress_bar);
        progressBar.setProgress(60f);
        textView = findViewById(R.id.textView);
        textView.setText("60");
        stop.setEnabled(false);
    }

    public void startTimer(View view) {

        countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressBar.setProgress((int) millisUntilFinished / 1000);
                textView.setText("" + ((millisUntilFinished / 1000) - 1));
            }

            @Override
            public void onFinish() {
                progressBar.setProgress(60f);
                start.setEnabled(true);
                stop.setEnabled(false);
            }
        }.start();
        start.setEnabled(false);
        stop.setEnabled(true);
    }

    public void stopTimer(View view) {
        countDownTimer.cancel();
        textView.setText("60");
        progressBar.setProgress(60f);
        start.setEnabled(true);
        stop.setEnabled(false);
    }
}
