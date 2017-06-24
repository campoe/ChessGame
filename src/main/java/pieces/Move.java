package pieces;

/**
 * Created by Coen on 24-6-2017.
 */
public class Move {

    private Piece piece;
    private int destination;
    private Piece attackedPiece;

    public Move(Piece piece, int destination, Piece attackedPiece) {
        this.piece = piece;
        this.destination = destination;
        this.attackedPiece = attackedPiece;
    }

    public Move(Piece piece, int destination) {
        this.piece = piece;
        this.destination = destination;
        this.attackedPiece = null;
    }

}
