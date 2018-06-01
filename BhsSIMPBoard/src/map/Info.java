package map;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Info extends JPanel{
	private BufferedImage img;
	private BufferedImage ci;
	
	public Info() {
		try {
			img = ImageIO.read(new File("FV.jpg"));
			ci = img.getSubimage(10, 10, 230, 250);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void paint(Graphics g){
	
			g.drawImage(ci, 260, 10, null);
			g.drawRect(10, 10, 250, 250);
			g.drawRect( 260 , 10, 230, 250);
			/*
			g.drawString("Room 44" , 20 , 55);
			g.drawString("Fitzgerald, Vo", 20, 75);
			g.drawString("Science, Journalism" , 20, 95);
			g.drawString("Hours 2:30 - 3:30 on Fridays, Appointments", 20, 135);
			g.drawString("from Monday to Thursday", 20, 155);
			g.drawString("Clubs: DECA", 20, 195);*/
	
		    
		}
	
	
	public static void main(String[] args){
		JFrame frame= new JFrame("Info");	
		frame.getContentPane().add(new Info());
		frame.setSize(500, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);	
	
	}
}