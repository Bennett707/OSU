import java.util.*;

public class GameBoard {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Random rand = new Random();
		
		String[][] board = setupboard();
		
		while (gameIsNotOver(board)) {
			printBoard(board);
			int[] move = getUserInput(scnr);
			
			if (isLegalW(board, move)) {
				updateBoard(board, move);
			} 
			else {
				System.out.println("That is not a legal move. Try again. :)");
				continue;
			}
			int[] Cmove = CompInput(rand);
			makeComputerMove(board, Cmove);
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
	
	public static boolean gameIsNotOver(String[][] board) {
		
		if ((WKST(board) == true) && (BKST(board) == true)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static String whoWon(String[][] board) {
		
		if (WKST(board) == false) {
			return "Checkmate, I Win!! :)";
		}
		else if (BKST(board) == false) {
			return "Checkmate, You Win... :(";
		}
		else {
			return "";
		}
	}
	
	public static boolean WKST(String[][] board) { //checking to see if the White King is still on the board
		
		for (int i = 1; i < board.length; i--) {
			for (int j = 1; j < board[i].length; j++) {
				
				if (board[i][j].equals("WK")) {
					return true;
				}
				else {
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
				}
				else {
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
	
	public static int[] getUserInput(Scanner scnr) {
		System.out.print("Enter Move (<Start Row> < Start Col> <End Row> <End Col>): ");
		 
		int[] userVal = new int[4];
		for (int i = 0; i < userVal.length; i++) {
			userVal[i] = scnr.nextInt();
		}
		return userVal;
	}
	
	public static boolean isLegalW(String[][] board, int[] move) {
		
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
			}
			else {
				return false;
			}
			
		}
		else {
			return false;
		}
	}
	
	public static boolean isLegalB(String[][] board, int[] Cmove) {
		
		/*if (moveBP(board, Cmove)) {
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
		}
		else {
			return false;
		}*/
		return true;
	}
	
	public static void updateBoard(String[][] board, int[] move) {
		
		board[move[2]][move[3]] = board[move[0]][move[1]];
		board[move[0]][move[1]] = "";
	}
	
	public static void makeComputerMove(String[][] board, int[] Cmove) {
		

		
		while (gameIsNotOver(board)) {
			
			
			if (board[Cmove[0]][Cmove[1]].matches("BP|BR|BN|BB|BQ|BK")) {
				if (isLegalB(board, Cmove)) {
					board[Cmove[2]][Cmove[3]] = board[Cmove[0]][Cmove[1]];
					board[Cmove[0]][Cmove[1]] = "";
					break;
				}
				else {
					continue;
				}
			}
			else {
				continue;
			}
		}
	}
	
	public static int[] CompInput(Random rand) {
		
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
				}
				else {
					return false;
				}
			}
			else if ((moveRow == - 1) && (moveCol == 1)) {
				if (board[move[0] + 1][move[1] - 1].matches("BP|BR|BN|BB|BQ|BK")) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (moveRow != 0) {
				return false;
			}
			else if (moveCol == 1) {
				if (board[move[0] + 1][move[1]].equals("")) {
					return true;
				}
				else {
					return false;
				}
			}
			else if (moveCol == 2) {
				if ((move[0] == 2) && (board[move[0] + 2][move[1]].equals(""))) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		} 
		else {
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
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWRdiag(String[][] board, int[] move) {
		
		int moveRow = move[3] - move[1];
		int moveCol = move[2] - move[0];
		
		if (((moveRow >= 1) && (moveCol >= 1)) || ((moveRow <= -1) && (moveCol <= -1)) || ((moveRow >= 1) && (moveCol <= -1)) || ((moveRow <= -1) && (moveCol >= 1))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWRrow(String[][] board, int[] move) {
		
		int Start = Math.min(move[2], move[0]);
		int End = Math.max(move[2], move[0]);
		int moveRow = move[2] - move[0];
		
		if (moveRow > 0) {
		
			for (int i = Start + 1; i < End; i++) {
			
				if (board[i][move[1]].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else if (moveRow < 0) {
			
			for (int i = End - 1; i >= Start; i--) {
			
				if (board[i][move[1]].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		if ((board[move[2]][move[3]].matches("BP|BN|BB|BQ|BK")) || (board[move[2]][move[3]].equals(""))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWRcol(String[][] board, int[] move) {
		
		int Start = Math.min(move[3], move[1]);
		int End = Math.max(move[3], move[1]);
		int moveCol = move[3] - move[1];
		
		if (moveCol > 0) {
		
			for (int i = Start + 1; i < End; i++) {
			
				if (board[move[0]][i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else if (moveCol < 0) {
			
			for (int i = End - 1; i >= Start; i--) {
			
				if (board[move[0]][i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
		
		if ((board[move[2]][move[3]].matches("BP|BN|BB|BQ|BK")) || (board[move[2]][move[3]].equals(""))) {
			return true;
		}
		else {
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
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWNUD(String[][] board, int[] move) {
		
		if ((move[2] == move[0] + 2) && (move[3] == move[1] + 1) || (move[3] == move[1] - 1)) { 
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			}
			else {
				return true;
			}
		}
		else if ((move[2] == move[0] - 2) && (move[3] == move[1] + 1) || (move[3] == move[1] - 1)) {
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWNLR(String[][] board, int[] move) {
		
		if ((move[3] == move[1] + 2) && (move[2] == move[0] + 1) || (move[2] == move[0] - 1)) { 
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			}
			else {
				return true;
			}
		}
		else if ((move[3] == move[1] - 2) && (move[2] == move[0] + 1) || (move[2] == move[0] - 1)) {
			if (board[move[2]][move[3]].matches("WP|WR|WN|WB|WQ|WK")) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWB(String[][] board, int[] move) { // Start of Moving White Bishop
		
		if (board[move[0]][move[1]].equals("WB")) {
			
			if (moveWBHV(board, move)) {
				return false;
			}
			else if (moveDiag(board, move)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
		
	public static boolean moveWBHV(String[][] board, int[] move) {
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if ((moveRow == 0) || (moveCol == 0)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean moveDiag(String[][] board, int[] move) {
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		
		if ((Math.abs(numMovesR) == Math.abs(numMovesC))) {
			
			if (WhitPecUR(board, move)) {
				return true;
			}
			else if (WhitpecUL(board, move)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean WhitPecUR(String[][] board, int[] move) {
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		int StartR = Math.min(move[2], move[0]);
		int EndR = Math.max(move[2], move[0]);
		int StartC = Math.min(move[3], move[1]);
		int EndC = Math.max(move[3], move[1]);
		
		if ((numMovesR > 0) && (numMovesC > 0)) {
				
			for (int i = 1; i <= Math.abs(numMovesC); i++) {
				
				if (board[StartR + i][StartC + i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			}	
			else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC < 0)) {
				
			for (int i = 1; i <= Math.abs(numMovesC); i++) {
				
				if (board[EndR - i][EndC - i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			}	
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean WhitpecUL(String[][] board, int[] move) {
		
		int numMovesR = move[2] - move[0];
		int numMovesC = move[3] - move[1];
		int StartR = Math.min(move[2], move[0]);
		int EndR = Math.max(move[2], move[0]);
		int StartC = Math.min(move[3], move[1]);
		int EndC = Math.max(move[3], move[1]);
		
		if ((numMovesR > 0) && (numMovesC < 0)) {
		
			for (int i = 1; i <= Math.abs(numMovesR); i++) {
			
				if (board[StartR + i][EndC - i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
	
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			}	
			else {
				return false;
			}
		}
		else if ((numMovesR < 0) && (numMovesC > 0)) {
				
			for (int i = 1; i <= Math.abs(numMovesC); i++) {
				
				if (board[EndR - i][StartC + i].equals("")) {
					continue;
				}
				else {
					return false;
				}
			}
		
			if ((board[move[2]][move[3]].matches("BP|BR|BN|BB|BQ|BK")) || board[move[2]][move[3]].equals("")) {
				return true;
			}	
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWQ(String[][] board, int[] move) { // Start of Moving White Queen
		
		if (board[move[0]][move[1]].equals("WQ")) {
			
			if (moveDiag(board, move)) {
				return true;
			}
			else if (moveWQHV(board, move)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}	
	
	public static boolean moveWQHV(String[][] board, int[] move) {
		
		if (moveWRdiag(board, move)) {
			return false;
		}
		else if(moveWRrow(board, move)) {
			return true;
		}
		else if (moveWRcol(board, move)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWK(String[][] board, int[] move) { // Start of Moving White King
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if (board[move[0]][move[1]].equals("WK")) {
			
			if ((Math.abs(moveRow) <= 1) && (Math.abs(moveCol) <= 1)) {
				
				if (moveDiag(board, move)) {
					return true;
				} 
				else if (moveWKHV(board, move)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public static boolean moveWKHV(String[][] board, int[] move) {
		
		int moveRow = move[2] - move[0];
		int moveCol = move[3] - move[1];
		
		if (moveCol == 0) {
			if(moveWRrow(board, move)) {
				return true;
			}
			else {
				return false;
			}
		}
		else if (moveRow == 0) {
			if (moveWRcol(board, move)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}	
}