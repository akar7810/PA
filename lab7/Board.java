package lab7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {
    private LinkedList<Token> tokens = new LinkedList<Token>();
    private int nrTokens;
    private volatile boolean noWinner = true;
    private volatile boolean empty = false;
    int k;
    public Board(int n,int k) {
    	int i;
        for (i = 1; i <= n; i++) {
            Token t = new Token(i);
            this.tokens.add(t);
        }
        this.nrTokens = i-1;
        this.k=k;
    }

    public synchronized Token getToken(int playerTurn) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (tokens.isEmpty()==false) {
            Token t;
            t = tokens.getFirst();
            tokens.removeFirst();
            notifyAll();
            System.out.println("Player " + playerTurn + " picked the " + t);
            return t;
        }
        noWinner = false;
        empty = true;
        notifyAll();
        System.out.println("All tokens were used and nobody won!");
        return null;
    }

    public synchronized void win(List<Token> tokens,int playerTurn){
        noWinner = false;
        empty = true;
        notifyAll();
        System.out.println("Player " + playerTurn + " won the game with these tokens" + tokens);
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized boolean isNoWinner() {
        return noWinner;
    }

    public int getNrTokens() {
        return nrTokens;
    }
    @Override
    public String toString() {
        return "Board tokens : " + tokens;
    }
}