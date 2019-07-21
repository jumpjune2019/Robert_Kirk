package gameofdice;

import gameofdice.functionalinterfaces.DieInspector;

public class twoPlayerGame {
	
	private int player1Score=0;
	private int player2Score=0;
	private int tied = 0;
	
	public String judgeVictor(int[] score1, int[] score2) {
		int player1 = score1[0] + score1[1];
		int player2 = score2[0] + score2[1];
		if(player1 == player2) {
			return this.processTieScore(score1, score2);
		}else if(player1 > player2) {
			this.player1Score++;
			return this.playerWins(false);
		}else {
			this.player2Score++;
			return this.computerWins(false);
		}
	}
	DieInspector inspection = (int[] arr)-> arr[0] == arr[1];
	
	private String processTieScore(int[] score1, int[] score2) {
		if(inspection.inspect(score1) && inspection.inspect(score2)) {
			return ("Stalemate! You’re tough, let’s try for a tie-breaker. Click the button to roll again");
		}else if(inspection.inspect(score1)) {
			return this.playerWins(true);
		}else if(inspection.inspect(score2)) {
			return this.computerWins(true);
		}else {
			return "Damn! We tied and can't determine a winner!\n"
					+ "Wanna try again? Click the button to roll again";
		}
		
	}
	private String computerWins(boolean doubleVal) {
		if(doubleVal) {
			return "Damn! I win on a Double! Ah! I pity you fool!\n" + 
					"Wanna try again? Click the button to roll again";
			
		}else {
			return "VICTORY!!!! Wanna try again? Click the button to roll again";
		}
	}
	private String playerWins(boolean doubleVal) {
		if(doubleVal) {
			return "Damn! You win on a Double! What Luck!\n" + 
					"Did you cheat?? Gimme another try, c’mon. Click the button to roll again";
		}else {
			return "Did you cheat?? Gimme another try, c’mon. Click the button to roll again";
		}
		
	}

	public int getPlayer1Score() {
		return player1Score;
	}
	public void setPlayer1Score(int player1Score) {
		this.player1Score = player1Score;
	}
	public int getPlayer2Score() {
		return player2Score;
	}
	public void setPlayer2Score(int player2Score) {
		this.player2Score = player2Score;
	}

	public int getTied() {
		return tied;
	}

	public void setTied(int tied) {
		this.tied = tied;
	}
	
	

}
