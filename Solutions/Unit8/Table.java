package Unit8;

public abstract class Table extends Furniture {

	protected double _surfaceArea;

	public Table(int price, double surfaceArea) {
		super(price);
		_surfaceArea = surfaceArea;
	}

	public void clean() {
		System.out.println("Cleaning with a mop");
	}
}
