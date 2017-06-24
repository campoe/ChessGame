package pieces;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Pawn extends Piece {

    public Pawn(int id, int row, int column, Alliance alliance) {
        super(id, row, column, alliance);
    }

    public Collection<Move> legalMoves() {
        List<Move> moves = new ArrayList<>();
        return moves;
    }

    public String toString() {
        return alliance.toString() + "[Pawn]" + id;
    }

}
