package simpleProgrames;

public class StarPattern2 {
	
	public static void stars(int n) 
	{
	 int i,j;
	 
	// outer loop to handle number of rows 
    //  n in this case 
	 
	 for(i=0; i<n; i++) {
		 
		//  inner loop to handle number of columns 
        //  values changing acc. to outer loop  
		 
		 for(j=0; j<=i; j++) {
			 
		 // printing stars 	 
		 System.out.print("* ");
		}
		 
	   // ending line after each row	 
	   System.out.println();
	 }
	}
	

	public static void main(String[] args) {
		stars(5);

	}

}
