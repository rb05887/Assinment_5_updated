package test;

import java.util.Scanner;

class CompetitionLog {
	private int playerNumber;
	private String completeSets;
	private String incompleteSets;
	private int piecesBuilt;
	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	CompetitionLog(int playerNumber, String completeSets, String incompleteSets, int piecesBuilt) {
		this.playerNumber = playerNumber;
		this.completeSets = completeSets;
		this.incompleteSets = incompleteSets;
		this.piecesBuilt = piecesBuilt;
	}
	public int getPlayerNumber() {
		return playerNumber;
	}
	public String getCompleteSets() {
		return completeSets;
	}
	public String getIncompleteSets() {
		return incompleteSets;
	}
	public int getPiecesBuilt() {
		return piecesBuilt;
	}
	public void setCompleteSets(String completeSets) {
		this.completeSets = completeSets;
	}
	public void setIncompleteSets(String incompleteSets) {
		this.incompleteSets = incompleteSets;
	}

	public void setPiecesBuilt(int piecesBuilt) {
		this.piecesBuilt = piecesBuilt;
	}

	public String toString() {
		return "Player " + playerNumber + " completed the following sets: " + completeSets + "\n" + "Player "
				+ playerNumber + " did not complete the following sets: " + incompleteSets + "\n" + "Player "
				+ playerNumber + " built a total of " + piecesBuilt + " pieces\n";
	}
}
	public class LegoSetCompetition {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			String[] setNames = new String[3];
			int[] setPieces = new int[3];
			System.out.println("Welcome to the Lego Set Competition!");
			for (int i = 0; i < 3; i++) {
				System.out.print("Enter the name of LEGO set " + (i + 1) + ": ");
				setNames[i] = sc.nextLine();
				System.out.print("Enter the number of pieces in LEGO set " + (i + 1) + ": ");
				setPieces[i] = Integer.parseInt(sc.nextLine());
			}
			int player1PiecesBuilt = 0;
			int player2PiecesBuilt = 0;
			String player1CompleteSets = "";
			String player2CompleteSets = "";
			String player1IncompleteSets = "";
			String player2IncompleteSets = "";
			int day = 1;
			// Continue the competition until a player has completed all three sets.
			while (true) {
				System.out.print("Enter the number of pieces Player 1 used for building on day  " + day+": ");
				int player1PiecesToday = Integer.parseInt(sc.nextLine());
				player1PiecesBuilt += player1PiecesToday;
				player1IncompleteSets = "";
				player2IncompleteSets = "";
				for (int i = 0; i < 3; i++) {
					if (player1PiecesBuilt >= setPieces[i]) {
						player1CompleteSets += setNames[i] + ",";
						player1PiecesBuilt += setPieces[i];
					} else {
						player1IncompleteSets += setNames[i] + ",";
					}
				}
				System.out.print("Enter the number of pieces Player 2 used for building on day  " + day+": ");
				int player2PiecesToday = Integer.parseInt(sc.nextLine());
				player2PiecesBuilt += player2PiecesToday;
				for (int i = 0; i <3 ; i++) {
					if (player2PiecesBuilt >= setPieces[i]) {
						player2CompleteSets += setNames[i] + ",";
						player2PiecesBuilt += setPieces[i];
					} else {
						player2IncompleteSets += setNames[i] + ",";
					}
				}
				// Check if any player has completed all three sets.
				if (player1CompleteSets.length() >= 3 * (setNames[0].length() )
						|| player2CompleteSets.length() >= 3 * (setNames[0].length() )) {
					break;
				}
				day++;
			}
			CompetitionLog player1Log = new CompetitionLog(1, player1CompleteSets, player1IncompleteSets,
					player1PiecesBuilt);
			CompetitionLog player2Log = new CompetitionLog(2, player2CompleteSets, player2IncompleteSets,
					player2PiecesBuilt);
			// Print the competition results.
			System.out.println("Competition Results:");
			System.out.println(player1Log);
			System.out.println(player2Log);
			sc.close();
		}
		}

	

