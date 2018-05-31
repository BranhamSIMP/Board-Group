package map;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MapListener implements MouseListener {
	private ArrayList<MapElement> elements;
	
	public MapListener(ArrayList<MapElement> elements) {
		this.elements = elements;
	}
	
	public MapListener() {
		this.elements = new ArrayList<MapElement>();
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		for (MapElement m : elements) {
			
			if (m.contains(e.getPoint())) {
				m.click();
				break;
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
