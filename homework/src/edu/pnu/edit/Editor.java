package edu.pnu.edit;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.shape.Circle;
import edu.pnu.shape.Rectangle;


public class Editor {
	private List<Object> shapes = new ArrayList<>();

	
	public void add(Rectangle newRectangle) {
		shapes.add(newRectangle);
		
	}

	public void add(Circle newCircle) {
		shapes.add(newCircle);
		
	}

	public void clear() {
		shapes.clear();
		
	}

	public void list() {
		System.out.println(shapes);
		
	};

}
