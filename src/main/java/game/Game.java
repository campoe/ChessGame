package game;

import java.util.Scanner;
import pieces.*;

/**
 * Created by Coen on 23-6-2017.
 */
public class Game {

    private static Game instance = new Game();
    private Player[] players = new Player[2];
    private int current;

    private Game() {
        players[0] = new Player(Alliance.WHITE);
        players[1] = new Player(Alliance.BLACK);
        current = 0;
    }

    public static Game getInstance() {
        return instance;
    }

    public Player getBlack() {
        return players[1];
    }
    public Player getWhite() {
        return players[0];
    }

    public void start() {
        boolean again = true;
        while (again) {
            reset();
            play();
            again = readBoolean("\n> Play another time? (y/n)?", "y", "n");
        }
    }

    private boolean readBoolean(String prompt, String yes, String no) {
        String answer = null;
        do {
            System.out.print(prompt);
            Scanner in = new Scanner(System.in);
            answer = in.hasNextLine() ? in.nextLine() : null;
        } while (answer == null || (!answer.equals(yes) && !answer.equals(no)));
        return answer.equals(yes);
    }

    private void reset() {
        current = 0;
        Board.getInstance().reset();
    }

    private void play() {
        update();
        while (!Board.getInstance().gameOver()) {
            players[current].makeMove();
            current = ++current % 2;
            update();
        }
        printResult();
    }

    private void update() {
        System.out.println("\nCurrent Game Situation: \n\n" + Board.getInstance().toString() + "\n");
    }

    private void printResult() {
        if (Board.getInstance().isCheckMate()) {
            System.out.println("There is a winner!");
        } else {
            System.out.println("Draw. There is no winner!");
        }
    }

}
