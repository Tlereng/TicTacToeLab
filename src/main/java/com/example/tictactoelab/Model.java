package com.example.tictactoelab;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Random;

public class Model {

    // Properties for player and computer scores
    IntegerProperty playerScore = new SimpleIntegerProperty(0);
    IntegerProperty computerScore = new SimpleIntegerProperty(0);

    // Properties for individual cells in the game grid
    StringProperty cell1 = new SimpleStringProperty("");
    StringProperty cell2 = new SimpleStringProperty("");
    StringProperty cell3 = new SimpleStringProperty("");
    StringProperty cell4 = new SimpleStringProperty("");
    StringProperty cell5 = new SimpleStringProperty("");
    StringProperty cell6 = new SimpleStringProperty("");
    StringProperty cell7 = new SimpleStringProperty("");
    StringProperty cell8 = new SimpleStringProperty("");
    StringProperty cell9 = new SimpleStringProperty("");

    // Game state variables
    boolean gameOver = false;
    String currentPlayer = "X";
    private static final String PLAYER = "X";
    private static final String COMPUTER = "O";

    // Getters and setters for player and computer scores
    public int getPlayerScore() {
        return playerScore.get();
    }

    public IntegerProperty playerScoreProperty() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore.set(playerScore);
    }

    public int getComputerScore() {
        return computerScore.get();
    }

    public IntegerProperty computerScoreProperty() {
        return computerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore.set(computerScore);
    }

    // Check if the game is over
    public boolean isGameOver() {
        return gameOver;
    }

    // Set the game over status
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    // Get the current player
    public String getCurrentPlayer() {
        return currentPlayer;
    }

    // Set the current player
    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    // Array representing possible winning combinations
    static final int[][] possibleWins = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {1, 4, 7},
            {2, 5, 8},
            {3, 6, 9},
            {1, 5, 9},
            {3, 5, 7}
    };

    // Handle a cell click
    public void cellClicked(int id) {
        if (!cellValue(id).isEmpty() || gameOver) {
            return;
        }

        // Set the current player's mark in the clicked cell
        switch (id) {
            case 1 -> setCell1(currentPlayer);
            case 2 -> setCell2(currentPlayer);
            case 3 -> setCell3(currentPlayer);
            case 4 -> setCell4(currentPlayer);
            case 5 -> setCell5(currentPlayer);
            case 6 -> setCell6(currentPlayer);
            case 7 -> setCell7(currentPlayer);
            case 8 -> setCell8(currentPlayer);
            case 9 -> setCell9(currentPlayer);
        }

        // Check if the game is over and switch players
        checkForGameOver();
        if (!gameOver) {
            changePlayer();
            makeComputerMove();
        }
    }

    // Make a move for the computer
    private void makeComputerMove() {
        if (!gameOver && currentPlayer.equals(COMPUTER)) {
            Random random = new Random();
            int computerMove;
            do {
                computerMove = random.nextInt(9) + 1;
            } while (!cellValue(computerMove).isEmpty());

            // Set the computer's mark in the chosen cell
            switch (computerMove) {
                case 1 -> setCell1(COMPUTER);
                case 2 -> setCell2(COMPUTER);
                case 3 -> setCell3(COMPUTER);
                case 4 -> setCell4(COMPUTER);
                case 5 -> setCell5(COMPUTER);
                case 6 -> setCell6(COMPUTER);
                case 7 -> setCell7(COMPUTER);
                case 8 -> setCell8(COMPUTER);
                case 9 -> setCell9(COMPUTER);
            }

            // Check if the game is over and switch players
            checkForGameOver();
            changePlayer();
            makeComputerMove();
        }
    }

    // Prepare the game state for the next round
    private void prepareNextRound() {
        // Clear all cell values and reset game over status
        setCell1("");
        setCell2("");
        setCell3("");
        setCell4("");
        setCell5("");
        setCell6("");
        setCell7("");
        setCell8("");
        setCell9("");
        gameOver = false;
    }

    // Check if the game is over
    private void checkForGameOver() {
        for (var ids : possibleWins) {
            // Check for a winning combination
            if (!cellValue(ids[0]).isEmpty() && cellValue(ids[0]).equals(cellValue(ids[1]))
                    && cellValue(ids[1]).equals(cellValue(ids[2]))) {
                gameOver = true;
                // Update scores based on the winner
                if (cellValue(ids[0]).equals(PLAYER))
                    setPlayerScore(getPlayerScore() + 1);
                else
                    setComputerScore(getComputerScore() + 1);
                return;
            }
        }

        // Check for a tie
        gameOver = true;
        for (int i = 1; i < 10; i++) {
            if (cellValue(i).isEmpty()) {
                gameOver = false;
                break;
            }
        }
    }

    // Get the value of a specific cell
    private String cellValue(int id) {
        return switch (id) {
            case 1 -> getCell1();
            case 2 -> getCell2();
            case 3 -> getCell3();
            case 4 -> getCell4();
            case 5 -> getCell5();
            case 6 -> getCell6();
            case 7 -> getCell7();
            case 8 -> getCell8();
            case 9 -> getCell9();
            default -> "";
        };
    }

    // Set the value of a specific cell
    private void setCellValue(int id, String value) {
        switch (id) {
            case 1 -> setCell1(value);
            case 2 -> setCell2(value);
            case 3 -> setCell3(value);
            case 4 -> setCell4(value);
            case 5 -> setCell5(value);
            case 6 -> setCell6(value);
            case 7 -> setCell7(value);
            case 8 -> setCell8(value);
            case 9 -> setCell9(value);
        }
    }
    //Method to change player from person to computer
    private void changePlayer() {
        if (currentPlayer.equals(PLAYER))
            currentPlayer = COMPUTER;
        else
            currentPlayer = PLAYER;
    }

    // Getters and setters for individual cells
    public String getCell1() {
        return cell1.get();
    }

    public StringProperty cell1Property() {
        return cell1;
    }

    public void setCell1(String cell1) {
        this.cell1.set(cell1);
    }

    public String getCell2() {
        return cell2.get();
    }

    public StringProperty cell2Property() {
        return cell2;
    }

    public void setCell2(String cell2) {
        this.cell2.set(cell2);
    }

    public String getCell3() {
        return cell3.get();
    }

    public StringProperty cell3Property() {
        return cell3;
    }

    public void setCell3(String cell3) {
        this.cell3.set(cell3);
    }

    public String getCell4() {
        return cell4.get();
    }

    public StringProperty cell4Property() {
        return cell4;
    }

    public void setCell4(String cell4) {
        this.cell4.set(cell4);
    }

    public String getCell5() {
        return cell5.get();
    }

    public StringProperty cell5Property() {
        return cell5;
    }

    public void setCell5(String cell5) {
        this.cell5.set(cell5);
    }

    public String getCell6() {
        return cell6.get();
    }

    public StringProperty cell6Property() {
        return cell6;
    }

    public void setCell6(String cell6) {
        this.cell6.set(cell6);
    }

    public String getCell7() {
        return cell7.get();
    }

    public StringProperty cell7Property() {
        return cell7;
    }

    public void setCell7(String cell7) {
        this.cell7.set(cell7);
    }

    public String getCell8() {
        return cell8.get();
    }

    public StringProperty cell8Property() {
        return cell8;
    }

    public void setCell8(String cell8) {
        this.cell8.set(cell8);
    }

    public String getCell9() {
        return cell9.get();
    }

    public StringProperty cell9Property() {
        return cell9;
    }

    public void setCell9(String cell9) {
        this.cell9.set(cell9);
    }

    // Restart the game
    public void restartGame() {
        prepareNextRound();
    }
}
