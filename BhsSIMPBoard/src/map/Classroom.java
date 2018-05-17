package map;

import java.awt.Rectangle;
//hello
public class Classroom extends MapElement {
	private String description;
	
	public Classroom(Rectangle box, String description) {
		super(box);
		this.description = description;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return description;
	}
//test again
}
