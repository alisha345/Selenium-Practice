package java_class;

public class OppsConcept 
//Creating a class
{
	int a = 10,b=20,c;
	//Creating add method
	public void add()
	{
		c= a+b;
		System.out.println("Addition of A & B is : " +c + "\n" );
	}
	//Creating a sub method
	public void sub()
	{
		c = b-a;
		System.out.println("Difference between A & B is : " +c +"\n");
	}
	

	public static void main(String[] args) 
	{
		//Creating a object "obj" inside "OppsConcept" class
		OppsConcept obj = new OppsConcept();
		obj.add();// calling methods
		obj.sub();
		Test obj2 = new Test();
		obj2.details();
		OppsConcept obj1 = new OppsConcept();// Creating 2nd onject inside same class
		obj1.add();
		obj1.sub();
		
		
	}

}
class Test//creating another class
{
	String a ="Sajid";
	int c = 27;
	public void details()
	{
		System.out.println("My name is " +a + ", my age is " +c+"\n");
	}
}