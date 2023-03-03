package ssfassessment.ssfassessment.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseOrderRepo {
    

    @Autowired @Qualifier("my-redis")
    private RedisTemplate<String, String> template;
	public void addToCart(String name, String quantity) {
		System.out.printf(">>> add to cart: %s, %s\n", name, quantity);
	   template.opsForValue().set(name, quantity);
   }
	









    // public void addToCart(String item, String quantity) {
	// 	 System.out.printf(">>> add to cart: %s, %s\n", item, quantity);
    //     template.opsForValue().set(item, quantity);
    // }

	// public Optional<String> getFromCart(String name) {

	// 	String value = template.opsForValue().get(name);
	// 	 System.out.printf(">>> get from cart: %s, %s\n", name, value);
	// 	// If the value is empty, return an empty box
	// 	if (null == value)
	// 		return Optional.empty();

	// 	// Fill the box and return the box
	// 	return Optional.of(value);
	// }
}
