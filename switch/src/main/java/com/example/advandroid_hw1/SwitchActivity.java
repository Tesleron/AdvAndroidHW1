package com.example.advandroid_hw1; // Assuming package name based on your previous context

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.common.CommonBaseActivity;
import com.google.android.material.button.MaterialButton;

public class SwitchActivity extends CommonBaseActivity {

    private ImageView imageView;
    private MaterialButton btnToggleImage;

    private boolean isFirstImage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch); // Assuming you renamed activity_punch.xml to activity_switch.xml

        // Initialize UI elements
        imageView = findViewById(R.id.image_view);
        btnToggleImage = findViewById(com.example.common.R.id.btn_tap);

        // Set initial image
        setImage(isFirstImage);

        // Set OnClickListener for btnToggleImage
        btnToggleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleImage();
            }
        });
    }

    private void toggleImage() {
        isFirstImage = !isFirstImage;
        setImage(isFirstImage);
    }

    private void setImage(boolean isFirstImage) {
        if (isFirstImage) {
            imageView.setImageResource(R.drawable.on);
        } else {
            imageView.setImageResource(R.drawable.off);
        }
    }
}
