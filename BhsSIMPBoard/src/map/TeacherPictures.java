package map;

import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 *This class displays an image
 */

public class TeacherPictures {
	
	private String name; 

    public static void main(String avg[]) throws IOException
    {
    	//TeacherPictures abc=new TeacherPictures();
    	
    }
    
    public TeacherPictures() {}

    public TeacherPictures(String pic) throws IOException
    {
        BufferedImage img=ImageIO.read(new File(pic));
        ImageIcon icon=new ImageIcon(img);
        JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(320, 360); //changes frame size
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
}
