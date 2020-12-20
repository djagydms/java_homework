package edu.pnu.shape;

import java.util.Objects;

public class Point {
	private int x, y ;

	
	public Point(int x2, int y2) {
		x = x2;
		y = y2;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "[ " + x + ", " + y + "]";
	}
}

