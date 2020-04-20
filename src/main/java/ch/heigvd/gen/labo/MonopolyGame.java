package ch.heigvd.gen.labo;

import java.util.ArrayList;

public class MonopolyGame {
    private static final int MAX_ROUND_NB = 20;
    private static final int MIN_PLAYER_NB = 2;
    private static final int MAX_PLAYER_NB = 8;
    private static final int NB_DICE = 8;

    private Board board;
    private ArrayList<Die> dices;
    private ArrayList<Player> players;

    public MonopolyGame(int nbPlayer) {
        if (nbPlayer < MIN_PLAYER_NB || nbPlayer > MAX_PLAYER_NB) {
            throw new IllegalArgumentException("Number of player must be between " + MIN_PLAYER_NB + " and " + MAX_PLAYER_NB + " (included).");
        }

        board = new Board();
        dices = new ArrayList<Die>(NB_DICE);

        players = new ArrayList<Player>();
        for (int i = 0; i < nbPlayer; i++) {
            players.add(new Player("player_" + (i + 1), dices, board));
        }
    }

    public void playGame() {
        for (int roundCnt = 0; roundCnt < MAX_ROUND_NB; roundCnt++) {
            playRound();
        }
    }

    private void playRound() {
        for (Player player : players) {
            player.takeTurn();
        }
    }

}
