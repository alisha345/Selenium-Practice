package simpleProgrames;


public class ArmStrongNumber {
	
	public static void logic(int n) {

		int i,c,t,a=0;
		String s1 = Integer.toString(n);
		int b = n;
		
		
		for(i=1; i<=s1.length() ; i++) {
			c = b/10;
			t = b%10;
			a = (int) (a + Math.pow(t,s1.length()));
			b=c;
		}
		if (a==n) {
			System.out.println(n+" is ArmStrong Number");
		}
		else {
			System.out.println(n+" is not a ArmStrong Number.");
		}
	
	if(s1.length()==1) {
		System.out.println("All Signle digits are Armstrong Numbers.");
	}
	}
	
public static void main(String[] args) {

		
		logic(548874);
	}

}
