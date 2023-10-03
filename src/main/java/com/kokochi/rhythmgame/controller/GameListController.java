package com.kokochi.rhythmgame.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class GameListController {

    @FXML
    private void loadMainPage() throws Exception {
        Parent mainPage = FXMLLoader.load(getClass().getResource("/com/kokochi/rhythmgame/view/main-page.fxml"));
        Scene scene = new Scene(mainPage);
        Stage currentStage = (Stage) scene.getWindow();
        currentStage.setScene(scene);
    }
}
