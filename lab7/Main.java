package lab7;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Player> players = new LinkedList<Player>();

        Board board = new Board(10,3);
        Player p1 = new Player("Abdrei", board);
        Player p2 = new Player("Vasile", board);

        players.add(p1);
        players.add(p2);
        Game game = new Game(board.getNrTokens(), players, board);
        System.out.println(game);
        game.play();
    }
}