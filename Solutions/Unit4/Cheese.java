package Unit4;

public class Cheese {

	private String _type;
	private double _fatPercentage;

	private final int MIN_PERCENTAGE = 0;
	private final int MAX_PERCENTAGE = 100;

	public Cheese() {
		_type = "Mozzarella";
		_fatPercentage = MIN_PERCENTAGE;
	}

	public Cheese(String type, double fatPercentage) {
		_type = type.equals("") ? "Mozzarella" : _type;
		_fatPercentage = isValidFatPercentage(fatPercentage) ? fatPercentage : MIN_PERCENTAGE;
	}

	public Cheese(Cheese other) {
		_type = other._type;
		_fatPercentage = other._fatPercentage;
	}

	public String getType() {
		return _type;
	}

	public double getFatPercentage() {
		return _fatPercentage;
	}

	public void setType(String type) {
		if (!type.equals(""))
			_type = type;
	}

	public void setFatPercentage(double fatPercentage) {
		if (isValidFatPercentage(fatPercentage))
			_fatPercentage = fatPercentage;
	}

	public boolean isGoudaCheese() {
		return _type.equals("Gouda");
	}

	public boolean equals(Cheese other) {
		return _type.equals(other._type) && _fatPercentage == other._fatPercentage;
	}

	public String toString() {
		return "Cheese type: " + _type + ", fat percentage: " + _fatPercentage;
	}

	private boolean isValidFatPercentage(double fatPercentage) {
		return MIN_PERCENTAGE <= fatPercentage && fatPercentage <= MAX_PERCENTAGE;
	}

}
