package minimap.Scouting;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class ScoutInfoPanel {
	//Create Scout Sheet
	//Delete Scout Sheet
	//Edit Scout Sheet
	
	public static void main (String args[]){
		JFrame f = new JFrame();
		JPanel p = new JPanel();
		int num = 2849;
		String name = "Ursa Major";
		String[] names = {"Cyber Squirrels", "A", "B", "C", "D", "E"};

		boolean[] actions = {
				false, true, false, false, true, true, false, false, false
		};
		ScoutInfo s = new ScoutInfo(num, name, 0, 0, actions);
		ScoutInfo s1 = new ScoutInfo(num, names[0], 0, 0, actions);
		//100, 275
		
		p.add(s);
		p.add(s1);
		f.add(p);
		
		f.setSize(300, 450);
		f.setVisible(true);
		
	}
}
