package qa.tennis;

public class TennisScorer {
	private Score score;
	private String previousString;
	
	public TennisScorer() {
		score = new Score();
		previousString = "";
	}
	
	public void winningPoint(char player) {
		winningPoints(String.valueOf(player));
	}

	public boolean validateInput(String input){
		if(input.equalsIgnoreCase("X") || input.equalsIgnoreCase("A") || input.equalsIgnoreCase("B")) return true;

		System.out.println("Oops, please enter A or B or X to quit");
		return false;
	}

	public void winningPoints(String players) {
	    calculateScore(players);
		if (validateInput(players)) previousString += players;
	}


	public String currentScore() {
		char[] winningSequence = previousString.toCharArray();
		String tally = score.getPlayerAgameScore() + ":" + score.getPlayerBgameScore();
		return tally;
	}

	public Score getScore() {
		return score;
	}

//	public void calculateScore(char[] points){
//
//        for(int i=0; i< points.length; i++ ) {
//            System.out.println(points[i]);
//
//            // wining game.
//
//            if(points[i] == 'A') {
//                // check if player b does not have 40 points.
//                score.setPlayerAgameScore(incrementPlayer(score.getPlayerAgameScore(), score.getPlayerBgameScore()));
//            }
//
//            if(points[i] == 'B') {
//                // check if player b does not have 40 points.
//                score.setPlayerBgameScore(incrementPlayer(score.getPlayerBgameScore(), score.getPlayerAgameScore()));
//            }
//
//
//            if(score.getPlayerAgameScore() == "W" || score.getPlayerBgameScore() == "W") break;
//        }
//
//        System.out.println("SCORE: " + score.getPlayerAgameScore() + ":" + score.getPlayerBgameScore());
//    }


    public void calculateScore(String player){
            // wining game.
            if(player.equalsIgnoreCase("A")) {
                // check if player b does not have 40 points.
                score.setPlayerAgameScore(incrementPlayer(score.getPlayerAgameScore(), score.getPlayerBgameScore(), player));
            }

            if(player.equalsIgnoreCase("B")) {
                // check if player b does not have 40 points.
                score.setPlayerBgameScore(incrementPlayer(score.getPlayerBgameScore(), score.getPlayerAgameScore(), player));
            }
    }

    public String incrementPlayer(String playerCurrentScore, String otherPlayer, String player){
        switch (playerCurrentScore) {
            case "0":
                playerCurrentScore = "15";
                break;
            case "15":
                playerCurrentScore = "30";
                break;
            case "30":
                if(otherPlayer.equals("40")) {
                    playerCurrentScore = "D";
                    if (player.equalsIgnoreCase("A")) {
                        score.setPlayerBgameScore("D");
                    } else {
                        score.setPlayerAgameScore("D");
                    }
                    break;
                }
                playerCurrentScore = "40";
                break;
            case "40":
                if(otherPlayer.equals("A")){
                    if (player.equalsIgnoreCase("A")) {
                        score.setPlayerBgameScore("D");
                    } else {
                        score.setPlayerAgameScore("D");
                    }
                    playerCurrentScore = "D";
                    break;
                }
                playerCurrentScore = "W";
                break;
            case "D":
                    playerCurrentScore = "A";
                    break;
            case "A":
                playerCurrentScore = "W";
                break;
        }
        return playerCurrentScore;
    }
	

}
