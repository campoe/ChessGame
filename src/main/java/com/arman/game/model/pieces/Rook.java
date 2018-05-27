package com.arman.game.model.pieces;

import com.arman.game.model.Board;
import com.arman.game.model.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Rook extends Piece {

    private static final int[] DELTAS = new int[]{-8, -1, 1, 8};

    public Rook(Board board, int row, int column, Alliance alliance) {
        super(board, Type.ROOK, row, column, alliance);
    }

    public Rook(Board board, int index, Alliance alliance) {
        super(board, Type.ROOK, index, alliance);
    }

    public Rook(Board board, int index, Alliance alliance, int kills, boolean alive, boolean firstMove) {
        super(board, Type.ROOK, index, alliance, kills, alive, firstMove);
    }

    public Collection<Move> getLegalMoves(Board board) {
        int coordinate;
        List<Move> moves = new ArrayList<>();
        if (!isAlive() || !Board.isCell(getIndex())) {
            return moves;
        }
        for (int delta : DELTAS) {
            coordinate = this.getIndex();
            do {
                if (isFirstColumn(coordinate, delta) || isEightColumn(coordinate, delta)) {
                    break;
                }
                coordinate += delta;
                if (super.isLegalMove(this.getIndex(), coordinate)) {
                    Cell cell = board.getCell(coordinate);
                    if (!cell.isOccupied()) {
                        moves.add(new Move(board, this, coordinate));
                    } else {
                        Piece piece = cell.getPiece();
                        Alliance alliance = piece.getAlliance();
                        if (this.alliance != alliance) {
                            moves.add(new Move(board, this, coordinate, piece));
                        }
                        break;
                    }
                }
            } while (super.isLegalMove(this.getIndex(), coordinate));
        }
        return moves;
    }

    @Override
    public int getStrength() {
        return 5;
    }

    private boolean isFirstColumn(int position, int delta) {
        return Board.isNthColumn(0, position) && (delta == -1);
    }

    private boolean isEightColumn(int position, int delta) {
        return Board.isNthColumn(7, position) && (delta == 1);
    }

    public Piece hardCopy(Board boardCopy) {
        return new Rook(boardCopy, getIndex(), alliance, kills, alive, firstMove);
    }

}
