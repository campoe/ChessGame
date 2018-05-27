package com.arman.game.model;

import com.arman.game.model.pieces.Piece;

/**
 * Created by Coen on 23-6-2017.
 */
public class Cell {

    private Board board;
    private int row;
    private int column;
    private Piece piece;

    public Cell(Board board, int row, int column) {
        this.row = row;
        this.column = column;
        this.piece = null;
        this.board = board;
    }

    public Cell(Board board, int index) {
        this(board, Board.getRow(index), Board.getColumn(index));
    }

    public void occupy(Piece piece) {
        piece.setIndex(getIndex());
        this.piece = piece;
    }

    public Piece release() {
        Piece res = this.piece;
        this.piece = null;
        return res;
    }

    public boolean isOccupied() {
        return this.piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public int getIndex() {
        return this.getColumn() + this.getRow() * Board.ROW_COUNT;
    }

    public String toString() {
        if (!isOccupied()) {
            return "--";
        }
        String res = this.piece.toString();
        if (res.length() == 1) {
            res += " ";
        }
        return res;
    }

    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }

    public Cell hardCopy(Board boardCopy) {
        return new Cell(boardCopy, getIndex());
    }

}
