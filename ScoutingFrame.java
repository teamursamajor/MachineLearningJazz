package minimap.Scouting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;


public class ScoutingFrame extends JFrame implements ScoutPlan {
	//private JButton newBtn,editBtn,saveBtn,deleteBtn;
	private JTextField number,name;
	private ArrayList<JCheckBox> stats;
	
	public ScoutingFrame(){
		JPanel panel = new JPanel();
		
		JLabel l1 = new JLabel("Team Number: ");
		JLabel l2 = new JLabel("Team Name: ");
		number = new JTextField("");
		name = new JTextField("");
		panel.add(l1);
		panel.add(number);
		panel.add(l2);
		panel.add(name);
		
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		stats = new ArrayList<JCheckBox>();
		
		
		for(int i = 0; i < ScoutPlan.actions.length; i++){
			JCheckBox c = new JCheckBox(ScoutPlan.actions[i]);
			panel.add(c);
			stats.add(c);
		}

		JButton	save = new JButton("Save");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("E");
				String path = "C:/Users/chris/workspace/Gui/src/minimap/Scouting/ScoutSheets/";
				path += number.getText() + ".txt";
				try {
					//File f =  new File (path);
                    writeToFile(path);
                }
                catch (Exception err){
                    System.out.println("ERROR");
                }
			}
		});
		
		panel.add(save);
		this.add(panel);

		this.setSize(200, 350);
	}
	
	
	
	 private void writeToFile (String fileName) throws IOException{
	        clearFile(fileName);
	        File f = new File(fileName);
	        FileWriter fileWriter = new FileWriter(f, true);
	        BufferedWriter writer = new BufferedWriter(fileWriter);

	        String str = "\n";
	        for (JCheckBox c : stats){
//	        	boolean b = c.isSelected();
//	        	System.out.println(b);
	        	str += c.isSelected() + "\n";
	            //fileWriter.write(str + "\n");
	        }
	        fileWriter.write(str);
	        writer.flush();
	        writer.close();
	        
	 }

	 public void clearFile(String fileName) throws IOException{
	        FileWriter writer = new FileWriter(new File(fileName));
	        writer.write(name.getText());
	        writer.flush();
	        writer.close();
	    }
}
