package pieces;

import game.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Knight extends Piece {

    private static final int[] DELTAS = new int[]{-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        int coordinate;
        List<Move> moves = new ArrayList<>();
        for (int delta : DELTAS) {
            coordinate = this.position.getIndex() + delta;
            if (super.validateMove(this.position.getIndex(), coordinate)) {
                if (isFirstColumn(this.position.getIndex(), delta) || isSecondColumn(this.position.getIndex(), delta) || isSeventhColumn(this.position.getIndex(), delta) || isEightColumn(this.position.getIndex(), delta)) {
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

    private boolean isFirstColumn(int position, int delta) {
        return (position % 8 == 0) && (delta == -17 || delta == -10 || delta == 6 || delta == 15);
    }

    private boolean isSecondColumn(int position, int delta) {
        return (position % 8 == 1) && (delta == -10 || delta == 6);
    }

    private boolean isSeventhColumn(int position, int delta) {
        return (position % 8 == 6) && (delta == -6 || delta == 10);
    }

    private boolean isEightColumn(int position, int delta) {
        return (position % 8 == 7) && (delta == -15 || delta == -6 || delta == 10 || delta == 17);
    }

    public String toString() {
        return alliance.toString() + "KN" + id;
    }

}
