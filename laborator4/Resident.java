package laborator4;

import java.util.List;
import java.util.Queue;

public class Resident {

    private String number;
    private String name;

    public Resident(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " " + name + " ";
    }
}