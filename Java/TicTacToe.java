import java.util.Scanner;

class TicTacToe {

    Scanner input = new Scanner(System.in);
    Board gameBoard = new Board();
    Player player1 = new Player(true, 'O');
    Player player2 = new Player(true, 'X');
    int playerMoves = 0;

    TicTacToe(){
        this.start();
        this.end();
    }
    
    void start(){
        while(true){
            System.out.println("Would you like to play?: ");
            String start = input.nextLine();
            if(start.equals("yes")){break;}
        }
        this.play();
    }

    void end(){
        System.out.println("The game has ended");
    }

    void play(){
        gameBoard.printBoard();
        while(this.playerMoves < 10){

            this.submitPlayerMove(player1.marker);
            if(this.isGameOver(player1.marker)){this.printFinalMessage(player1.marker); break;}
            if(this.isaTie()){break;}
        
            this.submitPlayerMove(player2.marker);
            if(this.isGameOver(player2.marker)){this.printFinalMessage(player2.marker); break;}
            if(this.isaTie()){break;}
        }
    }

    void submitPlayerMove(char player){
        gameBoard.askPlayerMove(player);
        gameBoard.printBoard();
        this.playerMoves++;
    }

    boolean isGameOver(char player){
        boolean isOver = false;
        if(gameBoard.isWinner(player)){
            isOver = true;
        }
        return isOver;
    }

    boolean isaTie(){
        boolean isTie = false;
        if(this.playerMoves == 9){
            System.out.println("Draw");
            isTie = true;
        }
        return isTie;
    }

    void printFinalMessage(char player){
        System.out.println("GAME OVER!");
        System.out.println("The winner is " + player + "!!!!");
    }

}
