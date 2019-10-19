/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import java.awt.Color;
import core.AiPlayer;
import core.Player;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class AiPlayerUi extends JPanel {
    private AiPlayer ai;
    private int position;
    private ArrayList<JLabel> cards;

    //added member variable
    private CardUi cardUi;
    private int width;
    private int height;
    
    public AiPlayerUi(Player player, int position) {
        ai = (AiPlayer)player;
        this.position = position;
        
        initComponents();
    }
    
    private void initComponents() {
        this.setBorder(BorderFactory.createTitledBorder(ai.getName()));
        this.setMinimumSize(new Dimension(250, 250));
        this.setPreferredSize(new Dimension(250, 250));
        
        cards = new ArrayList<JLabel>();
        
        if(position == 1 || position == 3) {
//            displayVerticalCards();
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.width = 100;
            this.height = 50;
        }
        else {
//            displayHorizontalCards();
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            this.width = 50; 
            this.height = 100;
        }
        
        displayCards();
    }
    
    private void displayCards() {
        cards = new ArrayList<JLabel>();
        
        for(int c=0; c<Constants.NUM_CARDS_DELT; c++) {
            JLabel card = new JLabel();
            cardUi = new CardUi(ai.getHand().get(c), card, position);
            card = cardUi.getLabel();
            card.setMinimumSize(new Dimension(width, height));
            card.setPreferredSize(new Dimension(width, height));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            cards.add(card);
            this.add(card);
        }
    }
    
    private void displayVerticalCards() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        for(int c=0; c<Constants.NUM_CARDS_DELT; c++) {
            JLabel card = new JLabel();
            card.setMinimumSize(new Dimension(180, 30));
            card.setPreferredSize(new Dimension(180, 30));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            card.setText("CARD " + c);
            cards.add(card);
            this.add(card);
        }
    }
    
    private void displayHorizontalCards() {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        for(int c=0; c<Constants.NUM_CARDS_DELT; c++) {
            JLabel card = new JLabel();
            card.setMinimumSize(new Dimension(50, 200));
            card.setPreferredSize(new Dimension(50, 200));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//            card.setText("CARD " + c);
            cards.add(card);
            this.add(card);
        }
    }
}
