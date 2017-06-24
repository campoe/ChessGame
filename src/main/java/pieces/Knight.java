package pieces;

import game.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Knight extends Piece {

    private static final int[] DELTAS = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        int coordinate;
        List<Move> moves = new ArrayList<>();
        for (int delta : DELTAS) {
            coordinate = this.position.getColumn() + this.position.getRow() * Board.ROW_COUNT + delta;
            if (super.validateMove(this.position.getColumn() + this.position.getRow() * Board.ROW_COUNT, coordinate)) {
                if (isFirstColumn(this.position, delta) || isSecondColumn(this.position, delta) || isSeventhColumn(this.position, delta) || isEightColumn(this.position, delta)) {
                    continue;
                }
                Cell cell = Board.getInstance().getCell(coordinate);
                if (!cell.isOccupied()) {
                    moves.add(new Move(this, coordinate));
                } else {
                    Piece piece = cell.getPiece();
                    Alliance alliance = piece.getAlliance();
                    if (this.alliance != alliance) {
                        moves.add(new Move(this, coordinate, piece));
                    }
                }
            }
        }
        return moves;
    }

    public boolean isFirstColumn(Cell cell, int delta) {
        int position = cell.getColumn() + cell.getRow() * Board.ROW_COUNT;
        return (position % 8 == 0) && (delta == -17 || delta == -10 || delta == 6 || delta == 15);
    }

    public boolean isSecondColumn(Cell cell, int delta) {
        int position = cell.getColumn() + cell.getRow() * Board.ROW_COUNT;
        return (position % 8 == 1) && (delta == -10 || delta == 6);
    }

    public boolean isSeventhColumn(Cell cell, int delta) {
        int position = cell.getColumn() + cell.getRow() * Board.ROW_COUNT;
        return (position % 8 == 6) && (delta == -6 || delta == 10);
    }

    public boolean isEightColumn(Cell cell, int delta) {
        int position = cell.getColumn() + cell.getRow() * Board.ROW_COUNT;
        return (position % 8 == 7) && (delta == -15 || delta == -6 || delta == 10 || delta == 17);
    }

    public String toString() {
        return alliance.toString() + "[Knight]" + id;
    }

}
