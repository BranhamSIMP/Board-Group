package map;

import java.awt.Rectangle;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Classroom extends MapElement {
	private String description;
	private JFrame frame;
	
	public Classroom(SimpGraphics parent, Rectangle box, String description) {
		super(parent, box);
		this.description = description;
		// TODO Auto-generated constructor stub
	}
	
	public Classroom(SimpGraphics parent, ArrayList<Rectangle> boxes, String description) {
		super(parent, boxes);
		this.description = description;
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return description;
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
	public void create() {
		// TODO Auto-generated method stub
		getParent().destroy();
		frame = new JFrame(description);
		
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		
		ImagePanel IP = new ImagePanel(MAP_FILENAME, this);
		frame.add(IP);
		frame.setVisible(true);
		
		MouseListener listener = new MapListener();
		
		IP.addMouseListener(listener);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		frame.dispose();
		//getParent().create();
	}

	

	@Override
	protected void click() {
		// TODO Auto-generated method stub
		System.out.println(description);
	}

	@Override
	public void rescale(double scale) {
		// TODO Auto-generated method stub
		
	}
}
