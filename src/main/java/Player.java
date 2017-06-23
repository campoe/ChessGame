package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 23-6-2017.
 */
public class Player {

    private static final int PAWNS = 8;
    private static final int BISHOPS = 2;
    private static final int ROOKS = 2;
    private static final int KNIGHTS = 2;

    public boolean white;

    private List<Piece> pieces = new ArrayList<>();

    public Player(boolean white) {
        this.white = white;
        initializePieces();
    }

    public void initializePieces() {
        if (this.white == true) {
            for (int i = 0; i < PAWNS; i++) {
                pieces.add(new Pawn(i, 1, i, white));
            }
            for (int i = 0; i < ROOKS; i++) {
                pieces.add(new Rook(i, 0, 7 * i, white));
            }
            for (int i = 0; i < BISHOPS; i++) {
                pieces.add(new Bishop(i, 0, 3 * i + 2, white));
            }
            for (int i = 0; i < KNIGHTS; i++) {
                pieces.add(new Knight(i, 0, 5 * i + 1, white));
            }
            pieces.add(new King(0, 0, 4, white));
            pieces.add(new Queen(0, 0, 3, white));
        } else {
            for (int i = 0; i < PAWNS; i++) {
                pieces.add(new Pawn(i, 6, i, white));
            }
            for (int i = 0; i < ROOKS; i++) {
                pieces.add(new Rook(i, 7, 7 * i, white));
            }
            for (int i = 0; i < BISHOPS; i++) {
                pieces.add(new Bishop(i, 7, 3 * i + 2, white));
            }
            for (int i = 0; i < KNIGHTS; i++) {
                pieces.add(new Knight(i, 7, 5 * i + 1, white));
            }
            pieces.add(new King(0, 7, 4, white));
            pieces.add(new Queen(0, 7, 3, white));
        }
    }

    public boolean isWhite() {
        return white;
    }
    public void setWhite(boolean white) {
        this.white = white;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

}
