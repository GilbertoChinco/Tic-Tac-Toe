import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Board{

    char[][] gameBoard = new char[3][3];
    ArrayList<String> positions = new ArrayList<>(Arrays.asList("A1", "A2", "A3", "B1", "B2", "B3", "C1", "C2", "C3"));


    Board(){
        this.initializeEmptyBoard();
    }


    void initializeEmptyBoard(){
        for(int j = 0; j < 3; j++){
            for(int i = 0; i < 3; i++){
                this.gameBoard[j][i] = ' ';
            }
        }
    }


    char[][] getGameBoard(){
        return this.gameBoard;
    }


    void printBoard(){
        System.out.println("   | 1 | 2 | 3 |");
        System.out.println("---.---.---.---.");
        System.out.println(" A | " + this.gameBoard[0][0] +" | " + this.gameBoard[0][1] + " | " + this.gameBoard[0][2] + " |");
        System.out.println("---.---.---.---.");
        System.out.println(" B | " + this.gameBoard[1][0] +" | " + this.gameBoard[1][1] + " | " + this.gameBoard[1][2] + " |");
        System.out.println("---.---.---.---.");
        System.out.println(" C | " + this.gameBoard[2][0] +" | " + this.gameBoard[2][1] + " | " + this.gameBoard[2][2] + " |");
        System.out.println("////////////////");
    }

    void askPlayerMove(char player){
        Scanner input = new Scanner(System.in);
        String temporalMove;
        do{
            System.out.println("Player (" + player + ") move");
            System.out.println("Please enter the column and row of your move (Example: A1)");
            temporalMove = input.nextLine();
        }
        while(!this.submitMove(temporalMove, player));
    }   


    boolean submitMove(String move, char player){
        boolean isMoveDone;
        //Iterate over all the position and if the positions is found it then delete it
        if(this.isMoveValid(move)){
            int[] coordenatesMove = this.getCoordenates(move);
            int row = coordenatesMove[0];
            int column = coordenatesMove[1];
            this.gameBoard[row][column] = player;
            this.positions.remove(move);
            isMoveDone = true;
        }
        else{
            System.out.println("Invalid input: Please enter the column and row of your move (Example: A1)");
            isMoveDone = false;
        }
        return isMoveDone;
    }


    boolean isMoveValid(String move){
        boolean isValid = false;
        for(String position: this.positions){
            if (position.equals(move)){
                isValid = true;
            }
        }
        return isValid;
    }


    int[] getCoordenates(String move){
        //Move Example (A1) --> First letter = row 'A', Second letter = Column '1'

        char letterRow = move.charAt(0);
        char letterColumn = move.charAt(1);

        int row = this.getNumberRow(letterRow);
        int column = this.getNumberColumn(letterColumn);

        int[] coordenates = new int[2];
        coordenates[0] = row;
        coordenates[1] = column;
        return coordenates;
    }


    int getNumberRow(char letter){
        int row = 0;
        if (letter == 'A'){row = 0;}
        else if (letter == 'B'){row = 1;}
        else if (letter == 'C'){row = 2;}
        return row;
    }


    int getNumberColumn(char letter){
        int column = 0;
        if (letter == '1'){column = 0;}
        else if (letter == '2'){column = 1;}
        else if (letter == '3'){column = 2;}
        return column;
    }

    boolean isWinner(char player){
        boolean isWinner = false;
        char[][] matrix_position = this.gameBoard;

        //horizontals
        if(matrix_position[0][0] == player && matrix_position[0][1] == player && matrix_position[0][2] == player){isWinner = true;}
        else if(matrix_position[1][0] == player && matrix_position[1][1] == player && matrix_position[1][2] == player){isWinner = true;}
        else if(matrix_position[2][0] == player && matrix_position[2][1] == player && matrix_position[2][2] == player){isWinner = true;}

        //Verticals
        else if(matrix_position[0][0] == player && matrix_position[1][0] == player && matrix_position[2][0] == player){isWinner = true;}
        else if(matrix_position[0][1] == player && matrix_position[1][1] == player && matrix_position[2][1] == player){isWinner = true;}
        else if(matrix_position[0][2] == player && matrix_position[1][2] == player && matrix_position[2][2] == player){isWinner = true;}

        //Diagonals
        else if(matrix_position[0][0] == player && matrix_position[1][1] == player && matrix_position[2][2] == player){isWinner = true;}
        else if(matrix_position[0][2] == player && matrix_position[1][1] == player && matrix_position[2][0] == player){isWinner = true;}

        return isWinner;
    }

}