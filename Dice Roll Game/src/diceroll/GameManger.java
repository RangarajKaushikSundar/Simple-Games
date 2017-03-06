package diceroll;


import java.util.Scanner;

public class GameManger {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		GameManger gameManager = new GameManger();
		try{
	    	System.out.println("Number of Players  :");
	    	int numberOfPlayers = scanner.nextInt();
	    	Game[] game = null;
	    	if(numberOfPlayers > 0){
	    		game = gameManager.getPlayers(numberOfPlayers);
	    	}
	    	else{
	    		scanner.close();
	    		return;
	    	}
	    	gameManager.setNames(game, scanner);
	    	System.out.println("Game Starts");
	    	int choice;
	    	while(true){
	    		System.out.println("***********************************");
	    	   	System.out.println("Select your option :: ");
		    	System.out.println("1. Play Game");
		    	System.out.println("2. Check Scores");
		    	System.out.println("3. Read Rules");
		    	System.out.println("4. Exit Game");
		    	choice = scanner.nextInt();
		    	switch (choice) {
				case 1:
						gameManager.playGame(game,scanner);
						break;
				case 2:
						gameManager.checkScores(game);
						break;
						
				case 3 :
						gameManager.howToPlay();
						break;
						
				case 4:
						return;

				default:
						System.out.println("Invalid Choice");
						break;
				}
	    	}
	    }
	    catch(Exception e){
	    	e.printStackTrace();
	    }
	    scanner.close();
	}

	private void howToPlay() {
		System.out.println("Welcome to Roll the Dice");
		System.out.println("Number of players - More than 1");
		System.out.println("\n\nHow to play");
		System.out.println("1. Register players");
		System.out.println("2. Roll Dice");
		System.out.println("\n\nRules");
		System.out.println("1. Computer rolls the dice, the positive difference of the computer's value and that of the player's will be the player's round score");
		System.out.println("2. If player's roll matches with that of the computer, the player gets 6 points");
		System.out.println("3. The player(s) with the largest roll value will get 2 extra points");
	}

	/**
	 * @param numberOfPlayers
	 * @return game objects - players
	 */
	private Game[] getPlayers(int numberOfPlayers) {
	
		Game[] game = new Game[numberOfPlayers];
		for(int i=0 ; i<game.length ; i++){
			game[i]= new Game(); 
		}
		return game;
	}
	private int[] getScoreBoard(int numberOfPlayers) {
		int[] scoreBoard = new int[numberOfPlayers];
		return scoreBoard;
	}

	private void playGame(Game[] game, Scanner scanner){
		int[] scoreBoard = getScoreBoard(game.length);
		for(int i=0;i<game.length ; i++){
			System.out.println("\n"+game[i].getName()+"'s turn");
			System.out.println("Press any key to roll dice");
			scanner.nextLine();
			scanner.nextLine();
			scoreBoard[i] = game[i].rollDice();
			System.out.println(game[i].getName()+" rolls : "+scoreBoard[i]);
		}
		int[] finalScores = calculateScore(scoreBoard);
		for (int i = 0; i < finalScores.length; i++) {
			game[i].addScore(finalScores[i]);
		}
}
	
	private void checkScores(Game[] game){
		int maxIndex = 0;
		int maxVal = game[0].getScore();
		System.out.println("Name    | Score     ");
		for(int i = 0; i < game.length ; i++){
			System.out.println(game[i].getName()+" | "+game[i].getScore()+"     ");
			if(maxVal<game[i].getScore()){
				maxIndex = i;
				maxVal = game[i].getScore();
			}
		}
		System.out.println("\n"+game[maxIndex].getName()+" is leading with "+game[maxIndex].getScore()+" points");
	}
	
	private void setNames(Game[] game, Scanner scanner){
		try{
			for(int i = 0; i < game.length ; i++){
				System.out.println("Name of Player "+i+" : ");
				String name = scanner.next();
				game[i].setNames(name);
			}
		}
		catch(Exception e){
			e.printStackTrace();	
		}
		
	}
	
	public int[] calculateScore(int[] scoreBoard){
		Game game = new Game();
		int computerScore = game.rollDice();
		System.out.println("Computer rolls :"+computerScore);
		int[] finScore = new int[scoreBoard.length];
		int maxVal = 0;
		for(int i = 0 ; i< scoreBoard.length ; i++){
			if(maxVal<scoreBoard[i]){
				maxVal = scoreBoard[i];
			}
			finScore[i] =  scoreBoard[i]>computerScore? scoreBoard[i]-computerScore : computerScore-scoreBoard[i];
		}
		for(int i = 0 ; i< scoreBoard.length ; i++){
			if(finScore[i] == 0){
				finScore[i] +=6;
			}
			if(scoreBoard[i] == maxVal){
				finScore[i]+=2;
			}
		}
		return finScore;
	}
}


