package minimap.Scouting;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.*;

//todo - add assist climb
//Todo - add an optimize vew (only show what they can do)
public class ScoutInfo extends JPanel {
	//private int teamNumber;
	private String teamName;
	private int win,loss;
	//private boolean canClimb1, canClimb2, canClimb3, canCargo, canHatch, canDefend, canRocket2, canRocket3, canAuto;
	private boolean[] info;
	private ArrayList<JCheckBox> display;
	private boolean optimized = false;
	
	/**
	 * Scout info that is hopefully received from a scouting program, TODO - add a highlight option
	 * 
	 * @param teamNumber the team's team number
	 * @param teamName the team's name
	 * @param win amount of matches they have won
	 * @param loss amount of matches the have lost
	 * @param info what a robot can and can not do, \n
	 * {auto, climb1, climb2, climb3, cargo, hatch, rocket2, rocket3, defend}\n
	 * -auto: can they do the sand storm?\n
	 * -climb: can they climb platform 1/2/3\n
	 * -cargo: can they do cargo?\n
	 * -hatch: can they do hatch?\n
	 * -rocket: can they do either the hatch or cargo for rocket level 2/3?\n
	 * -defend: can they defend?
	 *  
	 */
	public ScoutInfo (int teamNumber, String teamName, int win, int loss, boolean[] info){
		this.teamName = teamNumber+":";
		this.win = win;
		this.loss = loss;
		this.info = info;
		//this.setSize(500,500);
		this.setSize(100, 275);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel team = new JLabel(this.teamName);
		this.add(team);
		
		display = new ArrayList<JCheckBox>();
		//TODO - turn into interface
		String[] actions = {
			"Auto", "Climb 1", "Climb 2", "Climb 3", "Cargo", "Hatch", "Rocket 2", "Rocket 3", "Defend"
		};
		
		for(int i = 0; i < actions.length; i++){
			makeCheckBox(actions[i], i);
		}
		

	//	this.repaint();
	}
	
	public void paint(Graphics g) {
		//super.paint(g);
		
		for(JCheckBox box : display){
			this.remove(box);
			if (box.isSelected() || !optimized){
				this.add(box);		

//				if (box.isSelected()){
//					box.setBackground(new Color (5, 210, 20));
//				} else {
//					box.setBackground(new Color (210, 20, 5));
//				}
			}
		}
		super.paint(g);
		
		//System.out.println("ew");
	}
	
	
	private void makeCheckBox(String action, int index){
		JCheckBox box = new JCheckBox(action);
		box.setSelected(info[index]);//underline
		
		
		//add action listener that highlights
		display.add(box);
		this.add(box);
	}
}
