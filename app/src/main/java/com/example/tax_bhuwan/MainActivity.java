package com.example.tax_bhuwan;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText etIncome, etTax;
    Button btnCalcualte;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIncome= findViewById(R.id.etIncome);
        etTax= findViewById(R.id.etTax);

        btnCalcualte= findViewById(R.id.btnCalculate);

        btnCalcualte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double income, tax;

                income = Integer.parseInt(etIncome.getText().toString()) ;
                tax = 0;

                IncomeCalculator incomeCalculator = new IncomeCalculator(income,tax);
                etTax.setText(Double.toString(incomeCalculator.TaxGenerate()));




                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(btnCalcualte.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
            }
        });
    }
}