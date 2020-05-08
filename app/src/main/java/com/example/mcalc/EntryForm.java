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
        double value =  Integer.parseInt(myModel.computePayment());
        String result = String.format("$%,.0f", value);
        String myMortgage = result;



        ((TextView) findViewById(R.id.answer)).setText(myMortgage);
    }

    //        Adding new widget to enable the user determine how much would still be owing to the bank if the mortgage were terminated after five years.
    public void balanceCalc(View v) {
        EditText PrincipleView = findViewById(R.id.principle);
        String principle = PrincipleView.getText().toString();

        EditText amortizationView =  findViewById(R.id.amortization);
        String amortization = amortizationView.getText().toString();

        EditText InterestView =  findViewById(R.id.interest);
        String interest = InterestView.getText().toString();

        MortgageModel myModel = new MortgageModel(principle, amortization, interest);
        String balance = myModel.outstandingAfter(60);
        ((TextView) findViewById(R.id.balance)).setText(balance);
    }
}
