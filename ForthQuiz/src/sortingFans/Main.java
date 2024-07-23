package sortingFans;

public class Main {

	public static void main(String[] args) {
		
		Fan[] fans = {new Fan(), new Fan(), new Fan(), new Fan(), new Fan()};
		fans[0].setColor("Blue");
		fans[1].setColor("Red");
		fans[2].setColor("Red");
		fans[3].setColor("Green");
		fans[4].setColor("Blue");
		
		fans[0].setRadius(5.0);
		fans[1].setRadius(8.0);
		fans[2].setRadius(4.0);
		fans[3].setRadius(6.0);
		fans[4].setRadius(9.0);
		
		fans[0].setSpeed(Fan.SLOW);
		fans[1].setSpeed(Fan.FAST);
		fans[2].setSpeed(Fan.MEDIUM);
		fans[3].setSpeed(Fan.FAST);
		fans[4].setSpeed(Fan.SLOW);
		
		fans[0].setModel("Toshiba");
		fans[1].setModel("XYZ");
		fans[2].setModel("RPQ");
		fans[3].setModel("Toshiba");
		fans[4].setModel("xyz");
		
		fans[0].setStatus(true);
		fans[1].setStatus(true);
		fans[2].setStatus(false);
		fans[3].setStatus(false);
		fans[4].setStatus(false);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
		
		System.out.println("==============================");
		System.out.println("Testing GroupBy color");
		GroupBy.color(fans);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
		
		System.out.println("==============================");
		System.out.println("Testing GroupBy Radius");
		GroupBy.radiusDescending(fans);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getRadius());
		}
		System.out.println("==============================");
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
		
		System.out.println("==============================");
		System.out.println("Testing GroupBy Speed");
		GroupBy.speedDescending(fans);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getSpeed());
		}
		System.out.println("==============================");
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
		
		System.out.println("==============================");
		System.out.println("Testing GroupBy Model");
		GroupBy.model(fans);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getModel());
		}
		System.out.println("==============================");
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
		
		System.out.println("==============================");
		System.out.println("Testing GroupBy Status");
		GroupBy.status(fans);
		
		for(Fan fan : fans) 
		{
			System.out.println(fan.getStatus());
		}
		System.out.println("==============================");
		for(Fan fan : fans) 
		{
			System.out.println(fan.getColor());
		}
	}

}
