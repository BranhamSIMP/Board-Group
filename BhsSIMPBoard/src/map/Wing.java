package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Wing extends MapElement{
	private ArrayList<Classroom> rooms;
	private String description;
	
	public Wing(Rectangle rect, ArrayList<Classroom> rooms, String description) {
		super(rect);
		this.rooms = rooms;
		this.description = description;
	}
	
	public Wing(ArrayList<Rectangle> rectList, ArrayList<Classroom> rooms, String description) {
		super(rectList);
		this.rooms = rooms;
		this.description = description;
	}
	
	public String toString() {
		String result = description + "\n\nRooms:\n";
		for (Classroom r : rooms) {
			result += r.toString() + "\n";
		}
		return result;
	}
	
	
	
}
