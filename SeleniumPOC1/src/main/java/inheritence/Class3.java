package inheritence;

public class Class3 extends Class2 {

	public void m3() {
		System.out.println("this is a class3");
	}
	
	
	public static void main(String []args) {
		Class2 abc= new Class2();
		Class1 bcd= new Class1();
		//abc.m2();
		abc.m2();
		bcd.m2();
	}
}
