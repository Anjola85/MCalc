package com.example.mcalc;

public class MortgageModel {
    private int principle;
    private int amortization;
    private double interest;

    public MortgageModel (String p, String a, String i){
        this.principle = Integer.parseInt(p);
        this.amortization = Integer.parseInt(a);
        this.interest = Double.parseDouble(i);

    }

    public String computePayment() {
        double r = this.interest/1200;
        int n = this.amortization * 12;
        int P = this.principle;
        double divisor = 1 - Math.pow((1+r), -n);
        double index = (r*P)/divisor;
        String result = String.format("%.0f", index);
        return result;
    }

    public String  outstandingAfter(int x) {
        int months = x;
        double r = this.interest/1200;
        int P = this.principle;
        int monthlyPayment = Integer.parseInt(computePayment());
        double index = (monthlyPayment/r) - P;
        double index1 = Math.pow((1+r), months) - 1;
        double balance = P - (index)*(index1);
        String result = String.format("$%,.0f",balance);
        return result;
    }

    public static void main (String[] args) {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");

//        converting the monthly payment back to integer and the formatting it as a proper string
        double result =  Integer.parseInt(myModel.computePayment());
        String result1 = String.format("$%,.0f", result);


//        Printing the formatted monthly payment and balance
        System.out.println("Monthly Payment: " + result1);

//        Printing result after mortgage is terminated after five years.
        System.out.println("Result: " + myModel.outstandingAfter(60));


//        myModel = new MortgageModel("300000", "20", "4.5");
//        System.out.println(myModel.computePayment());


    }
}
