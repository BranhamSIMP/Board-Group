package map;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Map implements SimpGraphics {
	
	private static final String MAP_FILENAME = "BetterMapOfBranham3.png";
	private static final int FRAME_HEIGHT = 920;   //112
	private static final int FRAME_WIDTH = 1165;  //174
	private ArrayList<Wing> wings;
	private JFrame frame;

	
	public Map() throws FileNotFoundException {
		Classroom test = new Classroom(new Rectangle((int) (FRAME_WIDTH * 0.149356), (int) (FRAME_HEIGHT * 0.121739), 120, 85), "test room: main office");
		
		File f = new File("locations.json");
		Scanner s = new Scanner(f).useDelimiter("\\A");
		String result = s.hasNext() ? s.next() : "";
		s.close();
		
		JsonObject jsonObject = new JsonParser().parse(result).getAsJsonObject();
		System.out.println(jsonObject.get("wings").getAsJsonArray().get(0).getAsJsonObject().get("description").getAsString());
		ArrayList<Classroom> rooms = new ArrayList<Classroom>();
		rooms.add(test);
		Wing w = new Wing(test.getBounds().get(0), rooms, "main office wing");
		wings = new ArrayList<Wing>();
		wings.add(w);
	}
	
	private class MapListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			for (Wing w : wings) {
				if (w.contains(e.getPoint())) {
					System.out.println(w.toString());
				}
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Tester");
		
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		ImagePanel IP = new ImagePanel(MAP_FILENAME);
		frame.add(IP);
		
		frame.setVisible(true);
		
		MouseListener listener = new MapListener();
		
		IP.addMouseListener(listener);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		frame.dispose();
	}

	@Override
	public void enlarge() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shrink() {
		// TODO Auto-generated method stub
		
	}
}
