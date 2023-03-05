package com.adaptionsoft.games.uglytrivia;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Game {
    // Initialize game variables
    private static final int MAX_NUM_PLAYERS = 6;
    private static final int NUM_QUESTIONS_PER_CATEGORY = 50;
    private List<String> players = new ArrayList<>();
    private int[] playerPositions = new int[MAX_NUM_PLAYERS];
    private int[] playerScores = new int[MAX_NUM_PLAYERS];
    private boolean[] playersInPenaltyBox = new boolean[MAX_NUM_PLAYERS];
    private LinkedList<String> popQuestions = new LinkedList<>();
    private LinkedList<String> scienceQuestions = new LinkedList<>();
    private LinkedList<String> sportsQuestions = new LinkedList<>();
    private LinkedList<String> rockQuestions = new LinkedList<>();
    private int currentPlayerIndex = 0;
    private boolean currentPlayerIsGettingOutOfPenaltyBox;

    // Initialize question categories
    private static final String CATEGORY_POP = "Pop";
    private static final String CATEGORY_SCIENCE = "Science";
    private static final String CATEGORY_SPORTS = "Sports";
    private static final String CATEGORY_ROCK = "Rock";

    // Constructor to populate questions in categories
    public Game() {
        for (int i = 0; i < NUM_QUESTIONS_PER_CATEGORY; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast("Science Question " + i);
            sportsQuestions.addLast("Sports Question " + i);
            rockQuestions.addLast("createRockQuestion" + i);
        }
    }

    // Check if game is playable with at least 2 players
    public boolean isPlayable() {
        return players.size() >= 2;
    }

    // Add a new player to the game
    public boolean addPlayer(String playerName) {
        players.add(playerName);
        playerPositions[players.size() - 1] = 0;
        playerScores[players.size() - 1] = 0;
        playersInPenaltyBox[players.size() - 1] = false;

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());

        return true;
    }

    // Get number of players in the game
    public int getNumPlayers() {
        return players.size(); 
    }

    // Roll dice for current player
    public void roll(int roll) {
        String currentPlayerName = players.get(currentPlayerIndex);

        System.out.println(currentPlayerName + " is the current player");
        System.out.println("They have rolled a " + roll);

        // Check if current player is in penalty box
        if (playersInPenaltyBox[currentPlayerIndex]) {
            // Check if roll is odd to get out of penalty box
            if (roll % 2 != 0) {
                currentPlayerIsGettingOutOfPenaltyBox = true;

                System.out.println(currentPlayerName + " is getting out of the penalty box");
                playerPositions[currentPlayerIndex] += roll;
                if (playerPositions[currentPlayerIndex] > 11) {
                    playerPositions[currentPlayerIndex] -= 12;
                }
