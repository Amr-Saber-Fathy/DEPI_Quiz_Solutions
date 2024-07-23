package shoppingProject;

import java.time.LocalDate;

public class Bill {

	int billID;
	LocalDate billDate;
	//item list 
	ShoppingCart SC;
	String customer;
	double total;
	double dis;
	private static int maxID=0;

	Bill(){
		setBillID();
		billDate=LocalDate.now();
		SC=new ShoppingCart();
		customer="";
		total=0.0;
		dis=0.05;
	}
	Bill(ShoppingCart s, String name, double dis){
		setBillID();
		this.billDate=LocalDate.now();
		this.SC=s;
		this.customer=name;        
		this.dis=dis;
		this.total=getTotal();
	}

	private void setBillID() {
		billID=++Bill.maxID;
	}
	public double getTotal(){ // calc
		return (SC.getTotal()-(SC.getTotal()*dis));        
	}
	public void display(){
		System.out.println("Bill_ID:\t"+billID);
		System.out.println("Bill_Date:\t"+billDate);
		System.out.println("Customer:\t"+customer);
		System.out.println("Bill_total:"+total);
		System.out.println("Bill_Items="+SC.count);
		//SC.displayCart(); 

		System.out.println("ID\tTitle\tPrice");
		for(int i=0; i<SC.count;i++)
			System.out.println(SC.items.get(i));
	}
      
}
