package pieces;

import game.*;

import java.util.Collection;

/**
 * Created by Coen on 23-6-2017.
 */
public abstract class Piece {

    protected int id;
    protected int kills;
    protected boolean alive;
    protected Alliance alliance;
    protected Cell position;
    protected boolean firstMove;

    public Piece(int id, int row, int column, Alliance alliance) {
        this.id = id;
        this.kills = 0;
        this.alive = true;
        this.alliance = alliance;
        this.firstMove = true;
        Board.getInstance().getCells()[Board.index(row, column)].occupy(this);
    }

    public boolean validateMove(int fromColumn, int fromRow, int toColumn, int toRow) {
        if (toColumn == fromColumn && toRow == fromRow) {
            return false;
        }
        if (toColumn < 0 || toColumn >= Board.COLUMN_COUNT || fromColumn < 0 || fromColumn >= Board.COLUMN_COUNT || toRow < 0 || toRow >= Board.ROW_COUNT || fromRow < 0 || fromRow >= Board.ROW_COUNT) {
            return false;
        }
        return true;
    }

    public boolean validateMove(Cell fromCell, Cell toCell) {
        return validateMove(fromCell.getColumn(), fromCell.getRow(), toCell.getColumn(), toCell.getRow());
    }

    public boolean validateMove(int fromIndex, int toIndex) {
        if (fromIndex == toIndex) {
            return false;
        }
        if (fromIndex < 0 || fromIndex >= Board.CELL_COUNT || toIndex < 0 || toIndex >= Board.CELL_COUNT) {
            return false;
        }
        return true;
    }

    public abstract Collection<Move> legalMoves();

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
    public void setPosition(Cell position) {
        this.position = position;
    }
    public Cell getPosition() {
        return position;
    }
    public Alliance getAlliance() {
        return alliance;
    }
    public boolean isFirstMove() {
        return firstMove;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public void setFirstMove(boolean firstMove) {
        this.firstMove = firstMove;
    }

}
