package simpleProgrames;

public class PrintPrimeNumbers {
	
	public static void printingPrimes(int n) {
		System.out.print("The Prime number upto "+n +" are : ");
		
		boolean p = true;
		int count = 0;
		if(n<2) 
		{
			System.out.print("There are no valid Prime Numbers under "+ n);
			p = false;
			
		}
		
		for (int i=2;i<=n;i++) {
			
			for(int j=2; j<=i/2; j++ ) {
				
				if(i%j==0) {
					p = false;
					break;
				}
				else {
					p= true;		
				}
				
				}
			if(p)  {
				System.out.print(i +" ");
				count = count + 1;
			}
				
			}
		System.out.print(".");

		System.out.println();
		System.out.print("The total Number's of Prime Numbers upto "+n+" are: "+count);
			
			
		}
	

	public static void main(String[] args) {

		
		printingPrimes(100);
	}

}
