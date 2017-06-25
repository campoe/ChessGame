package pieces;

import game.Board;
import game.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class King extends Piece {

    private static final int[] DELTAS = new int[]{-9, -8, -7, -1, 1, 7, 8, 9};

    public King(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        List<Move> moves = new ArrayList<>();
        int coordinate;
        for (int delta : DELTAS) {
            coordinate = this.position.getIndex() + delta;
            if (isFirstColumn(this.position.getIndex(), delta) || isEightColumn(this.position.getIndex(), delta)) {
                continue;
            }
            if (super.validateMove(this.position.getIndex(), coordinate)) {
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
        return (position % 8 == 0) && (delta == -9 || delta == -1 || delta == 7);
    }

    private boolean isEightColumn(int position, int delta) {
        return (position % 8 == 7) && (delta == -7 || delta == 1 || delta == 9);
    }

    public String toString() {
        return alliance.toString() + "KI" + id;
    }

}
