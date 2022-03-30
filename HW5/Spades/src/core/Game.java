/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import constants.Constants.Suit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Game {

    /**
     * @return the lead_player
     */
    public Player getLead_player() {
        return leadPlayer;
    }

    /**
     * @param lead_player the lead_player to set
     */
    public void setLead_player(Player lead_player) {
        this.leadPlayer = leadPlayer;
    }

    /**
     * @return the dealer
     */
    public Player getDealer() {
        return dealer;
    }

    /**
     * @param dealer the dealer to set
     */
    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    /**
     * @return the winner
     */
    public Player getWinner() {
        return winner;
    }

    /**
     * @param winner the winner to set
     */
    public void setWinner(Player winner) {
        this.winner = winner;
    }

    /**
     * @return the curr_round
     */
    public int getCurr_round() {
        return curr_round;
    }

    /**
     * @param curr_round the curr_round to set
     */
    public void setCurr_round(int curr_round) {
        this.curr_round = curr_round;
    }

    /**
     * @return the teams
     */
    public ArrayList<Team> getTeams() {
        return teams;
    }

    /**
     * @param teams the teams to set
     */
    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    /**
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * @param deck the deck to set
     */
    public void setDeck(Deck deck) {
        this.deck = deck;
    }
    
    //member variables
    private Suit trump = Suit.SPADES;
    private Player leadPlayer;
    private Player dealer;
    private Player winner;
    private int curr_round;
    private ArrayList<Team> teams;
    public Deck deck;
    private Scanner scan;
    private ArrayList<Player> table;
    private int dealerIdx;
            
    //custom constructor
    public Game() {
        createTeams();
//        outputTeams();
        //createDeck();
        generateDeck();
        setTable();
        dealHand();
        displayHands();
        play();
    }
    
    public void generateDeck() {
        deck = new Deck();
    }
            
    private void createTeams() {
        teams = new ArrayList();
        
        //instantiate Team One and add to ArrayList
        Team teamOne = new Team();
        teamOne.setTeamName("Team One");
        getTeams().add(teamOne);
        
        //instantiate Team Two and add to ArrayList
        Team teamTwo = new Team();
        teamTwo.setTeamName("Team Two");
        getTeams().add(teamTwo);
        
        //user input for their name
        Scanner input = new Scanner(System.in);
        System.out.println("Enter human player name: ");
        String user_name = input.next();
        
        //adding Human Player to Team One
        HumanPlayer user = new HumanPlayer();
        user.setName(user_name);
        teamOne.getTeam().add(user);
        System.out.println("Human Player added to Team One");
        
        //creat the AI Players and add them to a team
        for(int p = 1; p<=Constants.NUM_AI_PLAYERS; p++) {
            AiPlayer aip = new AiPlayer();
            aip.setName("AI " + p);
            if (p == 1)
                teamOne.getTeam().add(aip);
            else
                teamTwo.getTeam().add(aip);
        }
    }
    
    private void outputTeams() {
        for(Team team : getTeams()) {
            System.out.println(team.getTeamName() + " includes players:");
            for(Player players : team.getTeam()) {
                System.out.println("Player: " + players.getName());
            }
        }
    }
    
    private void createDeck() {
        Deck deck = new Deck();
    }
    
    private void setTable() {
        //players are set up so that team members sit across from each other
        table = new ArrayList();
        
        //get the teams in the game
        Team teamOne = teams.get(Constants.ONE);
        Team teamTwo = teams.get(Constants.TWO);
        
        //get the players from each team
        Player teamOnePlayerOne = teamOne.getTeam().get(Constants.ONE);
        Player teamOnePlayerTwo = teamOne.getTeam().get(Constants.TWO);
        Player teamTwoPlayerOne = teamTwo.getTeam().get(Constants.ONE);
        Player teamTwoPlayerTwo = teamTwo.getTeam().get(Constants.TWO);
        
        //we want to explicitly dictate which seat each player is in so we are
        //using the add method that takes two arguments, one to set the position
        //in the ArrayList and the associated object at that position
        table.add(0, teamOnePlayerOne);
        table.add(1, teamTwoPlayerOne);
        table.add(2, teamOnePlayerTwo);
        table.add(3, teamTwoPlayerTwo);
        
        //select the first dealer
        Random random = new Random();
        dealerIdx = random.nextInt(Constants.NUM_PLAYERS);
        dealer = table.get(dealerIdx);
        
        System.out.println("Players at the table are");
        for(Player player : table) {
            System.out.println(player.getName());
        }
    }
    
    private void dealHand() {
        System.out.println("Player " + dealer.getName() + " will deal the hand.");
        
        //create an index to keep track of which player got the card
        //reset when get to 3
        //set the playerIdx based on which plaayer was selected as the dealer and
        //add one to it
        int playerIdx;
        
        if(dealerIdx < 3)
            playerIdx = dealerIdx++;
        else
            playerIdx = 0;
        
        //loop through the shuffled deck and deal 13 cards to each player
        for(Iterator<Card> currentCard = deck.getDeck().iterator(); currentCard.hasNext(); ) {
            Card card = currentCard.next();
            
//            System.out.println("Dealing " + card.getFace() + " of " + card.getSuit());
            
            //add card to players hand
//           System.out.println("Adding to player " + table.get(playerIdx).getName() + " hand");
            table.get(playerIdx).getHand().add(card);
            
            //increment the player index until value of 3, then reset to 0
            if(playerIdx == 3)
                playerIdx = 0;
            else
                playerIdx++;
            
            currentCard.remove();
        }
    }
    
    private void displayHands() {
        for(Team team : teams) {
            System.out.println("*****");
            System.out.println("     " + team.getTeamName().toUpperCase());
            System.out.println("*****");
            
            for(Player player : team.getTeam()) {
//                player.displayHand();
                System.out.println("Sorting hand by suit and face.");
                player.sortBySuit();
                
                if(player instanceof HumanPlayer) {
                    player.displayHand();
                }
            }
        }
    }
    
    private void play() {
        System.out.println("*****");
        System.out.println("Play the game!");
        System.out.println("*****\n");
        System.out.println("*****");
        System.out.println("Get player bids");
        System.out.println("*****");
        
        //starting with the player to the left of the dealer
        //each player plays the best card in their hand
        //players must follor suit if they can, if not they can trump if 
        //they want to
        getBids();
    }
    
    private void getBids() {
        //counter for bids placed
        int bidsPlaced = 0;
        
        //set the lead player
        int leadIdx;
        
        if(dealerIdx < 3)
            leadIdx = dealerIdx++;
        else
            leadIdx = 0;
        
        leadPlayer = table.get(leadIdx);
        
        System.out.println("Lead player is player " + leadPlayer.getName());
        
        //start with the lead player then move on to the others
        if(leadPlayer instanceof HumanPlayer) {
            //prompt player to play a card
            HumanPlayer hp = (HumanPlayer)leadPlayer;
            hp.placeBid();
        }
        else {
            AiPlayer ai = (AiPlayer)leadPlayer;
            ai.placeBid();
        }
        
        bidsPlaced++;
        
        //now get the remaining three bids
        int playerIdx;
        
        if(leadIdx < 3)
            playerIdx = leadIdx++;
        else
            playerIdx = 0;
        
        //player after lead player
        Player nextPlayer = table.get(playerIdx);
        
        while(bidsPlaced <= Constants.NUM_PLAYERS) {
            System.out.println("Getting bid from player " + nextPlayer.getName());
            if(nextPlayer instanceof HumanPlayer) {
                //prompt player to play a card
                HumanPlayer hp = (HumanPlayer)nextPlayer;
                hp.placeBid();
            }
            else {
                AiPlayer ai = (AiPlayer)nextPlayer;
                ai.placeBid();
            }
            
            //increment the counter
            bidsPlaced++;
            
            //move to the next player
            if(playerIdx < 3)
                playerIdx++;
            else
                playerIdx = 0;
            
            nextPlayer = table.get(playerIdx);
        }
    }
    
    private void playHand() {
        
    }
}
