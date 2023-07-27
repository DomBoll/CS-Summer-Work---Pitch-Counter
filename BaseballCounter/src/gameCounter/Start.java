package gameCounter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Start {
	
	public static void main(String[] args) {
		
		
		JFrame initialWindow =new JFrame("Pitch Counter");  
	    initialWindow.setSize(1000,800);
	    
		
	    JLabel homeTeamNameLabel =new JLabel("Home Team Name:");
	    homeTeamNameLabel.setBounds(100,50,200,50);
	    initialWindow.add(homeTeamNameLabel);
	    
	    JTextField homeTeamField = new JTextField("Home Team");
		homeTeamField.setBounds(100, 100, 300, 50);
		initialWindow.add(homeTeamField);
		
		JLabel awayTeamNameLabel =new JLabel("Away Team Name:");
	    awayTeamNameLabel.setBounds(400,50,200,50);
	    initialWindow.add(awayTeamNameLabel);
	    
		JTextField awayTeamField = new JTextField("Away Team");
		awayTeamField.setBounds(400, 100, 300, 50);
		initialWindow.add(awayTeamField);
		
		JButton startGameButton=new JButton("Start Game");  
	    initialWindow.add(startGameButton);
	    startGameButton.setBounds(250,300,100,100); 
	    
	    startGameButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){ 
	    				Game game1 = new Game();
	    				game1.startGame(homeTeamField.getText(), awayTeamField.getText());
	    				initialWindow.setVisible(false);
	        }  
	    });
	    
		initialWindow.setLayout(null);
	    initialWindow.setVisible(true);
	    
	}

}
