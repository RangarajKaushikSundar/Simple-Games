/**
 * 
 */
package comp.sample.first;



import java.util.Scanner;

public class SampleFirst {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("****Start Book Cricket****");
		
		//GET THE BOOK SIZE
		System.out.println("How many pages does your book have   :");
		int numberOfPages = 0;
		try{	
			numberOfPages =  scanner.nextInt();
		}catch(Exception e){
			e.printStackTrace();
		}
		while(numberOfPages > 2000 || numberOfPages < 30){
			System.out.println("You have to be kidding me! Enter lesser than 2000 pages/more than 30 pages");
			try{	
				numberOfPages =  scanner.nextInt();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//GET NUMBER OF PLAYERS
		System.out.println("Enter the number of Players    :");
		int numberOfPlayers = 0;
		try{	
			numberOfPlayers =  scanner.nextInt();
		}catch(Exception e){
			e.printStackTrace();
		}
		while(numberOfPlayers > 10 || numberOfPlayers < 2){
			if(numberOfPlayers > 10){
				System.out.println("Its gonna take forever to end the game. Select lesser players");
			}
			else {
				System.out.println("Enter more players.");
			}
			try{	
				numberOfPlayers =  scanner.nextInt();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	
	/*********	START GAME	**************/
			//INITIALIZE
			boolean isGameOver = false;
			SampleFirstPlayer[] players = new SampleFirstPlayer[numberOfPlayers];
			SampleFirstBook book =  new SampleFirstBook(numberOfPages);
			SampleComments comments =  new SampleComments();
	
			//GET PLAYER NAMES
			for(int i = 0 ; i < players.length ; i++){
				players[i] =  new SampleFirstPlayer();
				System.out.println("Enter the name of Player "+(i+1)+ ":  ");
				players[i].name = scanner.next();
			}
			System.out.println("The pages of the book are divided into three equal parts");
			System.out.println("Press 1 - first part");
			System.out.println("Press 2 - middle part");
			System.out.println("Press 3 - last part");
			int round = 0 ;
			int i = 0;
			String comment;
			while(!isGameOver){
				if(checkIfGameOver(players)){
					printScores(players);
					break;
				}
				else {
					if(i < players.length){
						if(!players[i].isOut){
								int set = 0;
								System.out.println(players[i].name+"!");
								while(set <= 0 || set > 3){	
									System.out.println("Choose part of book(1/2/3) - ");
									try{
										set = scanner.nextInt();
									}catch(Exception e){
										e.printStackTrace();
									}
								}
								int score = book.getNextScore(set);
								int runs = 0;
								runs = getRuns(score);
								while(runs>6){
									score = book.getNextScore(set);
									runs = getRuns(score);
								}
								System.out.println("Page Number : "+score);
								comment = comments.getCommentForRuns(runs);
								if(comment!= ""||comment!= null){
									System.out.println(comment);
								}
								if(runs!=0){
									players[i].totalScore+=runs;
								}
								else {
									System.out.println("You are OUT!");
									players[i].isOut = true;
									
								}
								System.out.println("Total Runs - "+players[i].name+" :"+players[i].totalScore +"\n\n");
						}
					  i++;
					}
					else {
						i = 0;
						round++;
						System.out.println("**** ROUND "+round+" *****");
						continue;
					}
				 continue;
				}
			}
		
	}
	 private static void printScores(SampleFirstPlayer[] players) {
		String winner;
		int topScore;
		System.out.println("****** RESULTS ********");
		System.out.println("Individual Scores");
		topScore = players[0].totalScore;
		winner = players[0].name;
		for(int i=0 ; i<players.length ; i++){
			System.out.println(players[i].name + "   :   " + players[i].totalScore);
			if(topScore < players[i].totalScore){
				topScore = players[i].totalScore;
				winner = players[i].name;
			}
		}
		if(!isDraw(players)){
			System.out.println("\n And the WINNER IS");
			System.out.println(winner+"!!!! with the top score of "+topScore);
		}
		else{
			System.out.println("It Ended In A DRAW :(");
		}
		
	}
	private static boolean isDraw(SampleFirstPlayer[] players) {
		boolean isDraw = true;
		int score = players[0].totalScore;
		for(int i = 0 ; i < players.length ; i++){
			if(score != players[i].totalScore){
				isDraw = false;
				break;
			}
		}
		return isDraw;
	}
	private static boolean checkIfGameOver(SampleFirstPlayer[] players) {
		boolean isOver = true;
		int numberOfActivePlayers = 0;
		int activePlayer = 0;
		int highestScoreOfInactivePlayer = 0;
		for(int i = 0 ; i < players.length ; i++){
			if(players[i].isOut == false){
				isOver = false;
				numberOfActivePlayers++;
				activePlayer = i;
			}
			else{
				if(highestScoreOfInactivePlayer < players[i].totalScore){
					highestScoreOfInactivePlayer = players[i].totalScore;
				}
			}
		}
		if(numberOfActivePlayers == 1){
			int score = players[activePlayer].totalScore;
			if(score > highestScoreOfInactivePlayer){
				isOver = true;
			}
		}
		return isOver;
	}
	private static int getRuns(int score){
		 int run = 0;
		 run =  score % 10;
		 return run;
	 }
	
	
}
