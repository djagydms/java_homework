package homework9;

public class Rectangle {
	int width;
	int height;
	
	public Rectangle(final int x, final int y) {
		width = x;
		height = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "Rectangle: width " + width + ", height " + height;
	}
}
