package com.example.materialyoucalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView inputText, resultTextView;
    private String expression = "";
    private Button ac, backspace, add,minus,multiply,divide,modulas, calculate_exp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputText = findViewById(R.id.Entry);
        resultTextView = findViewById(R.id.Result);
        ac= findViewById(R.id.buttonAC);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        // Operator Buttons
        add = findViewById(R.id.buttonAdd);
        minus = findViewById(R.id.buttonSubtract);
        multiply = findViewById(R.id.buttonMult);
        divide = findViewById(R.id.buttonDevide);
        modulas = findViewById(R.id.buttonModulas);
        calculate_exp = findViewById(R.id.buttonResult);

        inputText.setText(expression);
        resultTextView.setText(expression);

        // All clear
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = "";
                inputText.setText(expression);
            }
        });

        // remove the last letter from the string
        backspace = findViewById(R.id.buttonBackspace);
        String entry_string = inputText.getText().toString();
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (expression.length() > 0){
                    expression = expression.substring(0, expression.length() - 1);
                    inputText.setText(expression);
                }
            }
        });

        // Operator Buttons
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "+";
                inputText.setText(expression);
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "-";
                inputText.setText(expression);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "*";
                inputText.setText(expression);
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "/";
                inputText.setText(expression);
            }
        });
        modulas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += "%";
                inputText.setText(expression);
            }
        });

        // Calculate Button
        calculate_exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double result = eval(expression);

                    // Display the result in the inputEditText
                    resultTextView.setText(String.valueOf(result));
                }
                catch (Exception e) {
                    // Handle errors, e.g., invalid expressions
                    inputText.setText(R.string.calculation_error);
                }
            }
        });

        // 0-9 Buttons including"."
        findViewById(R.id.numbutton0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 0;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 1;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 2;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 3;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 4;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 5;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 6;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 7;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 8;
                inputText.setText(expression);
            }
        });findViewById(R.id.numbutton9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression = expression + 9;
                inputText.setText(expression);
            }
        });
        findViewById(R.id.buttonDecimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression += ".";
                inputText.setText(expression);
            }
        });
    }

    // Eval Function
    private double eval(String expression) {
        // Remove spaces from the expression for better eval() compatibility
        String cleanExpression = expression.replace(" ", "");
        return new ExpressionBuilder(cleanExpression).build().evaluate();
    }
}