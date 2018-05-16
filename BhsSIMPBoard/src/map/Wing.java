package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Wing {
	private ArrayList<Classroom> rooms;
	private Rectangle hitbox;
	
	public Wing(Point corner, int width, int height, ArrayList<Classroom> rooms) {
		this.rooms = rooms;
		hitbox = new Rectangle(corner.x, corner.y, width, height);
	}
}
