package Unit82;

public class Father extends GrandFather {

    private int _y;
	
	public Father() {
		this(0, 0);
	}
	
	public Father(int x, int y) {
		super(x);
		_y = y;
	}
    
    public boolean equals(Father obj) { /** equals 2 **/
    System.out.println("2");
		return super.equals(obj) && _y == obj._y;
	}
    
    public void smile() {
        System.out.println("Father is smiling");
    }
    
    public void run() {
        System.out.println("Father is running");
    }
}
