package lab7;

public class Token{
    private int value;

    public Token(int token) {
        this.value = token;
    }

    public int getTokenValue() {
        return value;
    }

    public void setValue(int token) {
        this.value = token;
    }

    @Override
    public String toString() {
        return "token number " + value;
    }
}