package Unit82;

public class Daughter extends Father {

    public Daughter() {
		this(0, 0);
	}
	
    public Daughter(int x, int y) {
		super(x, y);
	}
    
    public boolean equals(Object obj) { /** equals 5 **/
    System.out.println("5");
		if (obj == null || !(obj instanceof Daughter))
			return false;
		
		return super.equals(obj);
	}
    
    public void smile() {
        System.out.println("Daughter is smiling");
    }
    
    public void run() {
        System.out.println("Daughter is running");
    }
    
    public void wonderWoman() {
        System.out.println("I'm Wonder Woman");
    }
}
