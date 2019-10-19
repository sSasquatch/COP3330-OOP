/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import core.HumanPlayer;
import core.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class HumanPlayerUi extends JPanel {
    private HumanPlayer human;
    private ArrayList<JButton> cards;
    
    public HumanPlayerUi(Player player) {
        human = (HumanPlayer)player;
        
        initComponents();
    }  
    
    private void initComponents() {
        this.setBorder(BorderFactory.createTitledBorder(human.getName()));
        this.setMinimumSize(new Dimension(200, 180));
        this.setPreferredSize(new Dimension(200, 180));
        
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        
        displayCards();
    }
    
    private void displayCards() {
        cards = new ArrayList<JButton>();
        
        for(int c=0; c<Constants.NUM_CARDS_DELT; c++) {
            JButton card = new JButton();
            card.setMinimumSize(new Dimension(60, 200));
            card.setPreferredSize(new Dimension(60, 200));
            card.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            card.setText("CARD " + c);
            cards.add(card);
            this.add(card);
        }
    }
    
    private static final Logger LOG = Logger.getLogger(HumanPlayerUi.class.getName());
}
