package homework12;

import java.util.Objects;

public class Rectangle {
	private final int width, height;
	private final String name;
	private static int id = 0;
	
	public Rectangle(int width, int height) {
		this.width = width; this.height = height;
		
		name = String.format("rect[%2d]", id);
		id++;
	}
	public int getArea() { return width * height; }
	public String getName() { return name; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	@Override
	public String toString() {
		return String.format("%s: %5d, %5d", name, width, height);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
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
		return Objects.equals(name, other.name);
	}
}