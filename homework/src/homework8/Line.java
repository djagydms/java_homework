package homework8;

import java.util.Objects;

public class Line implements MyComparable {
	private final Point point1, point2 ;
	
	public Line(int x1, int y1, int x2, int y2){
		point1 = new Point(x1,y1);
		point2 = new Point(x2,y2);
	}
	public int compareTo(final MyComparable other) {
		int returnValue = 0;
		if(this.getSize() < other.getSize()) returnValue = -1;
		if(this.getSize() == other.getSize()) returnValue = 0;
		if(this.getSize() > other.getSize()) returnValue = 1;
		
		return returnValue;
	} 
	public long getSize() {
		
		return (long)(Math.sqrt(
				Math.pow(point2.getX()-point1.getX(), 2) + 
				Math.pow(point2.getY()-point1.getY(), 2)
				));
	}
	@Override
	public String toString() {
		return "[" + point1 + point2 + this.getSize()+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(point1, point2);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Line other = (Line) obj;
		return Objects.equals(point1, other.point1) && Objects.equals(point2, other.point2);
	} ;
}
