package Unit4;

public class Sandwich {

	private Cheese _cheese;
	private double _price;
	private boolean _isGrain;

	private final static double DEFAULT_PRICE = 10.0;
	private final int MAX_FAT_PERCENTAGE = 5;

	public Sandwich(Cheese cheese, double price, boolean isGrain) {
		_cheese = new Cheese(cheese);
		if (price < 0)
			_price = DEFAULT_PRICE;
		else
			_price = price;
		_isGrain = isGrain;
	}

	public Sandwich() {
		this(new Cheese(), DEFAULT_PRICE, true);
	}

	public Sandwich(String type, double fatPercentage, double price, boolean isGrain) {
		this(new Cheese(type, fatPercentage), price, isGrain);
	}

	public Sandwich(Sandwich other) {
		this(other._cheese, other._price, other._isGrain);
	}

	public Cheese getCheese() {
		return new Cheese(_cheese);
	}

	public double getPrice() {
		return _price;
	}

	public boolean isGrain() {
		return _isGrain;
	}

	public void setCheese(Cheese cheese) {
		_cheese = new Cheese(cheese);
	}

	public void setPrice(double price) {
		if (price > 0)
			_price = price;
	}

	public void setIsGrain(boolean isGrain) {
		_isGrain = isGrain;
	}

	public boolean isGoudaSandwich() {
		return _cheese.isGoudaCheese();
	}

	public boolean isLight() {
		return _cheese.getFatPercentage() <= MAX_FAT_PERCENTAGE;
	}

	public boolean equals(Sandwich other) {
		return _cheese.equals(other._cheese) && _price == other._price && _isGrain == other._isGrain;
	}

	public String toString() {
		return (_isGrain ? "Grain" : "No grain") + " Sandwich with " + _cheese.toString() + ", it's price is " + _price;
	}

	public boolean isCheaper(Sandwich other) {
		return _price < other._price;
	}

	public boolean isMoreExpensive(Sandwich other) {
		return other.isCheaper(this);
	}

}
