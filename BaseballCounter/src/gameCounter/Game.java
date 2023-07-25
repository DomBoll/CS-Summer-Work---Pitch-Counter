package gameCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {

	int strikesCurrent=0;
	int ballsCurrent=0;
	int outsCurrent=0;
	int pitchCount=0;
	
	void startGame() {
		
		JFrame gameWindow=new JFrame("Button Example");  
	    gameWindow.setSize(500,800);
	    gameWindow.setVisible(true);
	    gameWindow.setLayout(null);
	    
	    JLabel labelPitchCount=new JLabel("Pitches: "+pitchCount);
	    labelPitchCount.setBounds(200,0,200,100);
	    gameWindow.add(labelPitchCount);
	    
	    JLabel labelStrikes=new JLabel("Strikes: "+strikesCurrent);
	    labelStrikes.setBounds(200,50,100,100);
	    gameWindow.add(labelStrikes);
	    
	    JLabel labelBalls=new JLabel("Balls: "+ballsCurrent);
	    labelBalls.setBounds(200,100,100,100);
	    gameWindow.add(labelBalls);
	    
	    JLabel labelOuts=new JLabel("Outs: "+outsCurrent);
	    labelOuts.setBounds(200,150,100,100);
	    gameWindow.add(labelOuts);
	    
	    JButton buttonStrike=new JButton("Strike");  
	    buttonStrike.setBounds(0,0,100,100);  
	    gameWindow.add(buttonStrike);
	    
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
	    gameWindow.add(buttonBall);
	    
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
