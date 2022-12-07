/**
 * class Rent is used for represent a Rent object.
 * 
 * @author Liron Abutbul
 * @version 2023A
 */

public class Rent {
	// DECLARATIONS
	// fields
	private String _name;
	private Car _car;
	private Date _pickDate;
	private Date _returnDate;

	// final values for base price per day according to model
	private static final int BASE_PRICE_MDL_A = 100;
	private static final int BASE_PRICE_MDL_B = 150;
	private static final int BASE_PRICE_MDL_C = 180;
	private static final int BASE_PRICE_MDL_D = 240;

	// final values for discount value and periods.
	private static final double WEEKLY_RENTAL_DISCOUNT = 0.1;
	private static final int DAYS_PER_WEEK = 7;
	private static final int MINIMUM_RENTAL_PERIOD = 1;

	// final values for car types
	private static final char BEST_TYPE_VAL = 'D';
	private static final char ALMOST_BEST_TYPE_VAL = 'C';
	private static final char ALMOST_WORST_TYPE_VAL = 'B';
	private static final char WORST_TYPE_VAL = 'A';

	// CONSTRUCTORS
	/**
	 * Creates a new Rent object The return date must be at least one day after the
	 * pickup date, otherwise set it to one day after the pick up date.
	 * 
	 * @param name the client's name
	 * @param car  the rented car
	 * @param pick the pickup date
	 * @param ret  the return date
	 */
	public Rent(String name, Car car, Date pick, Date ret) {
		_name = name;
		_car = new Car(car);
		if (pick.difference(ret) < MINIMUM_RENTAL_PERIOD) { // Checking whether the rental period is shorter than the
															// minimum required time, if so, set the return date a day
															// after the pick date.
			_pickDate = new Date(pick);
			_returnDate = new Date(pick.tomorrow());
		} else { // Otherwise, set received dates.
			_pickDate = new Date(pick);
			_returnDate = new Date(ret);
		}
	}

	/**
	 * Copy constructor
	 * 
	 * @param other the rent to be copied
	 */
	public Rent(Rent other) {
		_name = other._name;
		_car = new Car(other._car);
		_pickDate = new Date(other._pickDate);
		_returnDate = new Date(other._returnDate);
	}

	// METHOD FUNCTIONS
	/**
	 * Gets the car
	 * 
	 * @return the car
	 */
	public Car getCar() {
		return new Car(_car);
	}

	/**
	 * Gets the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return _name;
	}

	/**
	 * Gets the pick up date
	 * 
	 * @return the pick up date
	 */
	public Date getPickDate() {
		return new Date(_pickDate);
	}

	/**
	 * Gets the return date
	 * 
	 * @return the return date
	 */
	public Date getReturnDate() {
		return new Date(_returnDate);
	}

	/**
	 * Sets the rented car
	 * 
	 * @param car the rented car (You can assume that car is not null)
	 */
	public void setCar(Car car) {
		_car = new Car(car);
	}

	/**
	 * Sets the client name
	 * 
	 * @param name the client name (You can assume that the name is a valid name)
	 */
	public void setName(String name) {
		_name = name;
	}

	/**
	 * Sets the pick up date The pick up date must be at least one day before the
	 * return date, otherwise - don't change the pick up date
	 * 
	 * @param pickDate the pick up date (You can assume that pick up date is not
	 *                 null)
	 */
	public void setPickDate(Date pickDate) {
		if (pickDate.difference(_returnDate) > MINIMUM_RENTAL_PERIOD && pickDate.before(_returnDate)) 
			// Verification that the difference between the  dates is at least a day, and 
			// that the current pick date precedes the new return date.
			_pickDate = new Date(pickDate);
	}

	/**
	 * Sets the return date The return date must be at least one day after the pick
	 * up date, otherwise - don't change the return date
	 * 
	 * @param returnDate the return date (You can assume that return date is not
	 *                   null)
	 */
	public void setReturnDate(Date returnDate) {
		if (returnDate.difference(_pickDate) > MINIMUM_RENTAL_PERIOD && returnDate.after(_pickDate))
			// Verification that the difference between the dates is at least a day, and
			// that the current return date after the new pick date.
			_returnDate = new Date(returnDate);
	}

