/*this a ticktactoe game 
single player in which you play against the computer
where player is 'X' and the computer is 'O'*/
package bond;
import java.util.Random;//for compter we are generating random numbers
import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		again( scan);//shift+alt+m
		scan.close();//shift+alt+m
	}

	private static void again( Scanner scan) {
		char[][] board = { { ' ', ' ', ' ', }, { ' ', ' ', ' ', }, { ' ', ' ', ' ', } };
		System.out.println("TicTacToe\nWill you like to play?");
		System.out.println("Press 1 to play."); 
		int a = scan.nextInt();
		if(a==1)
		{
			play(scan, board); 
		}
		else
		{
			System.out.println("Thank you,"); 
		}
	}

	private static void play(Scanner scan, char[][] board) {
		while (true) {
			playerMove(scan, board);
			if (gameFinished(board)) {
				break;
			}
			printBoard(board);

			computerTurn(board);
			if (gameFinished(board)) {
				break;
			}
		}
		again( scan);
	}

	private static void playerMove(Scanner scan, char[][] board) {
		String userInput;

		while (true) {
			printBoard(board);
			System.out.println("Enter your play(1-9)"); 
			userInput = scan.nextLine();

			if (isValidMove(board, userInput)) {
				break;
			} else {
				System.out.println("not a valid move");  
			}
		}
		placeMove(board, userInput, 'X');
	}

	private static void placeMove(char[][] board, String position, char symbol) {
		switch (position) {
		case "1":
			board[0][0] = symbol;
			break;
		case "2":
			board[0][1] = symbol;
			break;
		case "3":
			board[0][2] = symbol;
			break;
		case "4":
			board[1][0] = symbol;
			break;
		case "5":
			board[1][1] = symbol;
			break;
		case "6":
			board[1][2] = symbol;
			break;
		case "7":
			board[2][0] = symbol;
			break;
		case "8":
			board[2][1] = symbol;
			break;
		case "9":
			board[2][2] = symbol;
			break;
		default:
			System.out.println(":(");
		}
		isValidMove(board, position);
	}

	private static boolean gameFinished(char[][] board) {
		if (hasContestantWon(board, 'X')) {
			printBoard(board);
			System.out.println("Congratulations\nplayer won");
			return true;
		}
		if (hasContestantWon(board, 'O')) {		
			printBoard(board);
			System.out.println("Woops\ncomputer has won"); 
			return true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == ' ') {
					return false;
				}
			}
		}	printBoard(board);
		System.out.println("game tie"); 
		return true;
	}

	private static boolean hasContestantWon(char[][] board, char symbol)
	{
		if ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol)
				|| (board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol)
				|| (board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol)
				|| (board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol)
				|| (board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol) ||

				(board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
				|| (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol)) {
			return true;
		}
		return false;
	}
	private static void computerTurn(char[][] board)
	{
		int computerMove;
		Random rand = new Random();
		while(true)
		{
		computerMove = rand.nextInt(10);
		if(isValidMove(board, Integer.toString(computerMove)))
				{
			break;
				}
		}
		placeMove(board, Integer.toString(computerMove), 'O');
		System.out.println("Computer move is: " + computerMove);
	}

	public static boolean isValidMove(char[][] board, String position) {
		switch (position) {
		case "1":
			return (board[0][0] == ' ');
		case "2":
			return (board[0][1] == ' ');
		case "3":
			return (board[0][2] == ' ');
		case "4":
			return (board[1][0] == ' ');
		case "5":
			return (board[1][1] == ' ');
		case "6":
			return (board[1][2] == ' ');
		case "7":
			return (board[2][0] == ' ');
		case "8":
			return (board[2][1] == ' ');
		case "9":
			return (board[2][2] == ' ');
		default:
			return false;
		}
	}
private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]); 
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]); 
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]); 
	}

}
