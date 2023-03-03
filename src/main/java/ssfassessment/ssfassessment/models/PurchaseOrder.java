package ssfassessment.ssfassessment.models;

import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.Min;

public class PurchaseOrder {

    private String item;

    @Min(value = 1 ,message = "Order size must be at least 1!")    
    private int quantity;
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private Map<String, Integer> cart;

    public Map<String, Integer> getCart() {
        return cart;
    }

    public String itemQty(String name, Integer quantity){
        String num = cart.get(name).toString();
        System.out.printf("num is: %s\n", num);

        return num;
    }
    public void setCart(String name, Integer quantity) {
        cart.put(name,quantity);
    }

   

    public PurchaseOrder() {
        // this.cart = cart;
        cart = new HashMap<>();
        cart.put("apple", 0);
        cart.put("orange", 0);
        cart.put("bread", 0);
        cart.put("cheese", 0);
        cart.put("chicken", 0);
        cart.put("mineral_water", 0);
        cart.put("instant_noodles", 0);
    }


    public PurchaseOrder(String item, Integer quantity) {
        cart.put(item,quantity);
    }

    @Override
    public String toString() {
        return "PurchaseOrder [cart=" + cart + "]";
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQuantity(String item) {
        return this.cart.get(item);
    }

    public void setQuantity(String item, Integer quantity) {
        this.cart.put(item,quantity);
    }


    
    // public PurchaseOrder() {
    //    item = new HashMap<>();
    // }

    // public Map<String, Integer> getItem() {
    //     return item;
    // }

    // public void setItem(Map<String, Integer> item) {
    //     this.item = item;
    // }





    




    
    // @NotNull(message = "Must select item!")
    // private String item;
    // @Min(value = 1 ,message = "Quantity must be at least 1!")
    // private String quantity;


    
    // public String getItem() {
    //     return item;
    // }
    // public void setItem(String item) {
    //     this.item = item;
    // }
    // public String getQuantity() {
    //     return quantity;
    // }
    // public void setQuantity(String quantity) {
    //     this.quantity = quantity;
    // }
    // @Override
    // public String toString() {
    //     return "PurchaseOrder [item=" + item + ", quantity=" + quantity + "]";
    // }

    
}
