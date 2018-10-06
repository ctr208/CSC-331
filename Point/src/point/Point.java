package point;

public class Point {

	// Properties
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// Behaviors
	public double calcDistance(Point other) {
		int xDiff = x - other.x;
		int yDiff = y - other.y;
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}
