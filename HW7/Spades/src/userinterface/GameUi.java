/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants;
import core.Card;
import core.Game;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Anthony
 */
public class GameUi {
    //the game
    private Game game;
    
    //the layout
    private JFrame frame;
    private JPanel aiOnePanel;
    private JPanel tablePanel;
    private JPanel aiTwoPanel;
    private JPanel hpPanel;
    private JPanel aiThreePanel;
    private JPanel northPanel;
    private JPanel scorePanel;
    private JPanel bidPanel;
    
    //the menu
    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenu helpMenu;
    private JMenuItem newGameMenuItem;
    private JMenuItem exitMenuItem;
    private JMenuItem aboutMenuItem;
    private JMenuItem rulesMenuItem;
    
    //added member variables
    private ArrayList<JLabel> cardsPlayedLbl;
    private ArrayList<Card> cardsPlayed;
    
    //dialogs
    public GameUi (Game game) {
        this.game = game;
        initComponents();
    }
    
    private void initComponents() {
        initMenuBar();
        layoutTable();
    }
    
    private void initMenuBar() {
        menuBar = new JMenuBar();
        
        //game menu
        gameMenu = new JMenu("Game");
        newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.addActionListener(new NewGameListener());
        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ExitListener());
        
        //help menu
        helpMenu = new JMenu("Help");
        aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.addActionListener(new AboutListener());
        rulesMenuItem = new JMenuItem("Game Rules");
        rulesMenuItem.addActionListener(new RulesListener());
        
        //put it all together
        gameMenu.add(newGameMenuItem);
        gameMenu.add(exitMenuItem);
        
        helpMenu.add(aboutMenuItem);
        helpMenu.add(rulesMenuItem);
        
