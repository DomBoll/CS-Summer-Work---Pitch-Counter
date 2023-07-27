package gameCounter;

public class Pitcher {
	
	public String teamName = ""; 
	public int pitches = 0;
	public int walks = 0;
	public int strikeouts = 0;
	public int strikes = 0;
	public int balls = 0;
	public int hits = 0;
	public int runsAllowed = 0;
	
	void print() {
		System.out.println("------------------------------------");
		System.out.println("Pitcher for " + teamName + ":");
		System.out.println("Pitches: " + pitches);
		System.out.println("Strikes: " + strikes);
		System.out.println("Balls: " + balls);
		System.out.println("Strikeouts: " + strikeouts);
		System.out.println("Walks: " + walks);
		System.out.println("Hits: " + hits);
		System.out.println("Runs allowed: " + runsAllowed);
	}
}
