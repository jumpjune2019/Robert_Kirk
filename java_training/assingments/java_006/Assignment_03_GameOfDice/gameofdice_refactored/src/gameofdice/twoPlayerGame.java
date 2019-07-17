package gameofdice;

import gameofdice.functionalinterfaces.DieInspector;

public class twoPlayerGame {
	
	private int player1Score=0;
	private int player2Score=0;
	private int tied = 0;
	
	public void judgeVictor(int[] score1, int[] score2) {
		int player1 = score1[0] + score1[1];
		int player2 = score2[0] + score2[1];
		if(player1 == player2) {
			this.processTieScore(score1, score2);
		}else if(player1 > player2) {
			this.player1Score++;
			this.playerWins(false);
		}else {
			this.player2Score++;
			this.computerWins(false);
		}
	}
	DieInspector inspection = (int[] arr)-> arr[0] == arr[1];
	
	private void processTieScore(int[] score1, int[] score2) {
		if(inspection.inspect(score1) && inspection.inspect(score2)) {
			System.out.println("Stalemate! You’re tough, let’s try for a tie-breaker Press any key "
					+ "and ENTER to throw your dice or press (Q or q) to quit");
		}else if(inspection.inspect(score1)) {
			this.playerWins(true);
		}else if(inspection.inspect(score2)) {
			this.computerWins(true);
		}else {
			System.out.println("Damn! We tied and can't determine a winner!\n"
					+ "Wanna try again? Press any key and ENTER to throw your "
					+ "dice or press (Q or q) to quit");
		}
		
	}
	private void computerWins(boolean doubleVal) {
		if(doubleVal) {
			System.out.println("Damn! I win on a Double! Ah! I pity you fool!\n" + 
					"Wanna try again? Press any key and ENTER to throw your dice or "
					+ "press (Q or q) to quit");
			
		}else {
			System.out.println("VICTORY!!!! Wanna try again? Press any key and ENTER to throw your "
					+ "dice or press (Q or q) to quit");
		}
	}
	private void playerWins(boolean doubleVal) {
		if(doubleVal) {
			System.out.println("Damn! You win on a Double! What Luck!\n" + 
					"Did you cheat?? Gimme another try, c’mon Press any key and ENTER to "
					+ "throw your dice or press (Q or q) to quit");
		}else {
			System.out.println("Did you cheat?? Gimme another try, c’mon Press any key "
					+ "and ENTER to throw your dice or press (Q or q) to quit");
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
