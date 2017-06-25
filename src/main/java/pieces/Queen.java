package pieces;

import game.Board;
import game.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Queen extends Piece {

    private static final int[] DELTAS = new int[]{-9, -8, -7, -1, 1, 7, 8, 9};

    public Queen(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        int coordinate;
        List<Move> moves = new ArrayList<>();
        for (int delta : DELTAS) {
            coordinate = this.position.getIndex();
            while (super.validateMove(this.position.getIndex(), coordinate)) {
                if (isFirstColumn(coordinate, delta) || isEightColumn(coordinate, delta)) {
                    break;
                }
                coordinate += delta;
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
                        break;
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
        return alliance.toString() + "QU" + id;
    }

}
