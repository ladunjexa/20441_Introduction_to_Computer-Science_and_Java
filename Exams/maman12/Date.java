package Maman12;

/**
 * class Date is used for represent a Date object.
 * 
 * @author Liron Abutbul
 * @version 03/11/2022
 */

public class Date {
	// DECLARATIONS
	// fields
	private int _day;
	private int _month;
	private int _year;
	
	// validation values for day, month, year
	private final int MIN_VALID_DY = 1, MAX_VALID_DY = 31;
	private final int MIN_VALID_MO = 1, MAX_VALID_MO = 12;
	private final int MIN_VALID_YR = 1000, MAX_VALID_YR = 9999;

	// default date values - the first day and month are considered the default
	private final int FIRST_DAY = 1, FIRST_MONTH = 1, DEFAULT_YEAR = 2000;
	
	// useful-code month values
	private final int FEB = 2, JUL = 7, AUG = 8, DEC = 12;
	
	// CONSTRUCTORS
	/**
	 * If the given date is valid - creates a new Date object. otherwise creates the
	 * date 1/1/2000
	 * @param day   the day in the month (1-31)
	 * @param month the month in the year (1-12)
	 * @param year  the year (4 digits)
	 */
	public Date(int day, int month, int year) {
		if (isValidDate(day, month, year)) { // Checks whether the date is correct, if so sets the received values as parameters
			_day = day;
			_month = month;
			_year = year;
		} else { // otherwise sets default values.
			_day = FIRST_DAY;
			_month = FIRST_MONTH;
			_year = DEFAULT_YEAR;
		}
	}

	/**
	 * Copy constructor
	 * @param other the date to be copied
	 */
	public Date(Date other) {
		_day = other._day;
		_month = other._month;
		_year = other._year;
	}

	// METHOD FUNCTIONS
    /**
	 * Gets the day
	 * @return the day
	 */
	public int getDay() {
		return _day;
	}

    /**
	 * Gets the month
	 * @return the month
	 */
	public int getMonth() {
		return _month;
	}

    /**
	 * Gets the year
	 * @return the year
	 */
	public int getYear() {
		return _year;
	}

    /**
	 * Set the day (only if date remains valid)
	 * @param dayToSet the day value to be set
	 */
	public void setDay(int dayToSet) {
		if (isValidDate(dayToSet, _month, _year)) // Check whether the date with 'dayToSet' day is valid.
			_day = dayToSet;
	}

    /**
	 * Set the month (only if date remains valid)
	 * @param monthToSet the month value to be set
	 */
	public void setMonth(int monthToSet) {
		if (isValidDate(_day, monthToSet, _year)) // Check whether the date with 'monthToSet' month is valid.
			_month = monthToSet;
	}

    /**
	 * Set the year (only if date remains valid)
	 * @param yearToSet the year value to be set
	 */
	public void setYear(int yearToSet) {
		if (isValidDate(_day, _month, yearToSet)) // Check whether the date with 'yearToSet' year is valid.
			_year = yearToSet;
	}

    /**
	 * Check if two dates are the same
	 * @param other the date to compare this date to
	 * @return true if the dates are the same, otherwise false
	 */
	public boolean equals(Date other) {
		return _day == other._day && _month == other._month && _year == other._year; // Comparison of the fields of the two dates.
	}

    /**
	 * Check if this date is before other date
	 * @param other the date to compare this date to
	 * @return true if this date is before other date, otherwise false
	 */
	public boolean before(Date other) {
		if (_year < other._year) // Check whether 'this' object year is before 'other' year.
			return true;
		else if (_year == other._year) // Comparison of the year field of the two dates
			if (_month < other._month) // Check whether 'this' object month is before 'other' month.
				return true;
			else if (_month == other._month)  // Comparison of the month field of the two dates
				if (_day < other._day) // Check whether 'this' object day is before 'other' day.
					return true;
		return false;
	}

    /**
	 * Check if this date is after other date
	 * The logic of the method is that if the 'other' date is before 'this' date, 
	 * then 'this' date must be after 'other' date
	 * @param other the date to compare this date to
	 * @return true if this date is after other date, otherwise false
	 */
	public boolean after(Date other) {
		return other.before(this); // A call to the 'before' method when the method is invoked on 'other', where 'this' is sent as a parameter.		
	}