	/**
	 * Check if 2 rents are the same
	 * 
	 * @param other the rent to compare this rent to
	 * @return true if the rents are the same
	 */
	public boolean equals(Rent other) {
		return _car.equals(other._car) && _name.equals(other._name) && _pickDate.equals(other._pickDate)
				&& _returnDate.equals(other._returnDate);
	}

	/**
	 * Returns the number of rent days
	 * 
	 * @return the number of rent days
	 */
	public int howManyDays() {
		return _returnDate.difference(_pickDate);
	}

	/**
	 * Gets the rent total price
	 * 
	 * @return the rent total price
	 */
	public int getPrice() {
		int totalPrice = 0, assistPrice = 0;
		switch (_car.getType()) { // Calculation of base price for car rental according to rental days, depending
									// on the car model using switch statement logic.
		case WORST_TYPE_VAL:
			totalPrice = BASE_PRICE_MDL_A * this.howManyDays();
			break;
		case ALMOST_WORST_TYPE_VAL:
			totalPrice = BASE_PRICE_MDL_B * this.howManyDays();
			break;
		case ALMOST_BEST_TYPE_VAL:
			totalPrice = BASE_PRICE_MDL_C * this.howManyDays();
			break;
		case BEST_TYPE_VAL:
			totalPrice = BASE_PRICE_MDL_D * this.howManyDays();
			break;
		}
		assistPrice = (int) (totalPrice / this.howManyDays()); // Reverse calculation to get the price for a day
																// according to the model, in order to apply a discount
																// corresponding to the car model.
		totalPrice -= (int) ((this.howManyDays() / DAYS_PER_WEEK)
				* (DAYS_PER_WEEK * assistPrice * WEEKLY_RENTAL_DISCOUNT)); // Calculation of fixed rental period in
																			// weeks * matching weekly
																			// discount according to model and discount
																			// value
		return totalPrice;
	}

	/**
	 * Try to upgrade the car to a better car If the given car is better than the
	 * current car of the rent, upgrade it and return the upgrade additional cost,
	 * otherwise - don't upgrade
	 * 
	 * @param car the car to upgrade to
	 * @return the upgrade cost
	 */
	public int upgrade(Car newCar) {
		if (_car.worse(newCar)) { // Necessary condition for upgrading: Is the current vehicle worse than the new
									// vehicle
			int oldPrice = this.getPrice(); // Save the price for current vehicle
			_car = new Car(newCar); // Assign new car object of newCar to object car field (_car).
			return this.getPrice() - oldPrice; // Subtracting the new price from the previous price and returning it as
												// a numerical value. (getPrice method already handles cases of
												// casting).
		}
		return 0;
	}

	/**
	 * Check if there is a double listing of a rent for the same person and car with
	 * an overlap in the rental days If there is - return a new rent object with the
	 * unified dates, otherwise - return null.
	 * 
	 * @param other the other rent
	 * @return the unified rent or null
	 */
	public Rent overlap(Rent other) {
		if (_name.equals(other._name) && _car.equals(other._car)) { // Check whether the rentals are the same in terms
																	// of the car and the name.
			if (_pickDate.before(other._returnDate) && other._pickDate.before(_returnDate)) { // Checking whether the
																								// current pick date is
																								// before the 'other'
																								// return date AND
																								// 'other' pick date is
																								// before current return
																								// date, which gives us
																								// an overlap between
																								// the dates.
				return new Rent(_name, _car, _pickDate.before(other._pickDate) ? _pickDate : other._pickDate,
						_returnDate.after(other._returnDate) ? _returnDate : other._returnDate); // return new rental
																									// object with the
																									// earlier date, and
																									// the latest
																									// between the
																									// dates.
			}
		}
		return null;
	}

	/**
	 * Returns a String that represents this rent
	 * 
	 * @return String that represents this rent in the following format: Name:Rama
	 *         From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
	 */
	public String toString() {
		return "Name:" + _name + " From:" + _pickDate.toString() + " To:" + _returnDate.toString() + " Type:"
				+ _car.getType() + " Days:" + this.howManyDays() + " Price:" + this.getPrice();
	}

}
