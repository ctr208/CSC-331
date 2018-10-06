package point;

public class Line {
	private Point start;
	private Point end;

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public double length() {
		return start.calcDistance(end);
	}

}
