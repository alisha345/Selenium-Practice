package simpleProgrames;

public class StarPattern3 {
	
	public static void stars(int n) 
	{
	 int i,j;
	 
	 // outer loop to handle number of rows 
     //  n in this case 
     for(i=0; i<n; i++) 
     { 

         // inner loop to handle number spaces 
         // values changing acc. to requirement 
         for(j=2*(n-i); j>1; j--) 
         { 
             // printing spaces 
             System.out.print(" "); 
         } 
          
         //  inner loop to handle number of columns 
         //  values changing acc. to outer loop 
         for(j=0; j<=i; j++) 
         { 
             // printing stars 
             System.out.print("* "); 
         } 
           
         // ending line after each row 
         System.out.println(); 
	 }
	}

	public static void main(String[] args) {
		
		stars(-1);

	}

}
