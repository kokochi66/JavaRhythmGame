module com.kokochi.rhythmgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.kokochi.rhythmgame to javafx.fxml;
    opens com.kokochi.rhythmgame.controller to javafx.fxml; // 이 줄을 추가


    exports com.kokochi.rhythmgame;
    exports com.kokochi.rhythmgame.controller to javafx.fxml;
}