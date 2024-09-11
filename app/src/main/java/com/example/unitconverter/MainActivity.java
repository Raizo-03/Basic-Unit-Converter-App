package com.example.unitconverter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText input;
    TextView output;
    int i;
    String inputText;
    Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.text_input);
        output = findViewById(R.id.text_result);

        //grams to kilograms
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
        @Override
         public void onClick(View v) {
            inputText = input.getText().toString();
            if(!inputText.isEmpty()){
                try{
                    i = Integer.parseInt(inputText);
                    int result = gramsToKilograms(i);
                    output.setText(String.format("%d kg", result));

                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                }

            }else{
                Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
            }

               }
         });

     //decimal to binary
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText = input.getText().toString();
                if(!inputText.isEmpty()){
                    try{
                        i = Integer.parseInt(inputText);
                        String result = decimalToBinary(i);
                        output.setText(result);
                    }catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }

            }
        });



        //meters to kilometers
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText = input.getText().toString();
                i = Integer.parseInt(inputText);
                if(!inputText.isEmpty()){
                    try{
                        i = Integer.parseInt(inputText);
                        double result = metersToKilometers(i);
                        output.setText(String.format("%.2f km", result));
                    }catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }

            }
        });


        //celsius to kelvin
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText = input.getText().toString();
                if(!inputText.isEmpty()){
                    try{
                        i = Integer.parseInt(inputText);
                        double result = celsiusToKelvin(i);
                        output.setText(String.format("%.2f K", result));

                    }catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid input", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static int gramsToKilograms(int grams){
        return grams / 1000;
    }

    public static String decimalToBinary(int decimal){
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            int remainder = decimal % 2;
            binary.append(remainder);
            decimal = decimal / 2;
        }

        return binary.reverse().toString();
    }

    public static double metersToKilometers(int meters){
        return meters / 1000.0;
    }

    public static double celsiusToKelvin(double celsius){
        return celsius / 273.15;
    }

}