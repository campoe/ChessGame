package main.java;

/**
 * Created by Coen on 23-6-2017.
 */
public class Piece {

    protected int id;
    protected int kills;
    protected boolean alive;
    protected boolean white;

    public Piece(int id, int row, int column, boolean white) {
        this.id = id;
        this.kills = 0;
        this.alive = true;
        this.white = white;
        Board.getInstance().getCells()[column + row * Board.ROW_COUNT].occupy(this);
    }

    public boolean validateMove(Board board, int fromX, int fromY, int toX, int toY) {
        if (toX == fromX && toY == fromY) {
            return false;
        }
        if (toX < 0 || toX >= Board.COLUMN_COUNT || fromX < 0 || fromX >= Board.COLUMN_COUNT || toY < 0 || toY >= Board.ROW_COUNT || fromY < 0 || fromY >= Board.ROW_COUNT) {
            return false;
        }
        return true;
    }

    public void kill() {
        this.alive = false;
    }

    public void incrementKills() {
        this.kills++;
    }

    public boolean canBeCaptured() {
        // TODO
        return false;
    }

    public int getId() {
        return id;
    }
    public int getKills() {
        return kills;
    }
    public void setKills(int kills) {
        this.kills = kills;
    }
    public boolean isAlive() {
        return alive;
    }

}
