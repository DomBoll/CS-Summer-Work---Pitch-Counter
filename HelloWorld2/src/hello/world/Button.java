package hello.world;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Button {
	
	public static int strikesCurrent=0;
	public static int ballsCurrent=0;
	public static int outsCurrent=0;
	public static int pitchCount=0;
	
	public static void createWindow() {
		
		  JFrame f=new JFrame("Button Example");  
		    f.setSize(500,800);
		    f.setVisible(true);
		    f.setLayout(null);
		    
		    JLabel labelPitchCount=new JLabel("Pitches: "+pitchCount);
		    labelPitchCount.setBounds(200,0,200,100);
		    f.add(labelPitchCount);
		    
		    JLabel labelStrikes=new JLabel("Strikes: "+strikesCurrent);
		    labelStrikes.setBounds(200,50,100,100);
		    f.add(labelStrikes);
		    
		    JLabel labelBalls=new JLabel("Balls: "+ballsCurrent);
		    labelBalls.setBounds(200,100,100,100);
		    f.add(labelBalls);
		    
		    JLabel labelOuts=new JLabel("Outs: "+outsCurrent);
		    labelOuts.setBounds(200,150,100,100);
		    f.add(labelOuts);
		    
		    JButton buttonStrike=new JButton("Strike");  
		    buttonStrike.setBounds(0,0,100,100);  
		    f.add(buttonStrike);
		    
		    buttonStrike.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){ 
		    				pitchCount ++;  
		    				strikesCurrent++;
		    				if (strikesCurrent == 3) {
		    				strikesCurrent = 0;
		    				outsCurrent++;
		    				}
		    				labelPitchCount.setText("Pitches: "+pitchCount);
		    				labelStrikes.setText("Strikes: "+strikesCurrent);
		    				labelOuts.setText("Outs: "+outsCurrent);
		    	            
		        }  
		    });
		    
		    
		    
		    JButton buttonBall=new JButton("Ball");  
		    buttonBall.setBounds(100,0,100,100);  
		    f.add(buttonBall);
		    
		    buttonBall.addActionListener(new ActionListener(){  
		    	public void actionPerformed(ActionEvent e){
		    				pitchCount ++;
		    				ballsCurrent ++;
		    				labelPitchCount.setText("Pitches: "+pitchCount);
		    				labelBalls.setText("Balls: "+ballsCurrent);
		        }  
		    });
		
	}
}
