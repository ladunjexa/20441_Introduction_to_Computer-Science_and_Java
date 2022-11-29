package Maman12;
/**
 * class Car is used for represent a Car object.
 * 
 * @author Liron Abutbul
 * @version 03/11/2022
 */

public class Car {
	// DECLARATIONS
	// fields
    private int _id;
    private char _type;
    private String _brand;
    private boolean _isManual;
    
    // default values
    private final int DEFAULT_ID_VAL = 9999999;
    private final char DEFAULT_TYPE_VAL = 'A';
    
    // CONSTRUCTORS
    /**
     * creates a new Car object
     * id should be a 7 digits number, otherwise set it to 9999999
     * type should be 'A','B','C' or 'D', otherwise set it to 'A'
     * @param id the id of the car (7 digits number)
     * @param type the type of the car ('A','B','C' or 'D')
     * @param brand the car's brand
     * @param isManual flag indicating if the car is manual
     */
    public Car(int id, char type, String brand, boolean isManual) {
        _id = (isValidCarId(id)) ? id : DEFAULT_ID_VAL; // If 'id' is correct, set value received as parameter, otherwise, default value.
        _type = (isValidCarType(type))? type : DEFAULT_TYPE_VAL; // If 'type' is correct, set value received as parameter, otherwise, default value.
        _brand = brand;
        _isManual = isManual;
    }
    
    /**
     * Copy constructor
     * @param other the car to be copied
     */
    public Car(Car other) {
        _id = other._id;
        _type = other._type;
        _brand = other._brand;
        _isManual = other._isManual;
    }
    
    // METHOD FUNCTIONS
    /**
     * Gets the id
     * @return the id
     */
    public int getId() {
        return _id;
    }
    
    /**
     * Gets the type
     * @return the type
     */
    public char getType() {
        return _type;
    }
    
    /**
     * Gets the brand
     * @return the brand
     */
    public String getBrand() {
        return _brand;
    }
    
    /**
     * Gets the isManual flag
     * @return the isManual flag
     */
    public boolean isManual() {
        return _isManual;
    }
    
    /**
     * Sets the id (only if the given id is valid)
     * @param id the id value to be set
     */
    public void setId(int id) {
    	if(isValidCarId(id)) // Checks whether the 'id' that received as a parameter is valid, if it is, change the id.
            _id = id;
    }
    
    /**
     * Sets the type (only if the given type is valid)
     * @param type the type value to be set
     */
    public void setType(char type) {
        if(isValidCarType(type))  // Checks whether the 'type' that received as a parameter is valid, if it is, change the type.
            _type = type;
    }
    
    /**
     * Sets the brand of the car
     * @param brand the brand value to be set
     */
    public void setBrand(String brand) {
        _brand = brand;
    }
    
    /**
     * Sets the isManual flag of the car
     * @param manual the isManual flag to be set
     */
    public void setIsManual(boolean manual) {
        _isManual = manual;
    }
    
    /**
     * Returns a String object that represents this car
     * @return String that represents this car in the following format: id:1234567 type:B brand:Toyota gear:manual (or auto)
     */
    public String toString() {
        return "id:" + _id + " type:" + _type + " brand:" + _brand + " gear:" + (_isManual ? "manual" : "auto"); // string representation of an object, using ternary operator to determine if the gear is auto or manual  
    }
    
    /**
     * Check if two cars are the same
     * Cars are considered the same if they have the same type, brand and gear
     * @param other the car to compare this car to
     * @return true if the cars are the same, otherwise false
     */
    public boolean equals(Car other) {
        return (_type == other._type && _brand == other._brand && _isManual == other._isManual); // Comparing the type, brand and gear gear of the current object ('this') to the 'other' object received as a parameter
    }
    
    /**
     * Check if this car is better than the other car
     * A car is considered better than another car if its type is higher.
     * If both cars have the same type, an automated car is better than a manual car.
     * @param other the car to compare this car to
     * @return true if this car is better than the other car, otherwise false
     */
    public boolean better(Car other) {
        if(_type > other._type) // Check whether 'this' object type is higher than 'other' type.
            return true;
        else if(_type < other._type) // Check whether 'this' object type is lower than 'other' type.
            return false;
        return !_isManual && other._isManual; // Checks whether the 'this' object gear is auto and (logical AND operator '&&') the 'other' object gear is manual, return true if both operands are true, otherwise, return false.
    }
    
    /**
     * Check if this car is worse than the other car
	 * The logic of the method is that if the 'other' car is better than 'this' car, 
	 * then 'this' car must be worse than 'other' car
     * @param other the car to compare this car to
     * @return true if this car is worse than the other car, otherwise false
     */
    public boolean worse(Car other) {
        return other.better(this); // A call to the 'better' method when the method is invoked on 'other', where 'this' is sent as a parameter.		
    }
    
    /**
     * Checks if the car id is correct, i.e, 7 digits number
     * @param id the id to check
     * @return true if the id is correct, otherwise false
     */
    private boolean isValidCarId(int id) {
    	return String.valueOf(id).length() == String.valueOf(DEFAULT_ID_VAL).length(); // Checks whether the length of the ID as a string is valid according to the length of the default ID.
    }

    /**
     * Checks if the car type is correct, i.e, A, B, C, D
     * @param type the type to check
     * @return true if the type is correct, otherwise false
     */
    private boolean isValidCarType(char type) {
    	return type >= 'A' && type <= 'D'; // Checks whether the type is correct by complying with the range between A and D according to the ASCII code.
    }
}
