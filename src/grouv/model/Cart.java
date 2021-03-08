package grouv.model;

import grouv.strategy.BankTransferPayment;
import grouv.strategy.CashPayment;
import grouv.strategy.CreditCardPayment;
import grouv.strategy.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Geo
 */
public class Cart {
    
    private static int numberOfCarts;
    private static Cart cart;
    private List<TShirt> tshirts;
    private PaymentStrategy paymentStrategy;
    
    private Cart() {
        System.out.println(">>Creating cart!!");
        tshirts = new ArrayList();
        numberOfCarts++;
    }
    
    public static Cart getSingleCart() { //Lazy initialization
        if (cart == null) {
            
            cart = new Cart();
            
        }
        return cart;
    }
    
    public static void printNumberOfCarts() {
        System.out.println("Number of carts: "+numberOfCarts);
    }
    
    public void addTShirt(TShirt tShirt) {
        tshirts.add(tShirt);
    }
    
    public void removeTShirt(TShirt tShirt) {
        tshirts.remove(tShirt);
    }

    private List<TShirt> getTshirts() {
        return tshirts;
    }
    
    public double computeTotalPrice() {
        double sum = 0;
        for(TShirt t: tshirts) {
            sum += t.getPrice();
        }
        return sum;
    }

    public void payTotal() {
       double total = computeTotalPrice();
       if(total < 50) {
           paymentStrategy = new CashPayment();
       } else if (total < 100){
           paymentStrategy = new CreditCardPayment("Visa", "1234", "321", 2022);
       } else {
            paymentStrategy = new BankTransferPayment("Peiraios", "1234");
       }
       paymentStrategy.pay(total);
    }
    
    public void fillCart(int numberOfTshirts) {
        for (int i= 0; i < numberOfTshirts; i++ ) {
            TShirt t = new TShirt();
            addTShirt(t);
        }
    }
   
    public void printCartItems() {
        System.out.println(">>>Your cart contains the following TShirts!");
        for(TShirt t : tshirts) {
            System.out.println(t);
        }
    }
    
    
}
