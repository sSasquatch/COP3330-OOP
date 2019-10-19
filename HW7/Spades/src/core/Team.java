/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author apion
 */
public class Team {

    /**
     * @return the team
     */
    public ArrayList<Player> getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }

    /**
     * @return the teamBid
     */
    public int getTeamBid() {
        return teamBid;
    }

    /**
     * @param teamBid the teamBid to set
     */
    public void setTeamBid(int teamBid) {
        this.teamBid = teamBid;
    }

    /**
     * @return the teamScore
     */
    public int getTeamScore() {
        return teamScore;
    }

    /**
     * @param teamScore the teamScore to set
     */
    public void setTeamScore(int teamScore) {
        this.teamScore = teamScore;
    }

    /**
     * @return the teamTricks
     */
    public int getTeamTricks() {
        return teamTricks;
    }

    /**
     * @param teamTricks the teamTricks to set
     */
    public void setTeamTricks(int teamTricks) {
        this.teamTricks = teamTricks;
    }

    /**
     * @return the teamBags
     */
    public int getTeamBags() {
        return teamBags;
    }

    /**
     * @param teamBags the teamBags to set
     */
    public void setTeamBags(int teamBags) {
        this.teamBags = teamBags;
    }

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    
    //member variables
    private ArrayList<Player> team;
    private int teamBid;
    private int teamScore;
    private int teamTricks;
    private int teamBags;
    private String teamName;
    
    public Team() {
        team = new ArrayList();
    }
}
