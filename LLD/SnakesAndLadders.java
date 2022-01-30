
class SnakesAndLadders{
    List<Board> boardList;
    Board board;


    public static void main(String[] args) {
        Game game = new Game();
        Player p1 = new Player();
        Player p2 = new Player();
        Board board = game.getBoard();
    }
}

class Admin{
    addBoards();
}

class Player{
    long playerId;
    String name;
    int wins, losses, draws;
    int position;
    int row, col;

    Player(){

    }
}

class Game{
    long gameId;
    Player player1;
    Player player2;
    long boardId;


}

class Board{
    int count;
    HashMap<String, String> ladderMap;
    HashMap<String, String> snakeMap;
    long boardId;
    int currentPlayer;

    getDiceRoll(){
        return 6*Math.random();
    }

    makeMove(Player player){
        player.position += getDiceRoll(); // 1<=6
    }

    getRow(int number){
        return number/10 +1;
    }

    getCol(int number){
        return row %2 == 0?number%10
    }
    checkWinner();
    getBoard();
    checkForSnakes();
    checkForLadders();
}

/**
 * in these cases when the game needs to be mapped to the board, no need to have a
 * class variable, rather store a board id inside the Game class like a foreign key
 *
 * **always think in terms of schema design
 *
 * game -> game id, player1 id, player2 id, winner, boardId
 * player -> player id, name, wins, losses, draws
 * board -> board id, ladderMap, snakeMap
 * */