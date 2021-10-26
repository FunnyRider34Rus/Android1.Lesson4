package com.example.lesson4.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import com.example.lesson4.presenter.Presenter;
import com.example.lesson4.R;
import com.example.lesson4.logic.CalcImp;
import com.example.lesson4.logic.Operation;


import java.util.HashMap;
import java.util.Map;

public class CalcActivity extends AppCompatActivity implements CalcView {

    private TextView txtResult;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this, new CalcImp());

        txtResult = findViewById(R.id.txt_result);

        Map<Integer, Integer> digits = new HashMap<>();
        digits.put(R.id.button_0, 0);
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);

        View.OnClickListener digitsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDigitPressed(digits.get(view.getId()));
            }
        };

        findViewById(R.id.button_0).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_1).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_2).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_3).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_4).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_5).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_6).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_7).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_8).setOnClickListener(digitsClickListener);
        findViewById(R.id.button_9).setOnClickListener(digitsClickListener);

        Map<Integer, Operation> operation = new HashMap<>();
        operation.put(R.id.button_plus, Operation.ADD);
        operation.put(R.id.button_minus, Operation.SUB);
        operation.put(R.id.button_divide, Operation.DIV);
        operation.put(R.id.button_multiply, Operation.MULT);

        View.OnClickListener operationsClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onOperationPressed(operation.get(view.getId()));
            }
        };

        findViewById(R.id.button_plus).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_minus).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_divide).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_multiply).setOnClickListener(operationsClickListener);
        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onSummKeyPressed();
            }
        });
        findViewById(R.id.button_point).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onDotPressed();
            }
        });
    }

    @Override
    public void showResult(String result) {
        txtResult.setText(result);
    }
}