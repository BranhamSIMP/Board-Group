package map;

import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Map implements SimpGraphics {
	private ArrayList<Wing> wings;
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Tester");
		
		
		frame.setSize(800,800);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		
		frame.setVisible(true);
		
		MouseListener listener = new MapListener();
		

	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
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
