package map;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

class ImagePanel extends JPanel {

	private BufferedImage image;
	private static final int BUTTON_SIZE = 50;
	public static final double SCALE = 2.5;

	public ImagePanel(String fileName, SimpGraphics parent) {

		try {
			image = ImageIO.read(new File(fileName));
			setLayout(null);
			JButton exit = new JButton("X");
			exit.setBounds(image.getWidth() - BUTTON_SIZE, 0, BUTTON_SIZE, BUTTON_SIZE);
			exit.addActionListener(new ButtonListener(parent));
			add(exit);

		} catch (IOException ex) {
			// handle exception...
		}
	}

	public ImagePanel(String fileName, SimpGraphics parent, Rectangle r) {
		
		try {
			//zoomed = true;
			BufferedImage parentImage = ImageIO.read(new File(fileName));
			//image = parentImage.getSubimage(r.x, r.y, r.width, r.height);
			//parentImage = parentImage.getSubimage(r.x, r.y, parentImage.getWidth(), parentImage.getHeight());
			
			Image basicImage = parentImage.getScaledInstance( (int) (parentImage.getWidth() * SCALE), (int) (parentImage.getHeight() * SCALE), Image.SCALE_SMOOTH);
			image = new BufferedImage(basicImage.getWidth(null), basicImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			image.getGraphics().drawImage(basicImage, 0, 0 , null);
			image.getGraphics().dispose();
			image = image.getSubimage(r.x, r.y, r.width, r.height);
			
			setLayout(null);
			JButton exit = new JButton("X");
			exit.setBounds(parentImage.getWidth() - BUTTON_SIZE, 0, BUTTON_SIZE, BUTTON_SIZE);
			exit.addActionListener(new ButtonListener(parent));
			add(exit);

		} catch (IOException ex) {
			// handle exception...
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters

		
	}

}
