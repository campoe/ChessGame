package main.java;

/**
 * Created by Coen on 23-6-2017.
 */
public class Rook extends Piece {

    public Rook(int id, int row, int column, boolean white) {
        super(id, row, column, white);
    }

    public String toString() {
        String color = (white) ? "W" : "B";
        return color + "[Rook]" + id;
    }

}
