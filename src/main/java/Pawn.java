package main.java;

/**
 * Created by Coen on 23-6-2017.
 */
public class Pawn extends Piece {

    public Pawn(int id, int row, int column, boolean white) {
        super(id, row, column, white);
    }

    public String toString() {
        String color = (white) ? "W" : "B";
        return color + "[Pawn]" + id;
    }

}
