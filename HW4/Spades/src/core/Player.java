/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public abstract class Player implements IPlayer {

    /**
     * @return the hand
     */
    public ArrayList<Card> getHand() {
        return hand;
    }

    /**
     * @param hand the hand to set
     */
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tricks
     */
    public int getTricks() {
        return tricks;
    }

    /**
     * @param tricks the tricks to set
     */
    public void setTricks(int tricks) {
        this.tricks = tricks;
    }

    /**
     * @return the bid
     */
    public int getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(int bid) {
        this.bid = bid;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
    
    //member variables
    private String name;
    private int tricks;
    private int bid;
    private int score;
    private ArrayList<Card> hand;
    
    //abstract method from IPlayer
    public abstract Card playCard();
    public abstract int placeBid();
    
    public Player() {
        hand = new ArrayList();
    }
    
    void displayHand() {
        System.out.println("*****");
        System.out.println("Player " + name + " hand is ");
        System.out.println("*****");
        
        for(Card card : hand)
            System.out.println(card.getFace() + " of " + card.getSuit());
    }
}
