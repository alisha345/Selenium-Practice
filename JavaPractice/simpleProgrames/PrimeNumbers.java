package simpleProgrames;

public class PrimeNumbers {
	
	public static void primes(int n) { 
		boolean p = true;
		if(n<2) 
		{
			System.out.println(n+" is not a Prime number.");
			p = false;
			
		}
		for(int i=2; i<=n/2; i++) {
			
			if(n % i == 0)
			{
				System.out.println(n+" is not a Prime Number.");
				p = false;
				break;
			}
		}
		if (p) {
		System.out.println(n+" is a Prime Number");
		}
	}

	public static void main(String[] args) {
		 
		primes(5);

	}

}
