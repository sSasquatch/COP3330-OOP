/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

import constants.Constants.Face;
import constants.Constants.Suit;
import core.Card;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author 
 */
public class CardUi {

    /**
     * @return the button
     */
    public JButton getButton() {
        return button;
    }

    /**
     * @return the label
     */
    public JLabel getLabel() {
        return label;
    }
    
    //member variables
    private Card card;
    private ImageIcon imageIcon;
    private JButton button;
    private JLabel label;
    private int position;
    
    public CardUi(Card card, JButton button) {
        this.card = card;
        this.button = button;
        
        selectFrontImage();
    }
    
    public CardUi(Card card, JLabel label, int position) {
        this.card = card;
        this.label = label;
        this.position = position;
        
        if(position == 1 || position == 3) {
            selectVerticalBackImage();
        }
        else {
            selectHorizontalBackImage();
        }
    }
    
    public CardUi(JLabel label) {
        this.label = label;
        selectHorizontalBackImage();
    }
    
    private void selectFrontImage() {
        String fileName = "../images/";
        
        switch(card.getFace()) {
            case ACE:
                fileName += "Ace";
                break;
            case TWO:
                fileName += "Two";
                break;
            case THREE:
                fileName += "Three";
                break;
            case FOUR:
                fileName += "Four";
                break;
            case FIVE:
                fileName += "Five";
                break;
            case SIX:
                fileName += "Six";
                break;
            case SEVEN:
                fileName += "Seven";
                break;
            case EIGHT:
                fileName += "Eight";
                break;
            case NINE:
                fileName += "Nine";
                break;
            case TEN:
                fileName += "Ten";
                break;
            case JACK:
                fileName += "Jack";
                break;
            case QUEEN:
                fileName += "Queen";
                break;
            case KING:
                fileName += "King";
                break;
        }
        
        switch(card.getSuit()) {
            case CLUBS:
                fileName += "Clubs";
                break;
            case HEARTS:
                fileName += "Hearts";
                break;
            case DIAMONDS:
                fileName += "Diamonds";
                break;
            case SPADES:
                fileName += "Spades";
                break;
        }
        
        fileName += ".png";
        
        URL imgURL = getClass().getResource(fileName);
        
        if(imgURL != null) {
            imageIcon = new ImageIcon(imgURL);
            imageIcon = imageResizeHorizontal(imageIcon);
            button = new JButton(imageIcon);
        }
        else {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
    }
    
    private void selectVerticalBackImage() {
        String fileName = "../images/backVertical.jpg";
        URL imgURL = getClass().getResource(fileName);
        
        if(imgURL != null) {
            imageIcon = new ImageIcon(imgURL);
            imageIcon = imageResizeVertical(imageIcon);
            label = new JLabel(imageIcon);
        }
        else {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
    }
    
    private void selectHorizontalBackImage() {
        String fileName = "../images/backHorizontal.jpg";
        URL imgURL = getClass().getResource(fileName);
        
        if(imgURL != null) {
            imageIcon = new ImageIcon(imgURL);
            imageIcon = imageResizeHorizontal(imageIcon);
            label = new JLabel(imageIcon);
        }
        else {
            System.err.println("Couldn't find file: " + fileName);
            imageIcon = null;
        }
    }
    
    private ImageIcon imageResizeHorizontal(ImageIcon icon) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(50, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
    
    private ImageIcon imageResizeVertical(ImageIcon icon) {
        Image image = icon.getImage();
        Image newImage = image.getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImage);
        return icon;
    }
}
