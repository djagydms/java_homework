package edu.pnu.shape;

import java.util.Objects;

public class Rectangle {

	private int width, height ;
	
	public Rectangle(int width2, int height2) {
		width = width2;
		height = height2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return height == other.height && width == other.width;
	}

	@Override
	public String toString() {
		return String.format("[ Rectangle %d %d %.6f ]", width,height,width*height*1.0);
	}

}

