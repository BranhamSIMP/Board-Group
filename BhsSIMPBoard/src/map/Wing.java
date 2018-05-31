package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Wing extends MapElement {
	private ArrayList<MapElement> rooms;
	private String description;
	private JFrame frame;
	
	public Wing(SimpGraphics parent, Rectangle rect, String description) {
		super(parent, rect);
		this.description = description;
	}
	
	public Wing(SimpGraphics parent, ArrayList<Rectangle> rectList, String description) {
		super(parent, rectList);
		this.description = description;
	}
	
	public void addRooms(ArrayList<Classroom> rooms) {
		this.rooms = new ArrayList<MapElement>();
		for (Classroom room : scaleRooms(rooms)) {
			this.rooms.add(room);
		}
	}
	
	public String toString() {
		String result = description + "\n\nRooms:\n";
		for (MapElement r : rooms) {
			result += r.toString() + "\n";
		}
		return result;
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		
		frame = new JFrame(description);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		ImagePanel IP = new ImagePanel(MAP_FILENAME, this, getZoomArea());
		frame.add(IP);
		frame.setVisible(true);
		MouseListener listener = new MapListener(rooms);
		
		IP.addMouseListener(listener);
		
		getParent().destroy();
	}
	
	
	private ArrayList<Classroom> scaleRooms(ArrayList<Classroom> classrooms) {
		Rectangle zoomArea = getZoomArea();
		ArrayList<Classroom> newRooms = new ArrayList<Classroom>(classrooms);

		for (MapElement room : newRooms) {
			for (Rectangle box : room.getBounds()) {
				box.setLocation((int) (box.x * ImagePanel.SCALE) - zoomArea.x, (int) (box.y * ImagePanel.SCALE) - zoomArea.y);
				box.setSize((int) (box.width * ImagePanel.SCALE), (int) (box.height * ImagePanel.SCALE));
			}
			
			
		}
		return newRooms;
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		frame.dispose();
		//getParent().create();
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void inactiveTimer(int seconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rescale(double scale) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void click() {
		// TODO Auto-generated method stub
		create();
	}
	
	
	
}
