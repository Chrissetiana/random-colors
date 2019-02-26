package com.chrissetiana.randomcolors;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String[] colorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        if (savedInstanceState != null) {
            textView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    public void onChange(View view) {
        Random random = new Random();

        String colorName = colorArray[random.nextInt(20)];
        int colorResource = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResource);

        textView.setTextColor(colorRes);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("color", textView.getCurrentTextColor());
    }
}
