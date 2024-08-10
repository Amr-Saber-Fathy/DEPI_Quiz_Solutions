package items.Clothing;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Shirt extends ClothingWithSize implements IsReturnable{

	public Shirt(String itemName, double itemPrice, double itemDiscount, int itemQuantity, String color, Object size) {
		super(itemName, itemPrice, itemDiscount, itemQuantity, color, size);
	}

	
	public void addAvailableSize(Object size) 
	{
		if(availableSizes.contains(size)) {
			System.out.println("This size already exists");
		}
		else {
			availableSizes.add(size);
		}
	}
	
	public void removeAvailableSize(Object size) 
	{
		if(availableSizes.contains(size)) {
			availableSizes.remove(size);
		}
		else {
			System.out.println("This size doesn't exist");
		}
	}
	
	
	@Override
	public String toString() 
	{
		return String.format("%-20s %10.2f %10.2f %5d", this.getItemName(), this.getItemPrice(), this.getItemDiscount(), this.getItemQuantity());
	}


	@Override
	public boolean isReturnable(LocalDate soldDate) {
		if(ChronoUnit.DAYS.between(LocalDate.now(), soldDate) <= 14) {
			return true;
		}
		else {
			return false;
		}
	}


	
	
}
