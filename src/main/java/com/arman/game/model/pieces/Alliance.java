package com.arman.game.model.pieces;

/**
 * Created by Coen on 23-6-2017.
 */
public enum Alliance {

    WHITE(), BLACK();

    Alliance() {

    }

    public int getDirection() {
        if (this.equals(WHITE)) {
            return -1;
        } else {
            return 1;
        }
    }

    public Alliance getOpposite() {
        if (this.equals(WHITE)) {
            return BLACK;
        } else {
            return WHITE;
        }
    }

    public String toString() {
        if (this.equals(WHITE)) {
            return "W";
        } else {
            return "B";
        }
    }

}
