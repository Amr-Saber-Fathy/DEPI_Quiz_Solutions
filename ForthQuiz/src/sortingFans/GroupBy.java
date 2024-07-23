package sortingFans;

public class GroupBy {

//	private static void swapFan(Fan fan1, Fan fan2) 
//	{
//		Fan tempfan = new Fan();
//		tempfan = fan1;
//		fan1 = fan2;
//		fan2 = tempfan;
//	}
	
	//Grouping By color
	public static void color(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[i].getColor().equalsIgnoreCase(fans[j].getColor())) 
				{	
					Fan tempfan = new Fan();
					tempfan = fans[i+1];
					fans[i+1] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Model
	public static void model(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[i].getModel().equalsIgnoreCase(fans[j].getModel())) 
				{	
					Fan tempfan = new Fan();
					tempfan = fans[i+1];
					fans[i+1] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Status(on,off)
	public static void status(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[i].getStatus()== fans[j].getStatus()) 
				{	
					Fan tempfan = new Fan();
					tempfan = fans[i+1];
					fans[i+1] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Radius (Sorting Ascending)
	public static void radiusAscending(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[j].getRadius() <= fans[i].getRadius()) 
				{
					Fan tempfan = new Fan();
					tempfan = fans[i];
					fans[i] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Radius (Sorting Descending)
	public static void radiusDescending(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[j].getRadius() >= fans[i].getRadius()) 
				{
					Fan tempfan = new Fan();
					tempfan = fans[i];
					fans[i] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Speed (Sorting Ascending)
	public static void speedAscending(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[j].getSpeed() < fans[i].getSpeed()) 
				{
					Fan tempfan = new Fan();
					tempfan = fans[i];
					fans[i] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
	//Grouping By Speed (Sorting Descending)
	public static void speedDescending(Fan[] fans) 
	{
		for(int i=0; i<fans.length -1; i++) 
		{
			for(int j=i+1; j<fans.length; j++) 
			{
				if(fans[j].getSpeed() > fans[i].getSpeed()) 
				{
					Fan tempfan = new Fan();
					tempfan = fans[i];
					fans[i] = fans[j];
					fans[j] = tempfan;
				}
			}
		}
	}
	
}
