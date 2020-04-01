import java.util.Scanner;
import java.util.Random;
public class TicTacToe {

	public static final int ROW = 3;
	public static final int COL = 3;
	public static char[][] board = new char[ROW][COL];
	public static int turn = 9;
	
	
	public static void printBoard(){
        System.out.println("       " +board[0][0] + "   " +  "|"+ "   " + board[0][1] + "   " + "|" + "   " +board[0][2] );
        System.out.println("    -------+-------+-------");
        System.out.println("       " +board[1][0] + "   " +  "|"+ "   " + board[1][1] + "   " + "|" + "   " +board[1][2] );
        System.out.println("    -------+-------+-------");
        System.out.println("       " +board[2][0] + "   " +  "|"+ "   " + board[2][1] + "   " + "|" + "   " +board[2][2] );
		System.out.println("\n");
	}
	
	public static void playerMove() {
		int row = 0;
		int col = 0;
		Scanner input = new Scanner(System.in);
		System.out.print("Player, please pick a row from 1 - 3: ");
		row = input.nextInt();
		System.out.print("Player, please pick a column from 1 - 3: ");
		col = input.nextInt();
		
		if ((row <= 3 && col <= 3 ) && board[row - 1][col - 1] != 'x' && board[row - 1][col - 1] != 'o' && board[row - 1][col - 1] == '-'){
			board[row - 1][col - 1] = 'x';
			turn--;
			printBoard();
		}
		else if (row > 3 || col > 3){
			System.out.println("Please pick a number between 1 - 3");
		}
		else{
			System.out.println("This spot is taken or not valid, please pick a different one.");
		}
	}
	
	public static void computerMove() {
		System.out.println("Now it is the computer's move.");
		int row = 0;
		int col = 0;
		Random rand = new Random();
		row = rand.nextInt(3);
		col = rand.nextInt(3);
		if (board[row][col] != 'o' && board[row][col] != 'x' && board[row][col] == '-'){
			board[row][col] = 'o';
			turn--;
			printBoard();
		}
		else {
			System.out.println("Oops, the computer picked a taken spot, trying again.");
		}
	}
	public static void gameTurn(){
		if (turn  % 2 == 0 || turn == 0){
			computerMove();
		}
		else{
			playerMove();
		}
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < ROW; i++){
			for (int j = 0; j < COL; j++){
				board[i][j] = (char)('-');
			}
		}
		printBoard();
		while (turn > 0){
			gameTurn();
			if (turn == 0){
				System.out.println("This game is a tie, there is no winner. Thanks for playing.");
				System.exit(0);
			}
		}
		
		
	}

}
