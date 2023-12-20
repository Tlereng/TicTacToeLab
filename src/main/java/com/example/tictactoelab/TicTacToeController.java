package com.example.tictactoelab;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class TicTacToeController {
    // Labels representing cells in the game grid
    public Label label1;
    public Label label2;
    public Label label3;
    public Label label4;
    public Label label5;
    public Label label6;
    public Label label7;
    public Label label8;
    public Label label9;
    // Labels displaying player and computer scores
    public Label playerScore;
    public Label computerScore;
    // Model instance
    private Model model = new Model();
    // Initialize method to set up bindings and initialize UI elements
    public void initialize(){
        label1.textProperty().bind(model.cell1Property());
        label2.textProperty().bind(model.cell2Property());
        label3.textProperty().bind(model.cell3Property());
        label4.textProperty().bind(model.cell4Property());
        label5.textProperty().bind(model.cell5Property());
        label6.textProperty().bind(model.cell6Property());
        label7.textProperty().bind(model.cell7Property());
        label8.textProperty().bind(model.cell8Property());
        label9.textProperty().bind(model.cell9Property());
        // Bind player and computer scores to corresponding properties in the model
        playerScore.textProperty().bind(Bindings.createStringBinding(()->Integer.toString(model.getPlayerScore()),model.playerScoreProperty()));
        computerScore.textProperty().bind(Bindings.createStringBinding(()->Integer.toString(model.getComputerScore()),model.computerScoreProperty()));




    }
    // Handle a label click event
    public void labelClicked(MouseEvent mouseEvent) {
        // Extract the cell ID from the label's ID
        int id = Integer.parseInt(((Label)mouseEvent.getSource()).getId().substring(5));
        model.cellClicked(id);
    }
    // Handle the restart game button click event
    public void RestartGame(ActionEvent actionEvent) {
        model.restartGame();

    }
}