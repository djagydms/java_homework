package homework8;

import java.util.Objects;

public class Circle implements MyComparable {
	private final Point center ;
	private final int radius ;
	
	public Circle(int x, int y, int radius) {
		center = new Point(x,y);
		this.radius = radius;
	}
	
	public int compareTo(final MyComparable other) {
		
		int returnValue = 0;
		if(this.getSize() < other.getSize()) returnValue = -1;
		if(this.getSize() == other.getSize()) returnValue = 0;
		if(this.getSize() > other.getSize()) returnValue = 1;
		
		return returnValue;
	} 
	public long getSize() {
		
		return (long) (3.14*radius*radius);
	}
	
	@Override
	public String toString() {
		return "[" + center  + radius + " " + this.getSize()+ "]";
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
	} ;
}
