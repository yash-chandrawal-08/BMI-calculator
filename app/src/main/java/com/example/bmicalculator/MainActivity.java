package com.example.bmicalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtweight,edtHightFt,edtHightIn;
    Button btnCalc;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtweight = findViewById(R.id.edtweight);
        edtHightFt = findViewById(R.id.edtHightFt);
        edtHightIn = findViewById(R.id.edtHightIn);

        btnCalc = findViewById(R.id.btnCalc);

        txtResult = findViewById(R.id.txtResult);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt =  Integer.parseInt(edtweight.getText().toString());
                int ft =  Integer.parseInt(edtHightFt.getText().toString());
                int in =  Integer.parseInt(edtHightIn.getText().toString());

                int totalIn = ft*12 + in;

                double totalCm = totalIn * 2.53;

                double totalM = totalCm/100;

                double BMI = wt/(totalM*totalM);

                if(BMI>25){
                    txtResult.setText("you're overweight");
                    txtResult.setTextColor(Color.RED);
                } else if (BMI<18) {
                    txtResult.setText("you're underweight");
                    txtResult.setTextColor(Color.RED);
                }else {
                    txtResult.setText("you're healthy");
                    txtResult.setTextColor(Color.GREEN);
                }
            }
        });

    }
}