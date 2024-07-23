package shoppingProject;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	//----------------------|Class Att.
	private static int maxID=0;
	//----------------------|Instance Att.
	private int cartid;
	public List<Item> items; // object list 
	public int count=0;
	// extra var. total
	//-----------------------------------|constructor
	ShoppingCart()
	{
		setID();
		items=new ArrayList<Item>();
		count=0;
		System.out.println("\n ---<Warrning: Please note that max.Cart capacity=10 items>---");
	}
	ShoppingCart(int cItems) // constructors are not chained
	{
		if(cItems<=10&&cItems>0)
			items=new ArrayList<Item>();;
		count=0;
		setID();
		System.out.println("\n ---<Warrning: Max.Cart capacity=10 items & Now it set to"+cItems+">---");
	}
	//-----------------------------------|Getter Methods
	public int getCount(){
		return count;
	}
	
	public int getID() {
		return cartid;
	}
	//-----------------------------------|Extra Functions/Methods
	public double getTotal(){
		double total=0.0;
		for(int i=0; i<count;i++){
			total+= items.get(i).getPrice();
		}
		return total;
	}
	//-----------------------------------|
	public void addItem(Item i){
		if(count<10)
			items.add(i);
		else
			System.out.println("\n ---<Cart Overflow: 10 items at maxiumum>---");
	}
	//-----------------------------------|
	public void removeItem(int itemID){
		boolean found=false;        
		for(int i=0; i<count;i++){
			if(items.get(i).getID() == itemID){
				items.remove(itemID);
				found=true; 
				break;
			}           
		}        
		if(found)
			System.out.println("\n ---<Remove done and Items are shifted>---");
		else
			System.out.println("\n ---<Item is not found>---");
	} 
	//-----------------------------------|Extra Methods
		private void setID() {
			this.cartid=++ShoppingCart.maxID;
		}
	//-----------------------------------|
	public void displayCart(){        
		// for(Item it : items) // error if list is not full
		for(int i=0; i<count;i++)
			items.get(i).display();       
	}
}
