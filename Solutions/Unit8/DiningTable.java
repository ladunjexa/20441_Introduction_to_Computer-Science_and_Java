package Unit8;

public class DiningTable extends Table {

	public DiningTable(int price, double surfaceArea) {
		super(price, surfaceArea);
	}

	public void use() {
		System.out.println("I'm eating");
	}

	public void addPlates() {
		System.out.println("Added plates");
	}

}
