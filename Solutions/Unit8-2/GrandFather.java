package Unit82;

public class GrandFather {

	protected int _x;

	public GrandFather() {
		this(0);
	}

	public GrandFather(int x) {
		_x = x;
	}

	public boolean equals(Object obj) { /** equals 1 **/
		System.out.println("1");
		if (obj == null || !(obj instanceof GrandFather))
			return false;

		return _x == ((GrandFather) obj)._x;
	}

	public void smile() {
		System.out.println("GrandFather is smiling");
	}

	public void eat() {
		System.out.println("I'm eating");
	}
}
