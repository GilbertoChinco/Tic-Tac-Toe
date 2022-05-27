class Player {
    
    char marker;
    boolean isHuman;

    Player(){
        this.marker = 'X';
        this.isHuman = true;
    }

    Player(boolean inIsHuman){
        this.isHuman = inIsHuman;
        if (inIsHuman){this.marker = 'X';}
        else{this.marker = 'O';}
    }

    Player(boolean inIsHuman, char inMarker){
        this.isHuman = inIsHuman;
        this.marker = Character.toUpperCase(inMarker);
    }

    char getMarker(){
        return this.marker;
    }

    boolean getIsHuman(){
        return this.isHuman;
    }

    
}