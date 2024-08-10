package items.Jewelry;

import items.Item;

public class Jewelry extends Item{

	private int karat = 0;
	
	public Jewelry(String itemName, double itemPrice, double itemDiscount, int itemQuantity, int karat) {
		super(itemName, itemPrice, itemDiscount, itemQuantity);
		setKarat(karat);
	}

	public int getKarat() {
		return karat;
	}

	public void setKarat(int karat) {
		if(karat >= 8 && karat <= 24) {
			this.karat = karat;
		}
		else {
			System.out.println("Invalid data please check your data");
		}
	}

}
