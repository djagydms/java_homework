package edu.pnu.shape;

import java.util.Objects;

public class Circle {
	private Point center ;
	private int radius ;
	
	public Circle(Point point, int radius2) {
		center = point;
		radius = radius2;
		}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(center, radius);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		return Objects.equals(center, other.center) && radius == other.radius;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ Circle " + center + " " + radius);
		sb.append(String.format(" %.6f]",radius*radius*3.14));
		
		return sb.toString();
	}
}
