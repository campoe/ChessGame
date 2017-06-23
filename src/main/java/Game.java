package main.java;

/**
 * Created by Coen on 23-6-2017.
 */
public class Game {

    private static Game instance = new Game();

    private Game() {

    }

    public static Game getInstance() {
        return instance;
    }

}
