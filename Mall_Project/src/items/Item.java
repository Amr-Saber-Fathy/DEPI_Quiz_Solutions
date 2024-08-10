package items;

public abstract class Item {

	private static int maxID = 10000;
	private String itemName = "";
	private double itemPrice = 0.0;
	private double itemDiscount = 0.0;
	private int itemQuantity = 0;
	
	////////////////Constructors///////////////////
	private Item() 
	{
		setMaxID();
	}
	
	public Item(String itemName, double itemPrice, double itemDiscount, int itemQuantity) 
	{
		this();
		setItemName(itemName);
		setItemPrice(itemPrice);
		setItemDiscount(itemDiscount);
		setItemQuantity(itemQuantity);
	}
	
	//////////////////Getters and Setters//////////////////
	public static int getMaxID() {
		return maxID;
	}
	private static void setMaxID() {
		Item.maxID++;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		if(itemName == null || itemName == "" || itemName.length()<=3) {
			System.out.println("Invalid Item Name");
		}
		else {
			this.itemName = itemName;
		}
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		if(itemPrice <= 0.0) {
			System.out.println("Invalid Item Price");
		}
		else {
			this.itemPrice = itemPrice;
		}
	}
	
	public double getItemDiscount() {
		return itemDiscount;
	}
	public void setItemDiscount(double itemDiscount) {
		if(itemDiscount < 0.0 || itemDiscount > 0.5) {
			System.out.println("Invalid Item Discount");
		}
		else {
			this.itemDiscount = itemDiscount;
		}
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		if(itemQuantity < 0) {
			System.out.println("Invalid value for Quantity");
		}
		else {
			this.itemQuantity += itemQuantity;
		}
	}
	
	public void removeItemQuantity(int quantity) {
		if(quantity > 0 && this.itemQuantity > 0) {
			this.itemQuantity -= quantity;
		}
		else {
			System.out.println("Invalid value for Quantity");
		}
	}
	//////////////////////////////////////////////////////////
	
	
	@Override
	public String toString() 
	{
		return String.format("%-20s %10.2f %10.2f %5d "
				, this.getItemName(), this.getItemPrice(), this.getItemDiscount(), this.getItemQuantity());
	}
}
