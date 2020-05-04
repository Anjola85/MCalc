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
        String result = String.format("$%,.2f", index);
        return result;
    }

    public static void main (String[] args) {
        MortgageModel myModel = new MortgageModel("700000", "25", "2.75");
        System.out.println(myModel.computePayment());

        myModel = new MortgageModel("300000", "20", "4.5");
        System.out.println(myModel.computePayment());
    }
}
