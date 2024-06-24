package com.example.clicks;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.common.CommonBaseActivity;
import com.example.common.TapCounter;
import com.google.android.material.button.MaterialButton;

public class ClicksActivity extends CommonBaseActivity {

    private TapCounter tapCounter;
    private MaterialButton btnTap;
    private TextView timerTextView;
    private TextView textMiddle;
    private TextView textClicks;
    private CountDownTimer countDownTimer;
    private Handler handler = new Handler();

    private static final long GAME_DURATION = 50000; // 50 seconds
    private static final long RESTART_DELAY = 5000; // 5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicks);

        // Initialize TapCounter and UI elements
        tapCounter = new TapCounter();
        btnTap = findViewById(com.example.common.R.id.btn_tap);
        timerTextView = findViewById(R.id.timer_text);
        textMiddle = findViewById(R.id.text_middle);
        textClicks = findViewById(R.id.text_clicks);

        // Set OnClickListener for btnTap
        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });

        // Start the game
        startGame();
    }


    private void startGame() {
        // Reset click counter
        tapCounter.reset();

        // Update UI
        updateClicksUI();

        // Start the countdown timer
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(GAME_DURATION, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                timerTextView.setText("0");
                handleGameEnd();
            }
        }.start();
    }

    private void handleGameEnd() {
        // Delay restart for 5 seconds
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                restartGame();
            }
        }, RESTART_DELAY);
    }

    private void restartGame() {
        // Restart timer and click counter
        startGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        handler.removeCallbacksAndMessages(null);
    }

    // Method to handle button click (for demonstration purposes)
    public void onButtonClick() {
        tapCounter.increment();
        updateClicksUI();
    }

    private void updateClicksUI() {
        textClicks.setText("Clicks: " + tapCounter.getCount());
    }
}
