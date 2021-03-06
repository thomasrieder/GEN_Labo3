package ch.heigvd.gen.labo;

import java.util.ArrayList;

class Board {
    public static final int SQUARE_NB = 40;
    private final int jailPosition = 20;

    private ArrayList<Square> squares;

    /**
     * Board class constructor
     */
    public Board() {
        squares = new ArrayList<Square>();

        squares.add(new GoSquare("Go"));
        for (int i = 1; i < SQUARE_NB; i++) {
            switch (i){
                case 10:
                    squares.add(new IncomeTaxSquare("IncomeTaxSquare " + i));
                    break;
                case jailPosition:
                    squares.add(new RegularSquare("PrisonSquare"));
                    break;
                case 30:
                    squares.add(new GoToJailSquare("GoToJailSquare " + i, squares.get(jailPosition)));
                    break;
                default:
                    squares.add(new RegularSquare("Square " + i));

            }
        }
    }

    /**
     * Get new square by adding "moveNb" to "initialSquare"
     * @param initialSquare Initial square
     * @param moveNb Number of square to move
     * @return New square
     */
    public Square getSquare(Square initialSquare, int moveNb) {
        return squares.get((squares.indexOf(initialSquare) + moveNb) % squares.size());
    }

    /**
     * @return Get board's first square (Go square)
     */
    public Square getFirstSquare() {
        return squares.get(0);
    }

}
