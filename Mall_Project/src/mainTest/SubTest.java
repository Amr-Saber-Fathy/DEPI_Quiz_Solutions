package mainTest;

import java.time.LocalDate;

import billing.Bill;
import billing.ShoppingCart;
import items.Item;
import items.Clothing.Shirt;
import items.Clothing.Socks;
import items.Clothing.Trousers;

public class SubTest {

	public static void main(String[] args) {

		Item[] items = {new Shirt("NewShirt101", 200, 0.25, 2, "Blue", "Large"),
						new Trousers("NewTrousers101", 250, 0.2, 3, "Red", "Large"),
						new Shirt("NewShirt102", 150, 0.0, 1, "Blue", "Large"),
						new Shirt("NewShirt105", 200, 0.25, 2, "Blue", "Large"),
						new Socks("NewSocks101", 200, 0.25, 2, "Blue")};
		
		Item repeatingItem = new Shirt("NewShirt136", 100, 0.25, 2, "Red", "Small");
		
		ShoppingCart myCart = new ShoppingCart();
		
		for(Item item : items) {
			myCart.addItem(item);
		}
		
		myCart.addItem(repeatingItem);
		myCart.addItem(repeatingItem);
		
		Bill myBill = new Bill(myCart, LocalDate.now());
		
		System.out.println(myBill);
	}

}
