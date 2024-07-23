package shoppingProject;

public class Main {

	public static void main(String[] args) {
		ShoppingCart SC=new ShoppingCart();
		Item item01=new Item("Shirt",50.0);
		Item item02=new Item("Pant",100.0);

		SC.addItem(item01);
		SC.addItem(item02);

		Item []itemList={new Item("IT3",100.0),new Item("IT4",100.0),new Item("IT5",100.0)};
		for(Item it : itemList)
			SC.addItem(it);

		//SC.displayCart();

		System.out.println("ID\tTitle\tPrice");
		for(Item i:SC.items)
			System.out.println(i);
		//---------------------------
		System.out.println("ID\tTitle\tPrice");
		for(int i=0; i<SC.count;i++)
			System.out.println(SC.items.get(i));

		System.out.println("\nTotal Items in Cart= "+SC.getCount());
		System.out.println("\n-------------------------");
		/*
        SC.removeItem(5);
        SC.getCount();
        SC.displayCart();

        System.out.println("\n> Total Cart bill= "+SC.getTotal());
		 */
		// Task: move segment code into Bill class with 4 attributes: bill code, billDate, customer, shoppingCart
		Bill b=new Bill(SC, "Mina", 0.1);
		b.display();
	}

}
