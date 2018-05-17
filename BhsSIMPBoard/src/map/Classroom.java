package map;
<<<<<<< HEAD

public class Classroom {
=======

import java.awt.Rectangle;

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
>>>>>>> 82d181a453ed8647cfd258bb87d6ea08aab7c8ff

}
