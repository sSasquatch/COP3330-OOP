/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author apion
 */
public abstract class Player implements IPlayer {

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
    
    //abstract method from IPlayer
    public abstract Card playCard();
    public abstract int placeBid();
    
    
}
