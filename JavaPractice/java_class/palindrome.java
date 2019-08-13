package java_class;

public class palindrome {
	public static void pali(String str) {
		String rev;
		rev = "";
		int len = str.length()-1;
				for(int i=len;i>=0;i--)
				rev =rev + str.charAt(i);
				if (str.equals(rev))
					System.out.println(str+" is a palindrome");
				else
					System.out.println(str+" is not palindrome");
				
	}

	public static void main(String[] args) {
		pali("succus");
		

	}

}
