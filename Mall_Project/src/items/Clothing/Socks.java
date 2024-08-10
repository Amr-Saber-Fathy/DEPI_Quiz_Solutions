package items.Clothing;

public class Socks extends Clothing{

	public Socks(String itemName, double itemPrice, double itemDiscount, int itemQuantity, String color) {
		super(itemName, itemPrice, itemDiscount, itemQuantity, color);
	}

	
	@Override
	public String toString() 
	{
		return String.format("%-20s %10.2f %10.2f %5d", this.getItemName(), this.getItemPrice(), this.getItemDiscount(), this.getItemQuantity());
	}
}
