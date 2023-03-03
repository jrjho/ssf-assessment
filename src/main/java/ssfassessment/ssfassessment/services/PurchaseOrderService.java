package ssfassessment.ssfassessment.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssfassessment.ssfassessment.models.PurchaseOrder;
import ssfassessment.ssfassessment.repositories.PurchaseOrderRepo;

@Service
public class PurchaseOrderService {
    
    @Autowired
    private PurchaseOrderRepo pOrderRepo;




	// public HashMap<String, Integer> getFromCart (String item, Integer quantity){
	// 	Optional<String, Integer> opt = pOrderRepo.getFromCart(item, quantity);

	// 	return null;
	// }
	public void updateCart(String item, String quantity, PurchaseOrder purchaseOrder){

		int qty = Integer.parseInt(quantity);
		int newQty = purchaseOrder.getQuantity(item) + qty;
		purchaseOrder.setCart(item, newQty);
		// PurchaseOrder po = new PurchaseOrder(item,quantity);
		// String num = PurchaseOrder.itemQty(item,quantity);
		// PurchaseOrder purchaseOrder = checkCart(item, quantity);
		// return null;
	}

	// public PurchaseOrder checkCart(String item, String quantity){
	// 	if(PurchaseOrder.g)
	// 	return null;
	// }


	// public void addItem(String itemName, int quantity) {
    //     if (.containsKey(itemName)) {
    //         int currentQuantity = items.get(itemName);
    //         items.put(itemName, currentQuantity + quantity);
    //     } else {
    //         items.put(itemName, quantity);
    //     }
    // }

    // public void addToPO(String quantity, List<String> item) {

	// 	// convert the list to a CSV
	// 	String items = item.stream()
	// 		.collect(Collectors.joining(","));

	// 	System.out.printf(">>> service %s, %s\n", quantity, items);
	// 	pOrderRepo.addToCart(quantity, items);
	// }

	// public List<String> getFromPO(String name) {
	// 	Optional<String> opt = pOrderRepo.getFromCart(name);

	// 	List<String> cart = new LinkedList<>();

	// 	// If the box is empty, return an empty list
	// 	if (opt.isEmpty())
	// 		return cart;

	// 	// Get the value from the box
	// 	String value = opt.get();
	// 	String[] items = value.split(",");
	// 	for (int i = 0; i < items.length; i++)
	// 		cart.add(items[i]);
	// 	return cart;
	// }

    // public HashMap<String,String> getPO(String item, String quantity){


    //     return null;
    // }
}
