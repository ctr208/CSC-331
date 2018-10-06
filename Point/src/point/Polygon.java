package point;

import java.util.ArrayList;

public class Polygon {
	private ArrayList<Point> myPoints = new ArrayList<>();
	
	public Polygon(ArrayList<Point> p) {
		myPoints = p;
	}
	
	public int getNumSides() {
		return myPoints.size();
	}
	
	public double getPerimeter() {
		double perimeter = 0;
		for(int i=0; i < myPoints.size() -1; i++) {
			Point cp = myPoints.get(i);
			perimeter += cp.calcDistance(myPoints.get(i+1));
		}
		Point lastPoint = myPoints.get(myPoints.size()-1);
		Point firstPoint = myPoints.get(0);
		
		perimeter += lastPoint.calcDistance(firstPoint);
		return perimeter;
	}

}
