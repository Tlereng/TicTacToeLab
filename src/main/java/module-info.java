module com.example.tictactoelab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tictactoelab to javafx.fxml;
    exports com.example.tictactoelab;
}