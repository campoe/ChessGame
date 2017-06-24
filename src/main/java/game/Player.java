package game;

import java.util.ArrayList;
import java.util.List;
import pieces.*;

/**
 * Created by Coen on 23-6-2017.
 */
public class Player {

    private static final int PAWNS = 8;
    private static final int BISHOPS = 2;
    private static final int ROOKS = 2;
    private static final int KNIGHTS = 2;

    public Alliance alliance;

    private List<Piece> pieces = new ArrayList<>();

    public Player(Alliance alliance) {
        this.alliance = alliance;
        initializePieces();
    }

    public void initializePieces() {
        if (this.alliance == Alliance.WHITE) {
            for (int i = 0; i < PAWNS; i++) {
                pieces.add(new Pawn(i, 1, i, Alliance.WHITE));
            }
            for (int i = 0; i < ROOKS; i++) {
                pieces.add(new Rook(i, 0, 7 * i, Alliance.WHITE));
            }
            for (int i = 0; i < BISHOPS; i++) {
                pieces.add(new Bishop(i, 0, 3 * i + 2, Alliance.WHITE));
            }
            for (int i = 0; i < KNIGHTS; i++) {
                pieces.add(new Knight(i, 0, 5 * i + 1, Alliance.WHITE));
            }
            pieces.add(new King(0, 0, 4, Alliance.WHITE));
            pieces.add(new Queen(0, 0, 3, Alliance.WHITE));
        } else {
            for (int i = 0; i < PAWNS; i++) {
                pieces.add(new Pawn(i, 6, i, Alliance.BLACK));
            }
            for (int i = 0; i < ROOKS; i++) {
                pieces.add(new Rook(i, 7, 7 * i, Alliance.BLACK));
            }
            for (int i = 0; i < BISHOPS; i++) {
                pieces.add(new Bishop(i, 7, 3 * i + 2, Alliance.BLACK));
            }
            for (int i = 0; i < KNIGHTS; i++) {
                pieces.add(new Knight(i, 7, 5 * i + 1, Alliance.BLACK));
            }
            pieces.add(new King(0, 7, 4, Alliance.BLACK));
            pieces.add(new Queen(0, 7, 3, Alliance.BLACK));
        }
    }

    public boolean isWhite() {
        return alliance == Alliance.WHITE;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public void makeMove() {
        // TODO
    }

    public boolean isChecked() {
        // TODO
        return false;
    }

}
