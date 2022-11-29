package Unit8;

public class Giraffe implements Comparable {

	private int _height;

	public Giraffe(int height) {
		_height = height;
	}

	public int compareTo(Object obj) {
		if (obj instanceof Giraffe) {
			int otherHeight = ((Giraffe) obj)._height;
			if (_height > otherHeight)
				return 1;
			else if (_height < otherHeight)
				return -1;
			return 0;
		} else {
			System.out.println("parameter must be a Girrafe object");
			return -999;
		}
	}

	public String toString() {
		return "height: " + _height;
	}
}
