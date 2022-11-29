package Unit82;

public class Son extends Father {

    public Son() {
		this(0, 0);
	}
	
	public Son(int x, int y) {
		super(x, y);
	}
    
    public boolean equals(Object obj) { /** equals 3 **/
    System.out.println("3");
		if (obj == null || !(obj instanceof Son))
			return false;

		return super.equals(obj);
	}
	
	public boolean equals(Son obj) { /** equals 4 **/
	System.out.println("4");
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("Son is smiling");
    }
    
    public void run() {
        System.out.println("Son is running");
    }
}