        menuBar.add(gameMenu);
        menuBar.add(helpMenu);
    }
    
    private void layoutTable() {
        //create the jframe
        frame = new JFrame("Spades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        
        //create the jmenubar
        initMenuBar();
        
        //create the players panels
        aiOnePanel = new AiPlayerUi(game.getTable().get(1), 1);
        aiTwoPanel = new AiPlayerUi(game.getTable().get(2), 2);
        aiThreePanel = new AiPlayerUi(game.getTable().get(3), 3);
        hpPanel = new HumanPlayerUi(game.getTable().get(0));
        
        initNorthPanel();
        initTablePanel();
        
        //add ui components
        frame.add(aiOnePanel, BorderLayout.WEST);
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(aiThreePanel, BorderLayout.EAST);
        frame.add(hpPanel, BorderLayout.SOUTH);
        frame.add(tablePanel, BorderLayout.CENTER);
        
        frame.setJMenuBar(menuBar);
        
        frame.setVisible(true);
    }
    
    private void initNorthPanel() {
        northPanel = new JPanel();
        northPanel.setMinimumSize(new Dimension(980, 150));
        northPanel.setPreferredSize(new Dimension(980, 150));
        
        bidPanel = new JPanel();
        bidPanel.setBorder(BorderFactory.createTitledBorder("Bids"));
        bidPanel.setMinimumSize(new Dimension(90, 140));
        bidPanel.setPreferredSize(new Dimension(90, 140));
        
        scorePanel = new JPanel();
        scorePanel.setBorder(BorderFactory.createTitledBorder("Score"));
        scorePanel.setMinimumSize(new Dimension(90, 140));
        scorePanel.setPreferredSize(new Dimension(90, 140));
        
        aiTwoPanel.setMinimumSize(new Dimension(700, 140));
        aiTwoPanel.setPreferredSize(new Dimension(700, 140));
        
        northPanel.add(scorePanel);
        northPanel.add(aiTwoPanel);
        northPanel.add(bidPanel);
    }
    
    private void initTablePanel() {
        tablePanel = new JPanel();
        tablePanel.setBorder(BorderFactory.createTitledBorder("SPADES"));
        tablePanel.setMaximumSize(new Dimension(200, 200));
        tablePanel.setMinimumSize(new Dimension(200, 200));
        tablePanel.setPreferredSize(new Dimension(200, 200));
        
        cardsPlayedLbl = new ArrayList<JLabel>();
        
        for(int c=0; c<Constants.NUM_PLAYERS; c++) {
            JLabel card = new JLabel();
            
            if(c == Constants.POSITION_1 || c == Constants.POSITION_3) {
                card.setMinimumSize(new Dimension(100, 150));
                card.setPreferredSize(new Dimension(100, 150));
                card.setMaximumSize(new Dimension(100, 150));
            }
            else {
                card.setMinimumSize(new Dimension(150, 100));
                card.setPreferredSize(new Dimension(150, 100));
                card.setMaximumSize(new Dimension(150, 100));
            }
            
            CardUi cardUi = new CardUi(card);
            
            card = cardUi.getLabel();
            cardsPlayedLbl.add(card);
        }
        
        //human player is in the south and is position_1
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_1), BorderLayout.SOUTH);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_2), BorderLayout.WEST);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_3), BorderLayout.NORTH);
        tablePanel.add(cardsPlayedLbl.get(Constants.POSITION_4), BorderLayout.EAST);
    }
    
    //inner classes
    private class NewGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
        }
    }
    
    private class ExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int response = JOptionPane.showConfirmDialog(frame, "Confirm to exit Spades?",
                    "Exit?", JOptionPane.YES_NO_OPTION);
            
            if(response == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }
    
    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String message = "Spades version 1.0\nAnthony Pionessa\nSpring 2018";
            JOptionPane.showMessageDialog(frame, message);
        }
    }
    
    private class RulesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String stepOne = "\nPlayers and Cards\nThe four players are in fixed partnerships, with partners sitting opposite each other.\nDeal and play are clockwise.\nA standard pack of 52 cards is used.\nThe cards, in each suit, rank from highest to lowest: A, K, Q, J, 10, 9, 8, 7, 6, 5, 4, 3, 2.\n";
            String stepTwo = "\nThe Deal\nThe first dealer is chosen at random, and the turn to deal rotates clockwise.\nThe cards are shuffled and then dealt singly, in clockwise order beginning with the player on dealer's left,\nuntil all 52 cards have been dealt and everyone has 13.\n";
            String stepThree = "\nThe Bidding\nIn Spades, all four players bid a number of tricks.\nEach team adds together the bids of the two partners, and the total is the number of tricks that team must try to win in order to get a positive score.\nThe bidding begins with the player to dealer's left and continues clockwise around the table.\nEveryone must bid a number, and in theory any number from 0 to 13 is allowed.\nUnlike other games with bidding, there is no requirement for each bid to be higher than the last one, and players are not allowed to pass.\nThere is no second round of bidding - bids once made cannot be altered.\n";
            String stepFour = "\nThe Play of the Hand\nThe player to dealer's left leads any card except a spade to the first trick.\nEach player, in turn, clockwise, must follow suit if able; if unable to follow suit, the player may play any card.\nA trick containing a spade is won by the highest spade played; if no spade is played, the trick is won by the highest card of the suit led.\nThe winner of each trick leads to the next.\nSpades may not be led until either some player has played a spade (on the lead of another suit, of course), or the leader has nothing but spades left in hand.\nPlaying the first spade is known as \"breaking\" spades.\n";
            String stepFive = "\nScoring\nA side that takes at least as many tricks as its bid calls for receives a score equal to 10 times its bid.\nAdditional tricks (overtricks) are worth an extra one point each.\n";
            String stepSix = "\nSandbagging rule: Overtricks are colloquially known as bags.\nA side which (over several deals) accumulates ten or more bags has 100 points deducted from its score.\nAny bags beyond ten are carried over to the next cycle of ten overtricks - that is if they reached twenty overtricks they would lose another 100 points and so on.\nIf a side does not make its bid, they lose 10 points for each trick they bid.\nIf a bid of nil is successful, the nil bidder's side receives 100 points.\nThis is in addition to the score won (or lost) by the partner of the nil bidder for tricks made.\nIf a bid of nil fails - that is, the bidder takes at least one trick - the bidder's side loses 100 points, but still receives any amount scored for the partner's bid.\nThe usual rule is that when a nil fails, the tricks won by the nil bidder do not count towards making the partner's bid, but do count as bags for the team.\nA bid of blind nil scores twice as much as an ordinary nil - it wins 200 points if successful and loses 200 points if it fails.\nThe side which reaches 500 points first wins the game.\nIf both sides reach 500 points in the same deal, the side with the higher score wins.\n";
            
            JOptionPane.showMessageDialog(frame, stepOne + stepTwo + stepThree + stepFour + stepFive + stepSix);
        }
    } 
}
