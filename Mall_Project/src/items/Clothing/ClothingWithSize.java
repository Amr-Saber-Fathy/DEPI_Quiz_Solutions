package items.Clothing;

public abstract class ClothingWithSize extends Clothing implements HaveSize{

	private Object size = "";
	
	public ClothingWithSize(String itemName, double itemPrice, double itemDiscount, String color, Object size) {
		super(itemName, itemPrice, itemDiscount, color);
		setSize(size);
	}

	public Object getSize() {
		return size;
	}

	public void setSize(Object size) {
		if(size == null || size == "" || !(availableSizes.contains(size))) {
			System.out.println("Invalid size");
		}
		else {
			this.size = size;
		}
	}


	public abstract void addAvailableSize(Object size);
	public abstract void removeAvailableSize(Object size);
}
