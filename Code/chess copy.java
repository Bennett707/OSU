import java.util.*;
import java.io.*;

public class chess {
	public static void main (String args[]) {


		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		
		String[][] board = setupboard();
		
		while (gameIsNotOver(board)) {
			printBoard(board);
			int[] move = getUserInput(scnr);
			
			if (isLegalW(board, move)) {
				updateBoard(board, move);
			} else {
				System.out.println("That is not a legal move. Try again. :)");
				continue;
			}
			int[] Cmove = CompInput(rand);
			makeComputerMove(board, Cmove, rand);
		}
		System.out.println(whoWon(board));
	}
	
	public static String[][] setupboard() {
		
		String[][] board = new String[9][9];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = "";
			}
		}
		board[8][1] = board[8][8] = "BR";
		board[8][2] = board[8][7] = "BN";
		board[8][3] = board[8][6] = "BB";
		board[8][4] = "BQ";
		board[8][5] = "BK";
		for (int i = 0; i < board[7].length; i++) {
			board[7][i] = "BP";
		}
		board[1][1] = board[1][8] = "WR";
		board[1][2] = board[1][7] = "WN";
		board[1][3] = board[1][6] = "WB";
		board[1][4] = "WQ";
		board[1][5] = "WK";
		for (int i = 0; i < board[2].length; i++) {
			board[2][i] = "WP";
		}
		return board;
	}
	
	public static boolean gameIsNotOver(String[][] board) { // Checking to see if the Game is Over
		
		if ((WKST(board) == true) && (BKST(board) == true)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String whoWon(String[][] board) { // Checking to see Who Won the game
		
		if (WKST(board) == false) {
			return "Checkmate, I Win!! :)";
		}
		else if (BKST(board) == false) {
			return "Checkmate, You Win... :(";
		} else {
			return "";
		}
	}
	
	public static boolean WKST(String[][] board) { //checking to see if the White King is still on the board
		
		for (int i = board.length - 1; i >= 1; i--) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j].equals("WK")) {
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}
	
	public static boolean BKST(String[][] board) { //Checking to see if the Black King is still on the board
	
		for (int i = board.length - 1; i >= 1; i--) {
			for (int j = 1; j < board[i].length; j++) {
				if (board[i][j].equals("BK")) {
					return true;
				} else {
					continue;
				}
			}
		}
		return false;
	}
	public static void printBoard(String[][] board) {
		
		boolean isWhite = true;
		String emptyWhite = "    ";
		String emptyBlack = "++++";
		
		for (int i = board.length - 1; i >= 1; i--) {
			for (int j = 1; j < board[i].length; j++) {
				if (isWhite) {
					System.out.print(emptyWhite);
				} else {
					System.out.print(emptyBlack);
				}
				isWhite = !isWhite;
			}
			System.out.println();
			for (int j = 1; j < board.length; j++) {
				if (isWhite) {
					if (board[i][j].equals("")) {
						System.out.print(emptyWhite);
					} else {
						System.out.print(" " + board[i][j] + " ");
					}
				} else {
					if (board[i][j].equals("")) {
						System.out.print(emptyBlack);
					} else {
						System.out.print("+" + board[i][j] + "+");
					}
				}
			isWhite = !isWhite;
			}
			System.out.println();
			for (int j = 1; j < board[i].length; j++) {
				if (isWhite) {
					System.out.print(emptyWhite);
				} else {
					System.out.print(emptyBlack);
				}
			isWhite = !isWhite;
			}
			System.out.println();
			isWhite = !isWhite;
		}
	}
	
	public static int[] getUserInput(Scanner scnr) { // Getting what the player wants to move and where
		System.out.print("Enter Move (<Start Row> < Start Col> <End Row> <End Col>): ");
		 
		int[] userVal = new int[4];
		for (int i = 0; i < userVal.length; i++) {
			userVal[i] = scnr.nextInt();
		}
		return userVal;
	}
	
	public static boolean isLegalW(String[][] board, int[] move) { // Checking if the Players move is legal
		
		if ((board[move[0]][move[1]].matches("WP|WR|WN|WB|WQ|WK"))) {
			
			if (moveWP(board, move)) {
				return true;
			} 
			else if (moveWR(board, move)) { 
				return true;
			}
			else if (moveWN(board, move)) {
				return true;
			}
			else if (moveWB(board, move)) {
				return true;
			}
			else if (moveWQ(board, move)) {
				return true;
			}
			else if (moveWK(board, move)) { 
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	public static boolean isLegalB(String[][] board, int[] Cmove) { // Checking if the Computers move is legal
		
		if ((board[Cmove[0]][Cmove[1]].matches("BP|BR|BN|BB|BQ|BK"))) {
			
			if (moveBP(board, Cmove)) {
				return true;
			} 
			else if (moveBR(board, Cmove)) { 
				return true;
			}
			else if (moveBN(board, Cmove)) {
				return true;
			}
			else if (moveBB(board, Cmove)) {
				return true;
			}
			else if (moveBQ(board, Cmove)) {
				return true;
			}
			else if (moveBK(board, Cmove)) { 
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static void updateBoard(String[][] board, int[] move) {
		
		board[move[2]][move[3]] = board[move[0]][move[1]];
		board[move[0]][move[1]] = "";
	}
	
	public static void makeComputerMove(String[][] board, int[] Cmove, Random rand) { // Exicuting the Computers move
		
		while (!isLegalB(board, Cmove)) {

			for (int i = 0; i < Cmove.length; i++) {
				Cmove[i] = rand.nextInt(9);
			}
		}
		board[Cmove[2]][Cmove[3]] = board[Cmove[0]][Cmove[1]];
		board[Cmove[0]][Cmove[1]] = "";
	}
	
	public static int[] CompInput(Random rand) { // Computers Begining and Ending Position
		
		int[] compVal = new int[4];
		for (int i = 0; i < compVal.length; i++) {
			compVal[i] = rand.nextInt(9);
		}
		return compVal;
	}
	
	public static boolean moveWP(String[][] board, int[] move) { // Start of Moving White Pawn
		
		if (board[move[0]][move[1]].equals("WP")) {
			
			int moveRow = move[3] - move[1];
			int moveCol = move[2] - move[0];
			
			if ((moveRow == 1) && (moveCol == 1)) {
				if (board[move[0] + 1][move[1] + 1].matches("BP|BR|BN|BB|BQ|BK")) {
					return true;
				} else {
					return false;
				}
			}
			else if ((moveRow == - 1) && (moveCol == 1)) {
				if (board[move[0] + 1][move[1] - 1].matches("BP|BR|BN|BB|BQ|BK")) {
					return true;
				} else {
					return false;
				}
			}
			else if (moveRow != 0) {
				return false;
			}
			else if (moveCol == 1) {
				if (board[move[0] + 1][move[1]].equals("")) {
					return true;
				} else {
					return false;
				}
			}
			else if (moveCol == 2) {
				if ((move[0] == 2) && (board[move[0] + 2][move[1]].equals(""))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBP(String[][] board, int[] Cmove) { // Start of Moving Black Pawn
		
		if (board[Cmove[0]][Cmove[1]].equals("BP")) {
			
			int moveRow = Cmove[1] - Cmove[3];
			int moveCol = Cmove[0] - Cmove[2];
			
			if ((moveRow == 1) && (moveCol == 1)) {
				if (board[Cmove[0] - 1][Cmove[1] - 1].matches("WP|WR|WN|WB|WQ|WK")) {
					return true;
				} else {
					return false;
				}
			}
			else if ((moveRow == - 1) && (moveCol == 1)) {
				if (board[Cmove[0] - 1][Cmove[1] + 1].matches("WP|WR|WN|WB|WQ|WK")) {
					return true;
				} else {
					return false;
				}
			}
			else if (moveRow != 0) {
				return false;
			}
			else if (moveCol == 1) {
				if (board[Cmove[0] - 1][Cmove[1]].equals("")) {
					return true;
				} else {
					return false;
				}
			}
			else if (moveCol == 2) {
				if ((Cmove[0] == 7) && (board[Cmove[0] - 2][Cmove[1]].equals(""))) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean moveWR(String[][] board, int[] move) { // Start of Moving White Rook
		
		if (board[move[0]][move[1]].equals("WR")) {
			
			if (moveWRdiag(board, move)) {
				return false;
			}
			else if(moveWRrow(board, move)) {
				return true;
			}
			else if (moveWRcol(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWRdiag(String[][] board, int[] move) { // Moving the White Rook Diagonally
		
		int moveRow = move[3] - move[1];
		int moveCol = move[2] - move[0];
		
		if (((moveRow >= 1) && (moveCol >= 1)) || ((moveRow <= -1) && (moveCol <= -1)) || ((moveRow >= 1) && (moveCol <= -1)) || ((moveRow <= -1) && (moveCol >= 1))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveWRrow(String[][] board, int[] move) { // Moving White Rook Along the Row
		
		int Start = Math.min(move[2], move[0]);
		int End = Math.max(move[2], move[0]);
		int moveRow = move[2] - move[0];
		
		if (moveRow > 0) {
		
			for (int i = Start + 1; i < End; i++) {
				if (board[i][move[1]].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		}
		else if (moveRow < 0) {
			
			for (int i = End - 1; i > Start; i--) {
				if (board[i][move[1]].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		
		if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || (board[move[2]][move[3]].equals(""))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveWRcol(String[][] board, int[] move) { // Moving White Rook Along the Column
		
		int Start = Math.min(move[3], move[1]);
		int End = Math.max(move[3], move[1]);
		int moveCol = move[3] - move[1];
		
		if (moveCol > 0) {
		
			for (int i = Start + 1; i < End; i++) {
				if (board[move[0]][i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		}
		else if (moveCol < 0) {
			
			for (int i = End - 1; i > Start; i--) {
				if (board[move[0]][i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		
		if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || (board[move[2]][move[3]].equals(""))) {
			return true;
		} else {
			return false;
		}	
	}
	
	public static boolean moveBR(String[][] board, int[] Cmove) { // Start of Moving Black Rook
		
		if (board[Cmove[0]][Cmove[1]].equals("BR")) {
			
			if (moveBRdiag(board, Cmove)) {
				return false;
			}
			else if(moveBRrow(board, Cmove)) {
				return true;
			}
			else if (moveBRcol(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBRdiag(String[][] board, int[] Cmove) { // Moving the Black Rook Diagonally
		
		int moveRow = Cmove[3] - Cmove[1];
		int moveCol = Cmove[2] - Cmove[0];
		
		if (((moveRow >= 1) && (moveCol >= 1)) || ((moveRow <= -1) && (moveCol <= -1)) || ((moveRow >= 1) && (moveCol <= -1)) || ((moveRow <= -1) && (moveCol >= 1))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveBRrow(String[][] board, int[] Cmove) { // Moving Black Rook Along the Row
		
		int Start = Math.min(Cmove[2], Cmove[0]);
		int End = Math.max(Cmove[2], Cmove[0]);
		int moveRow = Cmove[2] - Cmove[0];
		
		if (moveRow > 0) {
		
			for (int i = Start + 1; i < End; i++) {
				if (board[i][Cmove[1]].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		}
		else if (moveRow < 0) {
			
			for (int i = End - 1; i > Start; i--) {
				if (board[i][Cmove[1]].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		
		if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || (board[Cmove[2]][Cmove[3]].equals(""))) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveBRcol(String[][] board, int[] Cmove) { // Moving Black Rook Along the Column
		
		int Start = Math.min(Cmove[3], Cmove[1]);
		int End = Math.max(Cmove[3], Cmove[1]);
		int moveCol = Cmove[3] - Cmove[1];
		
		if (moveCol > 0) {
		
			for (int i = Start + 1; i < End; i++) {
				if (board[Cmove[0]][i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		}
		else if (moveCol < 0) {
			
			for (int i = End - 1; i > Start; i--) {
				if (board[Cmove[0]][i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		
		if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || (board[Cmove[2]][Cmove[3]].equals(""))) {
			return true;
		} else {
			return false;
		}	
	}
	
	public static boolean moveWN(String[][] board, int[] move) { // Start of Moving White Knight
		
		if (board[move[0]][move[1]].equals("WN")) {
			
			if (moveWNUD(board, move)) {
				return true;
			}
			else if (moveWNLR(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWNUD(String[][] board, int[] move) { // White Knight Up - Down
		
		if ((move[2] == move[0] + 2) && (move[3] == move[1] + 1) || (move[3] == move[1] - 1)) { 
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			} else {
				return true;
			}
		}
		else if ((move[2] == move[0] - 2) && (move[3] == move[1] + 1) || (move[3] == move[1] - 1)) {
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWNLR(String[][] board, int[] move) { // White Knight Left - Right
		
		if ((move[3] == move[1] + 2) && (move[2] == move[0] + 1) || (move[2] == move[0] - 1)) { 
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			} else {
				return true;
			}
		}
		else if ((move[3] == move[1] - 2) && (move[2] == move[0] + 1) || (move[2] == move[0] - 1)) {
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBN(String[][] board, int[] Cmove) { // Start of Moving Black Knight
		
		if (board[Cmove[0]][Cmove[1]].equals("BN")) {
			if (moveBNUD(board, Cmove)) {
				return true;
			}
			else if (moveBNLR(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBNUD(String[][] board, int[] Cmove) { // Black Knight Up - Down
		
		if ((Cmove[2] == Cmove[0] + 2) && ((Cmove[3] == Cmove[1] + 1) || (Cmove[3] == Cmove[1] - 1))) { 
			if (board[Cmove[2]][Cmove[3]].matches("BP|BR|BN|BB|BQ|BK")) {
				return false;
			} else {
				return true;
			}
		}
		else if ((Cmove[2] == Cmove[0] - 2) && ((Cmove[3] == Cmove[1] + 1) || (Cmove[3] == Cmove[1] - 1))) {
			if (board[Cmove[2]][Cmove[3]].matches("BP|BR|BN|BB|BQ|BK")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBNLR(String[][] board, int[] Cmove) { // Black Knight Left - Right
		
		if ((Cmove[3] == Cmove[1] + 2) && (Cmove[2] == Cmove[0] + 1) || (Cmove[2] == Cmove[0] - 1)) { 
			if (board[Cmove[2]][Cmove[3]].matches("BP|BR|BN|BB|BQ|BK")) {
				return false;
			} else {
				return true;
			}
		} 
		else if ((Cmove[3] == Cmove[1] - 2) && (Cmove[2] == Cmove[0] + 1) || (Cmove[2] == Cmove[0] - 1)) {
			if (board[Cmove[2]][Cmove[3]].matches("BP|BR|BN|BB|BQ|BK")) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWB(String[][] board, int[] move) { // Start of Moving White Bishop
		
		if (board[move[0]][move[1]].equals("WB")) {
			
			if (moveWBHV(board, move)) {
				return false;
			} 
			else if (moveWDiag(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
		
	public static boolean moveWBHV(String[][] board, int[] move) { // White Bishop Horizontal - Vertical
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if ((moveRow == 0) || (moveCol == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveWDiag(String[][] board, int[] move) { // White Pieces Moving Diagonally
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		
		if ((Math.abs(numMovesR) == Math.abs(numMovesC))) {
			
			if (WhitPecUR(board, move)) {
				return true;
			} 
			else if (WhitpecUL(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean WhitPecUR(String[][] board, int[] move) { // White Peices Up - Right and Down - Left
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		int StartR = Math.min(move[2], move[0]);
		int EndR = Math.max(move[2], move[0]);
		int StartC = Math.min(move[3], move[1]);
		int EndC = Math.max(move[3], move[1]);
		
		if ((numMovesR > 0) && (numMovesC > 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[StartR + i][StartC + i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC < 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[EndR - i][EndC - i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean WhitpecUL(String[][] board, int[] move) { // White Pieces Up - Left and Down - Right
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		int StartR = Math.min(move[2], move[0]);
		int EndR = Math.max(move[2], move[0]);
		int StartC = Math.min(move[3], move[1]);
		int EndC = Math.max(move[3], move[1]);
		
		if ((numMovesR > 0) && (numMovesC < 0)) {
		
			for (int i = 1; i < Math.abs(numMovesR); i++) {
				if (board[StartR + i][EndC - i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
	
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC > 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[EndR - i][StartC + i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBB(String[][] board, int[] Cmove) { // Start of Moving Black Bishop
		
		if (board[Cmove[0]][Cmove[1]].equals("BB")) {
			
			if (moveBBHV(board, Cmove)) {
				return false;
			} 
			else if (moveBDiag(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
		
	public static boolean moveBBHV(String[][] board, int[] Cmove) { // Black Bishop Horizontal - Vertical
		
		int moveRow = Cmove[2] - Cmove[0];
		int moveCol = Cmove[3] - Cmove[1];
		
		if ((moveRow == 0) || (moveCol == 0)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveBDiag(String[][] board, int[] Cmove) { // Black Pieces Moving Diagonally
		
		int numMovesR = Cmove[2] - Cmove[0];
		int numMovesC = Cmove[3] - Cmove[1];
		
		if ((Math.abs(numMovesR) == Math.abs(numMovesC))) {
			
			if (BlacPecUR(board, Cmove)) {
				return true;
			} 
			else if (BlacpecUL(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean BlacPecUR(String[][] board, int[] Cmove) { // Black Pieces Moving Up - Right and Down - Left
		
		int numMovesR = Cmove[2] - Cmove[0];
		int numMovesC = Cmove[3] - Cmove[1];
		int StartR = Math.min(Cmove[2], Cmove[0]);
		int EndR = Math.max(Cmove[2], Cmove[0]);
		int StartC = Math.min(Cmove[3], Cmove[1]);
		int EndC = Math.max(Cmove[3], Cmove[1]);
		
		if ((numMovesR > 0) && (numMovesC > 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[StartR + i][StartC + i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || board[Cmove[2]][Cmove[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC < 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[EndR - i][EndC - i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || board[Cmove[2]][Cmove[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean BlacpecUL(String[][] board, int[] Cmove) { // Black Pieces Moving Up - Left and Down - Right
		
		int numMovesR = Cmove[2] - Cmove[0];
		int numMovesC = Cmove[3] - Cmove[1];
		int StartR = Math.min(Cmove[2], Cmove[0]);
		int EndR = Math.max(Cmove[2], Cmove[0]);
		int StartC = Math.min(Cmove[3], Cmove[1]);
		int EndC = Math.max(Cmove[3], Cmove[1]);
		
		if ((numMovesR > 0) && (numMovesC < 0)) {
		
			for (int i = 1; i < Math.abs(numMovesR); i++) {
				if (board[StartR + i][EndC - i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
	
			if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || board[Cmove[2]][Cmove[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC > 0)) {
				
			for (int i = 1; i < Math.abs(numMovesC); i++) {
				if (board[EndR - i][StartC + i].equals("")) {
					continue;
				} else {
					return false;
				}
			}
		
			if ((board[Cmove[2]][Cmove[3]].matches("WP|WR|WN|WB|WQ|WK")) || board[Cmove[2]][Cmove[3]].equals("")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWQ(String[][] board, int[] move) { // Start of Moving White Queen
		
		if (board[move[0]][move[1]].equals("WQ")) {
			
			if (moveWDiag(board, move)) {
				return true;
			} 
			else if (moveWQHV(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}	
	
	public static boolean moveWQHV(String[][] board, int[] move) { // White Queen Horizontal - Vertical
		
		if (moveWRdiag(board, move)) {
			return false;
		} 
		else if(moveWRrow(board, move)) {
			return true;
		} 
		else if (moveWRcol(board, move)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveBQ(String[][] board, int[] Cmove) { // Start of Moving Black Queen
		
		if (board[Cmove[0]][Cmove[1]].equals("BQ")) {
			
			if (moveBDiag(board, Cmove)) {
				return true;
			} 
			else if (moveBQHV(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}	
	
	public static boolean moveBQHV(String[][] board, int[] Cmove) { // Black Queen Horizontal - Vertical
		
		if (moveBRdiag(board, Cmove)) {
			return false;
		} 
		else if(moveBRrow(board, Cmove)) {
			return true;
		} 
		else if (moveBRcol(board, Cmove)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean moveWK(String[][] board, int[] move) { // Start of Moving White King
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if (board[move[0]][move[1]].equals("WK")) {
			
			if ((Math.abs(moveRow) <= 1) && (Math.abs(moveCol) <= 1)) {
				
				if (moveWDiag(board, move)) {
					return true;
				} 
				else if (moveWKHV(board, move)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveWKHV(String[][] board, int[] move) { // White King Horizontal - Vertical
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if (moveCol == 0) {
			if(moveWRrow(board, move)) {
				return true;
			} else {
				return false;
			}
		} 
		else if (moveRow == 0) {
			if (moveWRcol(board, move)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBK(String[][] board, int[] Cmove) { // Start of Moving Black King
		
		int moveRow = Cmove[2] - Cmove[0];
		int moveCol = Cmove[3] - Cmove[1];
		
		if (board[Cmove[0]][Cmove[1]].equals("BK")) {
			
			if ((Math.abs(moveRow) <= 1) && (Math.abs(moveCol) <= 1)) {
				if (moveBDiag(board, Cmove)) {
					return true;
				} 
				else if (moveBKHV(board, Cmove)) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public static boolean moveBKHV(String[][] board, int[] Cmove) { // Black King Horizontal - Vertical
		
		int moveRow = Cmove[2] - Cmove[0];
		int moveCol = Cmove[3] - Cmove[1];
		
		if (moveCol == 0) {
			if(moveBRrow(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} 
		else if (moveRow == 0) {
			if (moveBRcol(board, Cmove)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
