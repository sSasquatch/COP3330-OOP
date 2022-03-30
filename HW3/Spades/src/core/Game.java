/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import constants.Constants.Suit;
import java.util.ArrayList;
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
        return lead_player;
    }

    /**
     * @param lead_player the lead_player to set
     */
    public void setLead_player(Player lead_player) {
        this.lead_player = lead_player;
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
    private Player lead_player;
    private Player dealer;
    private Player winner;
    private int curr_round;
    private ArrayList<Team> teams;
    private Deck deck;
            
    public Game() {
        createTeams();
        outputTeams();
        createDeck();
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
    
    public void createDeck() {
        Deck deck = new Deck();
    }

}
