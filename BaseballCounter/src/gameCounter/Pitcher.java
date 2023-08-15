package gameCounter;

public class Pitcher {
	
	public String teamName = ""; 
	public int pitchingOrderNumber = 1;
	
	public int pitches = 0;
	public int walks = 0;
	public int strikeouts = 0;
	public int strikes = 0;
	public int balls = 0;
	public int hits = 0;
	public double runsAllowed = 0.00;
	public double outsPitched = 0.00;
	
	void print() {
		System.out.println("------------------------------------");
		System.out.println("Pitcher #" + pitchingOrderNumber + " for the " + teamName + ":");
		System.out.println("Pitches: " + pitches);
		if (strikes + balls == 0) {
			System.out.println("Strike %: n/a");
		} else {
			System.out.println("Strike %: " + (100*strikes)/(strikes + balls) + "%");
		}
		System.out.println("Strikeouts: " + strikeouts);
		System.out.println("Walks: " + walks);
		System.out.println("Hits: " + hits);
		if (outsPitched == 0) {
			System.out.println("ERA: n/a");
		} else {
			System.out.println("ERA: " + ((Math.round(100.0*27.00*runsAllowed/outsPitched))/100.0));
		}
	}
}
