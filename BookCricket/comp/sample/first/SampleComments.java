package comp.sample.first;

public class SampleComments {
	
	String[] commentsFor2 = {"Chips down the legside for a 2.",
							"Wonderful cover drive, 2 runs.",
							"The ball goes high in the air!\nCatch Dropped!\nBatsmen quickly get 2 runs.",
							"What a shot! AND What good fielding! the fielder saved a couple for his team.",
							"Straight to the fielder, the batsmen are quick between the wickets, 2 runs.",
							"Thats a poor bit of fielding, the batsmen get 2."};
	
	String[] commentsFor4 = {"Great drive through mid on.. Boundary!",
							 "Awesome square drive, 4 runs to his total.",
							 "A nick! Goes right between the keeper and first slip, boundary.",	
							 "What a hook stroke! 4 runs!",
							 "Cant play any straighter than that! Goes right past the umpire for a boundary.",
							 "The ball goes over the fielder at mid wicket, one bounce! Boundary!"};
	
	String[] commentsFor6 = {"That's gone outta the ground! 6 runs.",
							 "Wonderful shot through the offside, 6 runs!",
							 "Thats his favorite area! He will hammer you if you bowl there! 6 RUNS!",
							 "Is the fielder at deep mid wicket going to take it? No! Gone for a six.",
							 "That was pure power through the legside! SIX!",
							 "Goes above backward point for a boundary! Wait.. its gone for a SIX! What a flat shot!!"};
	
	String[] commentsForOut = {"That was a lazy shot! Caught by the fielder at Mid wicket!",
							   "Bowled! You cant afford to miss straight balls at this stage!",
							   "That was a monstrous drive through the legside! Caught by the fielder at deep square leg!",
							   "The ball goes straight up! Caught!!",
							   "Hit in front! The umpire raises his finger.",
							   "Is the fielder at deep square leg going to take it? Yes! He is gone!"};
	
	private int randomNumberGenerator(int limit){
		return (int)(Math.random()*limit);
	}
	
	public String getCommentForRuns(int runs){
		String comment;
		int rand = 0;
		rand = randomNumberGenerator(6);
		switch(runs){
		
			case 0 :
				comment = commentsForOut[rand];
				break;
			
			case 2 :
				comment = commentsFor2[rand];
				break;
				
			case 4 :
				comment = commentsFor4[rand];
				break;
				
			case 6 :
				comment = commentsFor6[rand];
				break;
			
			default:
				comment = "";
				break;
			
				
		}
		
		return comment;
	}
								

}
