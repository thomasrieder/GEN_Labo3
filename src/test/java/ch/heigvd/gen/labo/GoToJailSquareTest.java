package ch.heigvd.gen.labo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoToJailSquareTest {

    Player player;
    Board board;

    @Test
    public void reducePlayerCashTest() {


        board = new Board();

        player = new Player("player_1", new Cup(), board);

        Square oldLoc = player.getPiece().getLocation();

        //30 is the location of IncomeTaxSquare
        Square newLoc = board.getSquare(oldLoc, 30);

        player.getPiece().setLocation(newLoc);
        newLoc.landedOn(player);

        assertEquals("PrisonSquare", player.getPiece().getLocation().getName());
    }
}
