package Unit7;

public class Pizza extends Food {

	private int _numOfTops;
	private int _numOfSlices;
	
	private final int DEFAULT_TOPS = 1;
	private final int DEFAULT_SLICES = 8;
	
	public Pizza() {
		super();
		_numOfTops = DEFAULT_TOPS;
		_numOfSlices = DEFAULT_SLICES;
		
	}
	
	public Pizza(int numOfTops, int numOfSlices, int cal, String lastDate) {
		super(cal, lastDate);
		_numOfTops = numOfTops;
		_numOfSlices = numOfSlices;
	}
	
	public int getNumOfTops() {
		return _numOfTops;
	}
	
	public int getNumOfSlices() {
		return _numOfSlices;
	}
	
	public void setNumOfTops(int numOfTops) {
		_numOfTops = numOfTops;
	}
	
	public void setNumOfSlices(int numOfSlices) {
		_numOfSlices = numOfSlices;
	}
	
	public void eat() {
		System.out.println("i'm eating pizza!!!");
	}
	
	public String toString() {
		return "Tops: " + _numOfTops + ", Slices: " + _numOfSlices + ", " + super.toString();
	}
}
