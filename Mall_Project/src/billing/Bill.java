package billing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import items.Item;

public class Bill {

	private static int maxBillID = 0;
	private ShoppingCart cart;
	private LocalDate billDate;
	
	public Bill(ShoppingCart cart, LocalDate billDate) 
	{
		setMaxBillID();
		setCart(cart);
		setBillDate(billDate);
	}

	public static int getMaxBillID() {
		return maxBillID;
	}

	private static void setMaxBillID() {
		Bill.maxBillID ++;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		if(cart == null) {
			System.out.println("Invalid Data please check again");
		}
		else {
			this.cart = cart;
	
		}
	}
	
	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		if(billDate == null) {
			System.out.println("Invalid Date");
		}
		this.billDate = billDate;
	}
	
	///////////////////////////////////////////////////////
	
	public double calculateTotalPrice(Item item) {
		return ((item.getItemPrice()* (1 - item.getItemDiscount())) * item.getItemQuantity());
	}
	
	@Override
	public String toString() 
	{
		double total = 0.0;
		String billing = "";
		billing += String.format("Bill Date : %10s\n", this.getBillDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		billing += "===============================================================\n";
		billing += "                            YOUR STORE                          \n";
		billing += "===============================================================\n";
		billing += String.format("%-20s %10s %10s %5s %12s\n", "Item", "Price", "Discount", "Qty", "Total");
		for(Item item : this.cart.getItems()) {
			billing += item;
			billing += String.format("%14.2f", this.calculateTotalPrice(item));
			billing += "\n";
			total += ((item.getItemPrice() * (1 - item.getItemDiscount())) * item.getItemQuantity());
		}
		billing += "===============================================================\n";
		billing += String.format("Total Price         = %40.2f\n", total);
		return billing;
	}

	
}
