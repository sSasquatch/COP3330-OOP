/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Set;

/**
 *
 * @author apion
 */
public class Deck {

    /**
     * @return the deck
     */
    public Set<Card> getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Set<Card> deck) {
        this.deck = deck;
    }
    
    //member variables
    private Set<Card> deck;
}
