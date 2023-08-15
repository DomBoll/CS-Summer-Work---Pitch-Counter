The purpose of my software application is to record statistics from a live baseball game and be able to turn those into game stats for individual pitchers in the game. I want to make it so that someone watching a baseball game could record what happens in the game and from that generate stats for each pitcher in the game.]
This is a program that fuses together two types of programs that are much more common: Apps on your phone that you can use to record the scores of baseball games live (where it outputs at the end the final score of the game) and websites online you can use to track the statistics of MLB players. With this app you can track stats for the little league/high school baseball players whose games you watch live. 
My application features buttons that you would use to keep track of a game you are watching live, and when the game is over my application prints a little statistic sheet for every pitcher in the game.functionality?

I used the java swing tool to create windows, buttons, labels, and text boxes in my application. This was very important because I wanted to create an application with buttons that you could use to quickly note small things that happened in the game, rather than having to type something in every time anything happened in the game. I used swing because I am a very new java programmer and I don't know how I could make windows without any tools. Swing simplified a lot of the programming for me so that I could get the asssignment done on time while making the program complex enough to be useful.

I did not need any big arrays, lists, etc. for my program. The closest I got to that was for recording each pitcher's individual stats. This was done by having a ton of variables in the pitcher class rather than the game class, and then just making those variables public so that the game could easily enough reference them whenever they were needed. For example, I could have recorded the home pitcher's strikeouts and away pitcher's strikeouts each in the game class but that would have made for an unneccessary amount of complexity in the game class.

void addOut() {

		ballsCurrent = 0;
  
		strikesCurrent = 0;
  
		outsCurrent++;
  
		if (bottomOfInning == true) awayPitcher.outsPitched++; else homePitcher.outsPitched++;
		if (outsCurrent == 3) {
			if (bottomOfInning == true) {
				if (inning == LastInning) {
					gameEnd();
				}
				bottomOfInning = false;
				inning++;
				outsCurrent = 0;
			} else {
				if (inning == LastInning && homeRuns > homeRuns) {
					gameEnd();
				}
				bottomOfInning = true;
				outsCurrent = 0;
			};
		}
	}

This is the procedure that I use whenever an out occurs in the game. This procedure is called upon when the "Out" button is clicked (meaning that the batter hit a ground ball out or flyout, or a runner was tagged out), or when the third strike occurs (meaning that the batter struck out). This code first resets the balls and strikes count for the next batter, then it increases the amount of outs in the game and adds an "out" stat to the active pitcher recording that the pitcher got an out. Because the third out of an inning ends the inning, the code must then check if there are 3 outs. If there are, it checks whether it is the bottom or the top of the inning. If it was the top of the inning, then it becomes the bottom of the same inning (unless it is the 9th inning and the home team is winning, in which case the game ends because the away team can no longer win). If it was the bottom of the inning, then it becomes the top of the next inning (unless it is the 9th inning in which case the game ends because there are 9 innings in a baseball game). Different calls have different effects: if this is called when there is 1 out in the bottom of the 5th inning, all that happens is that the strike and ball counts are reset, one out is added, and the active pitcher gets an out added to their stat totals. However, if this is called when there are 2 outs in the bottom of the 9th inning, the game ends because this is the third out of the last inning.
