package items;

public abstract class Item {

	private static int maxID = 10000;
	private String itemName = "";
	private double itemPrice = 0.0;
	private double itemDiscount = 0.0;
	
	////////////////Constructors///////////////////
	private Item() 
	{
		setMaxID();
	}
	
	public Item(String itemName, double itemPrice, double itemDiscount) 
	{
		this();
		setItemName(itemName);
		setItemPrice(itemPrice);
		setItemDiscount(itemDiscount);
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
		if(itemName == null || itemName == "" || itemName.length()>=3) {
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
		if(itemDiscount < 0.0 || itemDiscount > 50.0) {
			System.out.println("Invalid Item Discount");
		}
		else {
			this.itemDiscount = itemDiscount;
		}
	}
	
	
}
