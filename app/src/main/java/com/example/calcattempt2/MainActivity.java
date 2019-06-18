package com.example.calcattempt2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rG;
    private RadioButton rB;
    private EditText edFeet, edInch;
    private Button calc;
    String gender = null;
    double bw;
    int height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rG = findViewById(R.id.radioGroup);
        edFeet = findViewById(R.id.inputFeet);
        edInch = findViewById(R.id.inputInch);
        calc = findViewById(R.id.btn);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inch = edInch.getText().toString();
                String feet = edFeet.getText().toString();
                height = Integer.parseInt(feet) * 12;
                int selectedId = rG.getCheckedRadioButtonId();
                rB = findViewById(selectedId);

                if (rB.getText().toString().equalsIgnoreCase("male")) {
                    bw = 50 + 2.3 * ((height)+Integer.parseInt(inch) - 60);
                    gender = "male";
                } else {
                    bw = 45.5 + 2.3 * ((height)+Integer.parseInt(inch) - 60);
                    gender = "female";
                }


                Intent intent = new Intent(MainActivity.this, ResultActivity.class);


                intent.putExtra("height", edFeet.getText().toString() + " " + edInch.getText().toString());
                intent.putExtra("weight", bw);
                intent.putExtra("gender", gender);
                startActivity(intent);
            }
        });
    }


}



