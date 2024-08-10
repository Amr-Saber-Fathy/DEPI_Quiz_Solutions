package billing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import items.Item;

public class ShoppingCart {

	private static int maxCartID = 0;
	private List<Item> items;
	
	///////////Constructor///////////
	public ShoppingCart() 
	{
		setMaxCartID();
		items = new ArrayList<Item>(Arrays.asList());
	}

	//////////Getters and Setters//////////
	public static int getMaxCartID() {
		return maxCartID;
	}

	private static void setMaxCartID() {
		ShoppingCart.maxCartID++;
	}

	public List<Item> getItems() {
		return items;
	}

//	public void setItems(List<Item> items) {
//		this.items = items;
//	}
	
	//////////Additional Methods//////////
	public void addItem(Item item) 
	{
		if(this.items.contains(item)) {
			this.items.get(this.items.indexOf(item)).setItemQuantity(item.getItemQuantity());;
		}
		else {
			this.items.add(item);
		}
	}
	
	public void removeItem(Item item) 
	{
		if(this.items.contains(item)) {
			if(this.items.get(this.items.indexOf(item)).getItemQuantity() > 1) {
				this.items.get(this.items.indexOf(item)).removeItemQuantity(1);
			}
			else if(this.items.get(this.items.indexOf(item)).getItemQuantity() == 1) {
				this.items.remove(item);
			}
		}
	}
	
}
