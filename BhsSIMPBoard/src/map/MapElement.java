package map;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class MapElement implements SimpGraphics {
	private ArrayList<Rectangle> boxes;
	private SimpGraphics parentGraphics;
	private MapElement parentElement;
	protected static final String MAP_FILENAME = "BetterMapOfBranham3.png";
	protected static final int FRAME_HEIGHT = 920;  
	protected static final int FRAME_WIDTH = 1165;  //729, 469
	
	public MapElement(SimpGraphics parent, Point corner, int width, int height) {
		this.parentGraphics = parent;
		boxes = new ArrayList<Rectangle>();
		boxes.add(new Rectangle(corner.x, corner.y, width, height));
	}
	
	public MapElement(SimpGraphics parent, Rectangle rect) {
		this.parentGraphics = parent;
		boxes = new ArrayList<Rectangle>();
		boxes.add(rect);
	}
	
	public MapElement(SimpGraphics parent, ArrayList<Rectangle> rectList) {
		this.parentGraphics = parent;
		boxes = new ArrayList<Rectangle>(rectList);
	}
	
	public MapElement(Rectangle rect) {
		parentGraphics = null;
		boxes = new ArrayList<Rectangle>();
		boxes.add(rect);
	}
	
	public boolean contains(Point p) {
		for (Rectangle box: boxes) {
			if (box.contains(p)) {
				return true;
			}
		}
		return false;
	}
	
	protected ArrayList<Rectangle> getBounds() {
		return boxes;
	}
	
	protected Point getZoomDiff() {
		int xSum = 0;
		int ySum = 0;
		for (Rectangle box : boxes) {
			xSum += (int) box.getCenterX();
			ySum += (int) box.getCenterY();
		}
		Point center = new Point(xSum / boxes.size(), ySum / boxes.size());
		Point zoomedCenter = new Point((int) (center.x * ImagePanel.SCALE), (int) (center.y * ImagePanel.SCALE));
		return new Point(zoomedCenter.x - center.x, zoomedCenter.y - center.y);
	}
	
	protected Rectangle getZoomArea() {

		Point upperLeft = new Point(0, 0);
		int xSum = 0;
		int ySum = 0;
		for (Rectangle box : boxes) {
			xSum += (int) box.getCenterX();
			ySum += (int) box.getCenterY();
		}
		Point center = new Point(xSum / boxes.size(), ySum / boxes.size());
		Point zoomedCenter = new Point((int) (center.x * ImagePanel.SCALE), (int) (center.y * ImagePanel.SCALE));
		
		if (zoomedCenter.x - (FRAME_WIDTH / 2) < 0) {
			upperLeft.setLocation(0, upperLeft.y);
		}
		else if (zoomedCenter.x + (FRAME_WIDTH / 2) > FRAME_WIDTH * ImagePanel.SCALE) {
			upperLeft.setLocation((int) (FRAME_WIDTH * ImagePanel.SCALE) - FRAME_WIDTH, upperLeft.y);
		}
		else {
			upperLeft.setLocation(zoomedCenter.x - (FRAME_WIDTH / 2), upperLeft.y);
		}
		
		if (zoomedCenter.y - (FRAME_HEIGHT / 2) < 0) {
			upperLeft.setLocation(upperLeft.x, 0);
		}
		else if (zoomedCenter.y + ((FRAME_HEIGHT) / 2) > FRAME_HEIGHT * ImagePanel.SCALE) {
			upperLeft.setLocation(upperLeft.x, (int) ((FRAME_HEIGHT - 20) * ImagePanel.SCALE) - FRAME_HEIGHT);
		}
		else {
			upperLeft.setLocation(upperLeft.x, zoomedCenter.y - (FRAME_HEIGHT / 2));
		}
		
		
		return new Rectangle(upperLeft.x, upperLeft.y, FRAME_WIDTH, FRAME_HEIGHT);
	}
	protected SimpGraphics getParent() {
		return parentGraphics;
	}
	@Override
	public void exit() {
		getParent().create();
		destroy();
		
	}
	protected abstract void click();
}
