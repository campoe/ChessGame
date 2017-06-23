package main.java;

/**
 * Created by Coen on 23-6-2017.
 */
public class Cell {

    private int row;
    private int column;
    private Piece piece;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
    }

    public void occupy(Piece piece) {
        if (isOccupied()) {
            this.piece.kill();
        }
        this.piece = piece;
    }

    public Piece release() {
        Piece res = this.piece;
        this.piece = null;
        return res;
    }

    public boolean isOccupied() {
        return this.piece != null;
    }

    public String toString() {
        if (!isOccupied()) {
            return "EMPTY";
        }
        return this.piece.toString();
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

}
