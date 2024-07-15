package secondQuizSolution;

public class SwapValues {

	
	
	public static void main(String[] args) {
		
		int x = 5;
		int y = 8;
		
		System.out.println("x = "+ x + " and y = " + y);
		
		//Swap Values of x and y
		x += y;
		y = x - y;
		x -= y;
		
		System.out.println("x = "+ x + " and y = " + y);
	}

}
