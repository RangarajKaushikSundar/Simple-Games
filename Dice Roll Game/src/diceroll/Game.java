package diceroll;

public class Game {
	
	private int score = 0;
	private String name = "";

	public int rollDice(){
		int score =  (int)(Math.random()*6+1);
		return score;
	}
	
	public void addScore(int newScore){
		score += newScore;
	}
	public String getName() {
		return name;
	}

	public void setNames(String player) {
		name = player;
	}

	public int getScore() {
		return score;
	}

}
