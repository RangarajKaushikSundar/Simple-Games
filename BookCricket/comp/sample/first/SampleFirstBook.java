package comp.sample.first;

public class SampleFirstBook {
	
	int bookSize;
	
	public SampleFirstBook(int bookSizes) {
		bookSize = bookSizes;
	}
	
	/**
	 * Change this function for getting comments.
	 * @return Score
	 */
	public int getNextScore(int set){
		int score = 0;
		score = getScoreForSet(set);
		while(score%2 != 0){
			score = getScoreForSet(set);
		}
		return score;
	}
	
	private int getScoreForSet(int set){
		int score = 0;
		int oneThird =  (int)(0.33 * bookSize);
		int twoThird =  (int)(0.66 * bookSize);
		switch (set) {
			case 1:
				 score = getRandomNumberBetweenLimits(0,oneThird);
				break;
			case 2:
				score = getRandomNumberBetweenLimits(oneThird,twoThird);
				break;
			
			case 3:
				score = getRandomNumberBetweenLimits(twoThird,bookSize);
				break;
			default:
				System.out.println("The set is "+set);
				break;
		}
		return score;
	}
	
	/**
	 * Get Random Number Between Limits
	 * @param lowerLimit
	 * @param upperLimit
	 * @return
	 */
	private int getRandomNumberBetweenLimits(int lowerLimit, int upperLimit){
		int rand = 0;
		int loopCounter = 0;
			if(lowerLimit >= 0 && upperLimit >= 0){
				do {
					loopCounter++;
					rand = randomNumberGenerator(upperLimit);
					if(loopCounter > 11){
						System.out.println("Stuck in Loop: Book Size "+bookSize );
						System.out.println("Lower Limit  " + lowerLimit);
						System.out.println("Upper Limit  " + upperLimit);
						break;
					}
				}while(rand < lowerLimit || rand <= 0);
				
			}
		
		return rand;
	}
	
	
	
	private int randomNumberGenerator(int limit){
		return (int)(Math.random()*limit);
	}
}
