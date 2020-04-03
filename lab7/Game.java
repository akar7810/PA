package lab7;

import java.util.LinkedList;

public class Game {
    private int nrTokens;
    private LinkedList<Player> players = new LinkedList<Player>();
    private Board board;

    public Game(int nrTokens, LinkedList<Player> players, Board board) {
        this.nrTokens = nrTokens;
        this.players = players;
        this.board = board;
    }

    public void play() {
    	int i = 1;
        for (Player player: players) {
        	player.setTurn(i);
            new Thread(player).start();
            i++;

        }
    }

    @Override
    public String toString() {
        return "Game: " + "Total number of tokens=" + nrTokens + ", \nPlayers = " + players + "\n" + board;
    }
}
