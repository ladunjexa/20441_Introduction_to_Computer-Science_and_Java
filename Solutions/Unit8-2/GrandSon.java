package Unit82;

public class GrandSon extends Son {

    private int _z;
	
	public GrandSon() {
		this(0, 0, 0);
	}
	
	public GrandSon(int x, int y, int z) {
		super(x, y);
		_z = z;
	}
    
    public boolean equals(Object obj) { /** equals 6 **/
    System.out.println("6");
		if (obj == null || !(obj instanceof GrandSon))
			return false;
		
		return super.equals(obj) && _z == ((GrandSon)obj)._z;
	}
	
	
	public boolean equals(Father obj) { /** equals 7 **/
	System.out.println("7");
		return super.equals(obj);
	}
	
	public boolean equals(GrandSon obj) { /** equals 8 **/
	System.out.println("8");
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("GrandSon is smiling");
    }
    
    public void run() {
        System.out.println("GrandSon is running");
    }
    
    public void play() {
        System.out.println("GrandSon is playing");
    }
}
