package items.Clothing;


public class Shirt extends ClothingWithSize{

	public Shirt(String itemName, double itemPrice, double itemDiscount, String color, Object size) {
		super(itemName, itemPrice, itemDiscount, color, size);
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
		return "Shirt : " + getMaxID() + " ==> " + getItemName() 
		+ " : " + getItemPrice() + "has a discount of : " 
		+ getItemDiscount() + " and the size : " + getSize();
	}
	
}
