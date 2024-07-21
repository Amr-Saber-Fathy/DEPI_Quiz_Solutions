package forthQuizSolution;

public class Patterns {

	private int baseNumber;

	public Patterns(int baseNumber) 
	{
		this.baseNumber = baseNumber;
	}

	public int getBaseNumber() {
		return baseNumber;
	}

	public void setBaseNumber(int baseNumber) {
		this.baseNumber = baseNumber;
	}

	public void patternA() 
	{
		for(int i = 1; i <= baseNumber ; i++) 
		{
			for(int j = 1; j<=i; j++) 
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public void patternB() 
	{
		for(int i = baseNumber; i >= 1 ; i--) 
		{
			for(int j = 1; j<=i; j++) 
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public void patternC() 
	{
		for(int i = 1; i <= baseNumber ; i++) 
		{
			for(int j = baseNumber; j>=1; j--) 
			{
				if(j<=i) 
				{
					System.out.print(j+" ");
				}
				else 
				{
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public void patternD() 
	{
		for(int i = 0; i < baseNumber ; i++) 
		{
			for(int j = 1; j<=baseNumber; j++) 
			{
				if((j-i) <= 0) 
				{
					System.out.print("  ");
				}
				else 
				{
					System.out.print((j-i) + " ");
				}
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public void patternE() 
	{
		//		this.patternC();
		//		this.patternA();
		for(int i = 1; i <= baseNumber ; i++) 
		{
			//Spacing
			for(int j = i; j < baseNumber; j++) 
			{
				System.out.print("  ");
			}
			//Decreasing
			for(int j = i; j>=1; j--) 
			{
				System.out.print(j+" ");
			}
			//increasing from 2 for not repeating the 1s column
			for(int j = 2; j<=i; j++) 
			{
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public void patternF() 
	{
		for(int i = 1; i <= baseNumber ; i++) 
		{
			//Spacing
			for(int j = i; j < baseNumber; j++) 
			{
				System.out.print("    ");
			}
			//increasing (if statements are only for organizing the output spacing)
			for(int j = 1; j<=i; j++) 
			{
				if(String.valueOf((1<<(j-1))).length() == 2)
					System.out.print((1<<(j-1))+"  ");
				else if(String.valueOf((1<<(j-1))).length() == 3)
					System.out.print((1<<(j-1))+" ");
				else
					System.out.print((1<<(j-1))+"   ");
			}
			//Decreasing (if statements are only for organizing the output spacing)
			for(int j = i-1; j>=1; j--) 
			{
				if(String.valueOf((1<<(j-1))).length() == 2)
					System.out.print((1<<(j-1))+"  ");
				else if(String.valueOf((1<<(j-1))).length() == 3)
					System.out.print((1<<(j-1))+" ");
				else
					System.out.print((1<<(j-1))+"   ");
			}
			System.out.println();
		}
		System.out.println("========================================");
	}

	public static void main(String[] args) {
		Patterns pattern = new Patterns(6);
		pattern.patternA();
		pattern.patternB();
		pattern.patternC();
		pattern.patternD();
		pattern.patternE();
		pattern.patternF();
	}
}
