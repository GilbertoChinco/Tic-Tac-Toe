class TicTacToe {

    Board gameBoard = new Board();
    Player player1 = new Player(true, 'O');
    Player player2 = new Player(true, 'X');
    int playerMoves = 0;

    TicTacToe(){
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

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
    }
}
