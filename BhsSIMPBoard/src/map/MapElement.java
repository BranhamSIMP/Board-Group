package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class MapElement {
	private ArrayList<Rectangle> boxes;
	
	public MapElement(Point corner, int width, int height) {
		boxes = new ArrayList<Rectangle>();
		boxes.add(new Rectangle(corner.x, corner.y, width, height));
	}
	
	public MapElement(Rectangle rect) {
		boxes = new ArrayList<Rectangle>();
		boxes.add(rect);
	}
	
	public MapElement(ArrayList<Rectangle> rectList) {
		boxes = new ArrayList<Rectangle>(rectList);
	}
	
	public boolean contains(Point p) {
		for (Rectangle box: boxes) {
			if (box.contains(p)) {
				return true;
			}
		}
		return false;
	}
	
	protected ArrayList<Rectangle> getBounds() {
		return boxes;
	}
}
