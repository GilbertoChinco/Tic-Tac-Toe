import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Board gameBoard = new Board();
        char player = 'O';

        char[][] board = gameBoard.getGameBoard();
        gameBoard.printBoard();

        for(int i = 0; i < 3; i++){
            System.out.println("Please enter the column and row of your move (Example: A1)");
            String move = input.nextLine();
            System.out.println("Player move (O): " + move);
            gameBoard.submitMove(move, player);
            gameBoard.printBoard();
        }
        gameBoard.isWinner(player);
        input.close();
    }
}
