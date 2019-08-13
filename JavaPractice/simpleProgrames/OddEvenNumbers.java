package simpleProgrames;

public class OddEvenNumbers {
	
	public static void logic1(int n,int b) {
		System.out.println("The even numbers between"+n +" and "+b+" are :");
		for(int i=n;i<=b;i++) {
			
		/* Chek wheather Given integer is Even or odd
		 * 
		 
		 if(n%2==0){
			System.out.println(n+" is Even Number");
		}
		else {
			System.out.println(n+" is odd Number");
		}
		*/	
			if(i%2==0) {
				
				System.out.print(i+" ");
			}
			
	}
		System.out.println();
		System.out.println("The odd numbers between"+n +" and "+b+" are :");
		for(int i=n;i<=b;i++) {
			
				if(!(i%2==0)) {
					
					System.out.print(i+" ");
				}
				
		}
	}

	public static void main(String[] args) {
		
		logic1(-100, 100);

	}

}
