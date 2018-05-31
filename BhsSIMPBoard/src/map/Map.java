package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Map implements SimpGraphics {
	
	private static final String MAP_FILENAME = "BetterMapOfBranham3.png";
	private static final int FRAME_HEIGHT = 920;  
	private static final int FRAME_WIDTH = 1165;  //729, 469
	private ArrayList<MapElement> elements;
	private JFrame frame;

	
	public Map() {		
		elements = new ArrayList<MapElement>();
		
		try {
			loadFromJson("locations.json");
		}
		catch (FileNotFoundException e) {
			System.err.println("Locations file not found");
		}
	}
	
	private void loadFromJson(String fileName) throws FileNotFoundException {
		File f = new File(fileName);
		Scanner s = new Scanner(f);
		s.useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		s.close();
		
		JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
		
		for (JsonElement wing : jsonObject.get("wings").getAsJsonArray()) {
			elements.add(parseWing(wing.getAsJsonObject()));
		}
		
		for (JsonElement room : jsonObject.get("rooms").getAsJsonArray()) {
			elements.add(parseClassroom(this, room.getAsJsonObject()));
		}
	}
	
	private Point arrayToPoint(JsonArray arr) {
		return new Point((int) (FRAME_WIDTH * arr.get(0).getAsDouble()), (int) (FRAME_HEIGHT * arr.get(1).getAsDouble()));
	}
	
	private Classroom parseClassroom(SimpGraphics parent, JsonObject c) {
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		
		for (JsonElement rect : c.get("buttons").getAsJsonArray()) {
			JsonObject r = rect.getAsJsonObject();
			Point upperLeft = arrayToPoint(r.get("upperLeft").getAsJsonArray());
			Point lowerRight = arrayToPoint(r.get("lowerRight").getAsJsonArray());

			rects.add(new Rectangle(upperLeft.x, upperLeft.y, lowerRight.x - upperLeft.x, lowerRight.y - upperLeft.y));
		}
		
		return new Classroom(parent, rects, c.get("description").getAsString());
	}
	
	private Wing parseWing(JsonObject w) {
		
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		ArrayList<Classroom> rooms = new ArrayList<Classroom>();
		
		for (JsonElement rect : w.get("buttons").getAsJsonArray()) {
			JsonObject r = rect.getAsJsonObject();
			Point upperLeft = arrayToPoint(r.get("upperLeft").getAsJsonArray());
			Point lowerRight = arrayToPoint(r.get("lowerRight").getAsJsonArray());

			rects.add(new Rectangle(upperLeft.x, upperLeft.y, lowerRight.x - upperLeft.x, lowerRight.y - upperLeft.y));
		}
		
		Wing result = new Wing(this, rects, w.get("description").getAsString());
		
		for (JsonElement room : w.get("rooms").getAsJsonArray()) {
			rooms.add(parseClassroom(result, room.getAsJsonObject()));
		}
		
		result.addRooms(rooms);

		return result;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		//System.out.println("main create");
	    frame = new JFrame("Map");
		
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		ImagePanel IP = new ImagePanel(MAP_FILENAME, this);
		frame.add(IP);
		
		frame.setVisible(true);
		
		MouseListener listener = new MapListener(elements);
		
		IP.addMouseListener(listener);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		//frame.setVisible(false);
		frame.dispose();
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
	public void exit() {
		// TODO Auto-generated method stub
		destroy();
	}
}
