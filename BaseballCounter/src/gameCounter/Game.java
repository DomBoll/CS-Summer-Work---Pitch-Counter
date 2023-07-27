package gameCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Game {

	//create variables
	
	String homeTeamName;
	String awayTeamName;
	
	int strikesCurrent = 0;
	int ballsCurrent = 0;
	int outsCurrent = 0;
	int pitchCount = 0;
	int inning = 1;
	boolean bottomOfInning = false;
	Pitcher homePitcher = new Pitcher();
	Pitcher awayPitcher = new Pitcher();
	
	JFrame gameWindow=new JFrame();
	JLabel labelPitchCount=new JLabel();
	JLabel labelStrikes=new JLabel();
	JLabel labelBalls=new JLabel();
	JLabel labelOuts=new JLabel();
	JLabel labelInning=new JLabel();
	JLabel labelAwayRuns=new JLabel();
	JLabel labelHomeRuns=new JLabel();
	
	JButton buttonStrike=new JButton("Strike");
	JButton buttonBall=new JButton("Ball"); 
	JButton buttonHit=new JButton("Hit");
	JButton buttonRun=new JButton("Run");
	JButton buttonOut=new JButton("Out");


	
	void startGame (String homeTeam, String awayTeam) {
		//Import team names
		homeTeamName = homeTeam;
		awayTeamName = awayTeam;
		homePitcher.teamName = homeTeamName;
		awayPitcher.teamName = awayTeamName;
		
		//Setup window
		update();
		gameWindow.setName(awayTeamName + " at " + homeTeamName);
	    gameWindow.setSize(1000,800);
	    gameWindow.setVisible(true);
	    gameWindow.setLayout(null);
	    
	    labelPitchCount.setBounds(200,0,200,100);
	    gameWindow.add(labelPitchCount);
	    
	    labelStrikes.setBounds(200,50,100,100);
	    gameWindow.add(labelStrikes);
	    
	    labelBalls.setBounds(200,100,100,100);
	    gameWindow.add(labelBalls);
	    
	    labelOuts.setBounds(200,150,100,100);
	    gameWindow.add(labelOuts);
	    
	    labelInning.setBounds(200,200,100,100);
	    gameWindow.add(labelInning);

	    labelAwayRuns.setBounds(200,250,100,100);  
	    gameWindow.add(labelAwayRuns);
	    
	    labelHomeRuns.setBounds(200,300,100,100);  
	    gameWindow.add(labelHomeRuns);
	    
	    //Strike button
	    buttonStrike.setBounds(0,0,100,100);  
	    gameWindow.add(buttonStrike);
	    
	    buttonStrike.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    				strikesCurrent++;
	    				addPitch();
	    				if (strikesCurrent == 3) {
	    						if (bottomOfInning == true) awayPitcher.strikeouts++; else homePitcher.strikeouts++;
	    						addOut();
	    					}
	    				
	    				update();
	        }  
	    });
	     
	    //Ball button
	    buttonBall.setBounds(100,0,100,100);  
	    gameWindow.add(buttonBall);
	    
	    buttonBall.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    				addPitch();
	    				ballsCurrent++;
	    				if (ballsCurrent == 4) {
	    					if (bottomOfInning == true) awayPitcher.walks++; else homePitcher.walks++;
	    					ballsCurrent = 0;
	    					strikesCurrent = 0;
	    				}
	    				update();
	        }  
	    });
	    
	    //Hit button
	    buttonHit.setBounds(0,100,100,100);  
	    gameWindow.add(buttonHit);
	    
	    buttonHit.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){
	    				addPitch();
	    				if (bottomOfInning == true) awayPitcher.hits++; else homePitcher.hits++;
	    				ballsCurrent = 0;
	    				strikesCurrent = 0;
	    				update();
	        }  
	    });
	    
	    //Out button
	    buttonOut.setBounds(100,100,100,100);  
	    gameWindow.add(buttonOut);
	    
	    buttonOut.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    				addPitch();
	    				addOut();
	    				update();
	        }  
	    });
	    
	    //Run button
	    buttonRun.setBounds(0,200,100,100);
	    gameWindow.add(buttonRun);
	    
	    buttonRun.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    				if (bottomOfInning == true) awayPitcher.runsAllowed++; else homePitcher.runsAllowed++;
	    				update();
	        }  
	    });
	}
		

	//Script used after any button is pressed that updates the labels
	void update() {
		labelStrikes.setText("Strikes: "+strikesCurrent);
		labelBalls.setText("Balls: "+ballsCurrent);
		labelOuts.setText("Outs: "+outsCurrent);
		labelAwayRuns.setText(awayTeamName + ": " + homePitcher.runsAllowed);
		labelHomeRuns.setText(homeTeamName + ": " + awayPitcher.runsAllowed);
		if (bottomOfInning == true) {
			labelInning.setText("Bottom "+inning);
			labelPitchCount.setText("Pitches: "+awayPitcher.pitches);
		} else {
			labelInning.setText("Top "+inning);
			labelPitchCount.setText("Pitches: "+homePitcher.pitches);
		}
		
	}
	
	//Adds a pitch to the pitch count of the correct pitcher
	void addPitch() {
		if (bottomOfInning==true) awayPitcher.pitches++; else homePitcher.pitches++;
	}
	
	//Adds outs, changes innings at 3 outs, ends program if the game is over
	void addOut() {
		ballsCurrent = 0;
		strikesCurrent = 0;
		outsCurrent++;
		if (outsCurrent == 3) {
			if (bottomOfInning == true) {
				if (inning == 9) {
					System.out.println("Game ended");
					homePitcher.print();
					awayPitcher.print();
					gameWindow.setVisible(false);
				}
				bottomOfInning = false;
				inning++;
				outsCurrent = 0;
			} else {
				bottomOfInning = true;
				outsCurrent = 0;
			};
		}
	}
	
}
