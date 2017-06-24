package game;

/**
 * Created by Coen on 23-6-2017.
 */
public class Board {

    public static final int ROW_COUNT = 8;
    public static final int COLUMN_COUNT = 8;
    public static final int CELL_COUNT = ROW_COUNT * COLUMN_COUNT;
    private Cell[] cells;

    private static Board instance = new Board();

    private Board() {
        this.cells = new Cell[CELL_COUNT];
        reset();
    }

    public static Board getInstance() {
        return instance;
    }

    public Board deepCopy() {
        Board copy = new Board();
        for (int i = 0; i < CELL_COUNT; i++) {
            copy.cells[i] = this.cells[i];
        }
        return copy;
    }

    public static int index(int row, int column) {
        return column + row * ROW_COUNT;
    }

    public boolean isCell(int i) {
        return 0 <= i && i < CELL_COUNT;
    }

    public boolean isCell(int row, int column) {
        return isCell(index(row, column));
    }

    public Cell getCell(int i) {
        return cells[i];
    }

    public Cell getCell(int row, int column) {
        return getCell(index(row, column));
    }

    public boolean isEmptyCell(int i) {
        return !getCell(i).isOccupied();
    }

    public boolean isEmptyField(int row, int column) {
        return isEmptyCell(index(row, column));
    }

    public boolean gameOver() {
        return isStaleMate() || isCheckMate();
    }

    public boolean isStaleMate() {
        // TODO
        return false;
    }

    public boolean isCheckMate() {
        return Game.getInstance().getWhite().isChecked() || Game.getInstance().getBlack().isChecked();
    }

    public Cell[] getCells() {
        return cells;
    }

    public String toString() {
        String res = " ---------------------------------\n";
        for (int y = 0; y < ROW_COUNT; y++) {
            for (int x = 0; x < COLUMN_COUNT; x++) {
                res += " | " + getCell(y, x).toString();
            }
            res += " |\n";
            res += " ---------------------------------\n";
        }
        return res;
    }

    public void reset() {
        for (int y = 0; y < ROW_COUNT; y++) {
            for (int x = 0; x < COLUMN_COUNT; x++) {
                cells[x + y * ROW_COUNT] = new Cell(y, x);
            }
        }
    }

}
