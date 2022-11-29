package Unit8;

public abstract class Furniture {

	protected int _price;

	public Furniture(int price) {
		_price = price;
	}

	public abstract void use();

	public abstract void clean();

	public String toString() {
		return "Price is: " + _price;
	}

}
