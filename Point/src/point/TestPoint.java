package point;

import java.util.ArrayList;

public class TestPoint {

	public static void main(String[] args) {
		Point p1 = new Point(0, 0);
		Point p2 = new Point(3, 4);
		Point p3 = new Point(6, 2);
		
		ArrayList<Point> points = new ArrayList<>();
		points.add(p1);
		points.add(p2);
		points.add(p3);
		Polygon p = new Polygon(points);
		
		double d = p1.calcDistance(p2);
		System.out.println(d);

		Line l1 = new Line(p1, p2);
		System.out.println("Length of l1 = " + l1.length());
	}

}
