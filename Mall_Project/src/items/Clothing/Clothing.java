package items.Clothing;

import items.Item;

public class Clothing extends Item{
	
	private String color = "";
	
	public Clothing(String itemName, double itemPrice, double itemDiscount, String color) {
		super(itemName, itemPrice, itemDiscount);
		setColor(color);
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		if(color == null || color == "") {
			System.out.println("Invalid Color");
		}
		else {
			this.color = color;
		}
	}

	@Override
	public String toString() 
	{
		return "Item : " + getMaxID() + " ==> " + getItemName() 
		+ " : " + getItemPrice() + "has a discount of : " 
		+ getItemDiscount();
	}
	
}
