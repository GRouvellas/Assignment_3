package grouv;

import grouv.model.Cart;

public class MainClass {

    public static void main(String[] args) {

        
        Cart cart = Cart.getSingleCart();
        Cart.printNumberOfCarts();        
        
        cart.fillCart(4);
        cart.printCartItems();
        System.out.println("Total price of cart: "+cart.computeTotalPrice());
        
        cart.payTotal();
        
    }
    
}
