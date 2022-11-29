package Unit4;

public class CheeseTester {

	public static void main(String[] args) {
		Cheese c1 = new Cheese();
		System.out.println(c1.getType());
		
		Cheese c2 = new Cheese("Gouda", 2.5);
		System.out.println(c2.getFatPercentage());
		
		c2.setFatPercentage(4.5);
		System.out.println(c2.getFatPercentage());
		
		System.out.println(c1.equals(c2));
	}

}
