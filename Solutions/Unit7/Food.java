package Unit7;

public class Food {

	private int _cal;
	private String _lastDate;
	
	private final static  int DEFAULT_CALORIES = 100;
	private final static String DEFAULT_LAST_DATE = "1/1/1900";
	
	public Food() {
		this(DEFAULT_CALORIES, DEFAULT_LAST_DATE);
	}
	
	public Food(int cal, String lastDate) {
		_cal = cal;
		_lastDate = lastDate;
	}
	
	public int getCal() {
		return _cal;
	}
	
	public String getLastDate() {
		return _lastDate;
	}
	
	public void setCal(int cal) {
		_cal = cal;
	}
	
	public void setLastDate(String lastDate) {
		_lastDate = lastDate;
	}
	
	public void eat() {
		System.out.println("i'm eating food");
	}
	
	public String toString() {
		return "Cal: " + _cal + ", Last Date: " + _lastDate;
	}
}
