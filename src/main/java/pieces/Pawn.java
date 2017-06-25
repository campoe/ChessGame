package pieces;

import game.Board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Pawn extends Piece {

    private static final int[] DELTAS = new int[]{7, 8, 9, 16};

    public Pawn(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        List<Move> moves = new ArrayList<>();
        int coordinate;
        for (int delta : DELTAS) {
            coordinate = this.position.getIndex() + (this.alliance.getDirection() * delta);
            if (!super.validateMove(this.position.getIndex(), coordinate)) {
                continue;
            }
            if (delta == 8 && !Board.getInstance().getCell(coordinate).isOccupied()) {
                moves.add(new Move(this, coordinate));
            } else if (delta == 16 && this.isFirstMove()) {
                int firstCoordinate = this.position.getIndex() + (this.alliance.getDirection() * 8);
                if (!Board.getInstance().getCell(firstCoordinate).isOccupied() && !Board.getInstance().getCell(coordinate).isOccupied()) {
                    moves.add(new Move(this, coordinate));
                }
            } else if (delta == 7 && !((coordinate % 8 == 0 && this.alliance == Alliance.BLACK) || (coordinate % 8 == 7 && this.alliance == Alliance.WHITE))) {
                if (Board.getInstance().getCell(coordinate).isOccupied()) {
                    Piece piece = Board.getInstance().getCell(coordinate).getPiece();
                    Alliance alliance = piece.getAlliance();
                    if (this.alliance != alliance) {
                        moves.add(new Move(this, coordinate, piece));
                    }
                }
            } else if (delta == 9 && !((coordinate % 8 == 0 && this.alliance == Alliance.WHITE) || (coordinate % 8 == 7 && this.alliance == Alliance.BLACK))) {
                if (Board.getInstance().getCell(coordinate).isOccupied()) {
                    Piece piece = Board.getInstance().getCell(coordinate).getPiece();
                    Alliance alliance = piece.getAlliance();
                    if (this.alliance != alliance) {
                        moves.add(new Move(this, coordinate, piece));
                    }
                }
            }
        }
        return moves;
    }

    public String toString() {
        return alliance.toString() + "PA" + id;
    }

}
