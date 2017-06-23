package main.java;

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
        for (int y = 0; y < ROW_COUNT; y++) {
            for (int x = 0; x < COLUMN_COUNT; x++) {
                cells[x + y * ROW_COUNT] = new Cell(y, x);
            }
        }
    }

    public static Board getInstance() {
        return instance;
    }

    public Cell[] getCells() {
        return cells;
    }

    public Cell getCell(int row, int column) {
        return cells[column + row * Board.ROW_COUNT];
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

    public static void main(String[] args) {
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        System.out.println(Board.getInstance());
    }

}
