package com.example.mcalc;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class EntryForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mortgage_layout);
    }
    public void buttonClicked(View v) {
        EditText PrincipleView = findViewById(R.id.principle);
        String principle = PrincipleView.getText().toString();

        EditText amortizationView =  findViewById(R.id.amortization);
        String amortization = amortizationView.getText().toString();

        EditText InterestView =  findViewById(R.id.interest);
        String interest = InterestView.getText().toString();

        MortgageModel myModel = new MortgageModel(principle, amortization, interest);
        String myMortgage = myModel.computePayment();

        System.out.println(myModel.computePayment());

        ((TextView) findViewById(R.id.answer)).setText(myMortgage);
    }
}
