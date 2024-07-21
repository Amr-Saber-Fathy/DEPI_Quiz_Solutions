package forthQuizSolution;

public class Fan {

	//Constants
	final int SLOW = 1;
	final int MEDIUM = 2;
	final int FAST = 3;

	//Data Variables
	private int speed = SLOW;
	private boolean on = false;
	private double radius = 5.0;
	private String color = "blue";
	private String model = "ABC";


	//Constructors
	//zero argument constructor
	public Fan() 
	{
		setModel("ABC");
	}

	//one argument constructor
	public Fan(int speed) 
	{
		this();
		this.speed = speed;
	}

	//two arguments constructor
	public Fan(int speed, boolean status) 
	{
		this(speed);
		this.on = status;
	}

	//three arguments constructor
	public Fan(int speed, boolean status, double radius) 
	{
		this(speed, status);
		this.radius = radius;
	}

	//four arguments constructor
	public Fan(int speed, boolean status, double radius, String color) 
	{
		this(speed, status, radius);
		this.color = color;
	}

	//Getters and Setters
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean getStatus() {
		return on;
	}
	public void setStatus(boolean on) {
		this.on = on;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() 
	{
		return "Fan :{"+
				"Model = '"+model+"'"+
				", Color = '"+color+"'"+
				", Radius = '"+radius+"'"+
				", Speed = '"+speed+"'"+
				", Is on = '"+on+"'}";
	}
	
	public static void main(String[] args) 
	{
		Fan fan = new Fan();
		System.out.println(fan.toString());
	}
}
