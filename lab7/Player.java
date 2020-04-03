package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private int myTurn;
    private final Board board;
    private List<Token> tokens = new ArrayList<>();
    private volatile boolean exit = false;

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

	public int getTurn() {
        return myTurn;
    }

    public void setTurn(int turn) {
        this.myTurn = turn;
    }

    @Override
    public void run() {
        while (board.isNoWinner()) {
            if (!board.isEmpty()) {
                Token t = board.getToken(myTurn);
                tokens.add(t);
                if (tokens.size() >= board.k) {
                    boolean winner = true;
                    int difference = tokens.get(1).getTokenValue() - tokens.get(0).getTokenValue();
                    //^ beware that this breaks when k is 1 because of get(0)
                    for (int i = 2; i < tokens.size(); i++)
                        if ((tokens.get(i).getTokenValue() - tokens.get(i-1).getTokenValue()) != difference) {
                            winner = false;
                            break;
                        }
                    if (winner)
                        board.win(tokens, myTurn);
                }

            }

        }
        
    }
    public void stop(){
        exit = true;
    }
    @Override
    public String toString() {
        return "Player = '" + name + '\'';
    }
}