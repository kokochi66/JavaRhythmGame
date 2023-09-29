module com.kokochi.javarhythmgame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kokochi.javarhythmgame to javafx.fxml;
    exports com.kokochi.javarhythmgame;
}