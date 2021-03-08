/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grouv.strategy;


public class CreditCardPayment implements PaymentStrategy {
    
    private final String cardType;
    private final String cardNumber;
    private final String cvv;
    private final int expirationYear;

    public CreditCardPayment(String cardType, String cardNumber, String cvv, int expirationYear) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationYear = expirationYear;
    }
    
    @Override
    public void pay(double price) {
        System.out.println("Paid $" + price + " with Credit Card:" + this);
    }

    @Override
    public String toString() {
        return "CreditCardPayment{" + "cardType=" + cardType + ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", expirationYear=" + expirationYear + '}';
    }
    
    
    
}
