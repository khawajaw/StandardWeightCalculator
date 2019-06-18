package com.example.calcattempt2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;


public class ResultActivity extends AppCompatActivity {
    private TextView gen, h, sw;
    double weight;

    String height, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        gen = findViewById(R.id.genText);

        sw = findViewById(R.id.swText);

        h = findViewById(R.id.heightText);
        weight = Objects.requireNonNull(getIntent().getExtras()).getDouble("weight");
        height = Objects.requireNonNull(getIntent().getExtras().getString("height"));
        gender = Objects.requireNonNull(getIntent().getExtras().getString("gender"));

        height = height.replaceAll(" ", "'");

        sw.setText("The standard weight is " + weight + "kg");
        h.setText("Your height is " + height + "\"");
        gen.setText("You are " + gender);

    }
}