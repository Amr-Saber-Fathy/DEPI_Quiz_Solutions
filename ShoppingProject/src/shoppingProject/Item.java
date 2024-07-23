package shoppingProject;

public class Item {

	//----------------------|Class Att.
	private static int maxID=0;
	//----------------------|Instance Att.
	private int id;
	private String title;
	private double price;

	//-----------------------------------|constructor
	Item(String title, double price){
		setID();
		setTitle(title);
		SetPrice(price);
	}
	//-----------------------------------|Setter Methods
	private void setTitle(String title) {
		this.title=title;
	}

	private void SetPrice(double price) {
		if(price>0)
			this.price=price;
		else
		{this.price=0.0; System.out.println("Invalid Item Price");}
	}
	//-----------------------------------|Getter Methods
	public int getID() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public double getPrice() {
		return price;
	}
	//-----------------------------------|Extra Methods
	private void setID() {
		id=++Item.maxID;
	}
	//---------------------------------------
	public void display(){
		System.out.println("\n ------<Item Details>-------");
		System.out.println("ID: "+id);
		System.out.println("Title: "+title);
		System.out.println("Price: "+price);
	}
	//---------------------------------------|Override from Object Class
	@Override
	public String toString(){
		return(id+"\t"+title+"\t"+price) ;
	}
}
