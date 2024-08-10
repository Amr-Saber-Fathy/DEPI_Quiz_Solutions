package items.Clothing;

public abstract class ClothingWithSize extends Clothing implements HaveSize{

	private Object size = "";
	
	public ClothingWithSize(String itemName, double itemPrice, double itemDiscount, int itemQuantity, String color, Object size) {
		super(itemName, itemPrice, itemDiscount, itemQuantity, color);
		setSize(size);
	}

	public Object getSize() {
		return size;
	}

	// || !(availableSizes.contains(size))
	public void setSize(Object size) {
		if(size == null || size == "" ) {
			System.out.println("Invalid size");
		}
		else {
			this.size = size;
		}
	}


	public abstract void addAvailableSize(Object size);
	public abstract void removeAvailableSize(Object size);
}
