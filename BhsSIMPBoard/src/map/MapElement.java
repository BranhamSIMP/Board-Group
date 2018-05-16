package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class MapElement {
	private Rectangle hitbox;
	
	public MapElement(Point corner, int width, int height) {
		hitbox = new Rectangle(corner.x, corner.y, width, height);
	}
}
