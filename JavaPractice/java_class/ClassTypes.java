package java_class;

public class ClassTypes { //outer class (public)
	/**M
	 * 
	 */
int a = 100;

public void  method(int a) {
	this.a = a;
	System.out.println("Method value = "+a);
}
public static void main(String[] args) {
	ClassTypes c = new ClassTypes();
	c.method(20);
	c.method(30);
	System.out.println("Changed Mehod Value = "+c.a);
}
}


