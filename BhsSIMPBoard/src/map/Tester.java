package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Tester {

public static void main(String[] args) {
	JFrame frame = new JFrame("Tester");
	
	
	frame.setSize(1165,950);
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	
	
	
	ImagePanel IP = new ImagePanel();
	frame.add(IP);
	
	//RectangleComponent1 FC = new RectangleComponent1();
	//frame.add(FC);
	
	frame.setVisible(true);
	
	MouseListener listener = new Clickers();
	
	IP.addMouseListener(listener);

}
}

class Clickers implements MouseListener
{

RectangleComponent1 FC = new RectangleComponent1();

@Override
public void mouseClicked(MouseEvent e) {

	if((new Rectangle(100,100,100,90)).contains(e.getX(),e.getY()))
	{
		System.out.println("HELLO");
	}		
}
public void mouseEntered(MouseEvent arg0) {
	
}
@Override
public void mouseExited(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent arg0) {
	// TODO Auto-generated method stub
	
}
}

class RectangleComponent1 extends JComponent
{
int WIDTH = 100;
int HEIGHT = 90;
public void paintComponent(Graphics g)
{
Graphics2D g2 = (Graphics2D) g;
g2.setColor(Color.RED);
g2.fillRect(100,100,WIDTH,HEIGHT);

}
}

class ImagePanel extends JComponent{

private BufferedImage image;

public ImagePanel() {
   try {                
      image = ImageIO.read(new File("BetterMapOfBranham3.png"));
   } catch (IOException ex) {
        // handle exception...
   }
}

@Override
protected void paintComponent(Graphics g) {
    g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
}
}