    /**
	 * Calculates the difference in days between two dates
	 * @param other the date to calculate the difference between
	 * @return the number of days between the dates (non negative value)
	 */
	public int difference(Date other) {
		return Math.abs(calculateDate(other._day, other._month, other._year) - calculateDate(_day, _month, _year)); // Calculating the absolute value of a number expressing the difference between the dates.
	}

    /**
	 * Returns a String that represents this date
	 * @return String that represents this date in the following format: day (2 digits) / month (2 digits) / year (4 digits) for example: 02/03/1998
	 */
	public String toString() {
		return (_day < 10 ? ("0" + _day) : _day) + "/" + (_month < 10 ? ("0" + _month) : _month) + "/" + _year; // Using the ternary operator to verify whether the value of a number is two-digit or not, and adding 0 accordingly.
	}

    /**
	 * Calculate the date of tomorrow
	 * @return the date of tomorrow
	 */
	public Date tomorrow() {
		// declaration of variables for the new date object that are initialized with the ('this') current object's fields.
		int newDay = this._day;
		int newMonth = this._month;
		int newYear = this._year;
		if(newDay == getDaysWithinMonth(newMonth, newYear)) { // Comparison between 'newDay' day and the maximum day of the 'newMonth' month using getDaysWithinMonth method.
			if(newMonth == DEC) { // Checks whether the 'newMonth' month is december, if so, a new year has begun.
				newYear++;
				newMonth = FIRST_MONTH;
			} else newMonth++; // Otherwise, increase the month by 1.
			newDay = FIRST_DAY; // In any case, since it is a new month, set the day to 1.
		} else newDay++; // Otherwise, since it is not the maximum day of that month, increase the day by 1.
		return new Date(newDay, newMonth, newYear); 
	}

    /**
	 * Checks whether a date is valid
	 * @param day the day in the month
	 * @param month the month in the year
	 * @param year the year
	 * @return boolean value whether the date is valid, true if it is, otherwise, false
	 */
	private boolean isValidDate(int day, int month, int year) {
		if (day < MIN_VALID_DY || day > MAX_VALID_DY || month < MIN_VALID_MO || month > MAX_VALID_MO
				|| year < MIN_VALID_YR || year > MAX_VALID_YR) // Checks whether the date is correct according to the validation values of day, month and year.
			return false;
		return (day <= getDaysWithinMonth(month, year)) ? true : false; // Checks whether the day is less than or equal to the maximum day of that month, if so, the date is correct and true will be returned, otherwise, false will be returned.
	}

    /**
	 * Checks whether a year is a leap year
	 * @param year the year to check is a leap year
	 * @return boolean value whether the year is a leap year, true if it is, otherwise, false
	 */
	private boolean isLeapYear(int year) {
		return  (year % 4 == 0 && year % 100 != 0) || year % 400 == 0; //  a year is a leap year if the year is a multiple of 400, or multiple of 4 and not multiple of 100.
	}

    /**
	 * Calculates the maximum number of days in each month, according to the year.
	 * @param month the month in the year
	 * @param year the year
	 * @return The maximum number of days of the requested month depending on the year
	 */
	private int getDaysWithinMonth(int month, int year) {
		if(month == FEB) // Checks whether the month is February 
			return isLeapYear(year) ? 29 : 28; // If the year is a leap year, return 29, otherwise 28 according to the changes in February in a leap year.
		return (month < AUG && month % 2 == 0 || (month > JUL && month % 2 == 1)) ? 30 : 31; // If the month precedes August and is an even number OR the month is greater than July and odd, return 30, otherwise return 31 according to the lunar-solar calendar
	}

    /**
	 * Computes the day number since the beginning of the Christian counting of years
	 * (taken from the course booklet, it is documented that there is no need to use constants)
	 * @param day the day in the month
	 * @param month the month in the year
	 * @param year the year
	 * @return the number of days that have passed since the beginning of the Christian count.
	 */
	private int calculateDate(int day, int month, int year) {
		if (month < 3) {
			year--;
			month = month + 12;
		}
		return 365 * year + year / 4 - year / 100 + year / 400 + ((month + 1) * 306) / 10 + (day - 62);
	}
}
