/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constants;

/**
 *
 * @author apion
 */
public class Constants {
    
    //member variables
    public static final int NUM_AI_PLAYERS = 3;
    public static final int NUM_CARDS_DECK = 52;
    public static final int NUM_CARDS_DELT = 13;
    public static final int NUM_ROUNDS = 13;
    public static final int MIN_BID = 1;
    public static final int WIN_SCORE = 200;
    public static final int ONE = 0;
    public static final int TWO = 1;
    public static final int NUM_PLAYERS = 4;
    
    public enum Color {
        RED,
        BLACK
    }
    
    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
    
    public enum Face {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE
    }
    
}
