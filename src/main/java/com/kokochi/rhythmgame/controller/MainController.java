package com.kokochi.rhythmgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    @FXML
    private void loadGameListPage(ActionEvent event) throws Exception {
        Parent gameListPage = FXMLLoader.load(getClass().getResource("/com/kokochi/rhythmgame/view/game-list-page.fxml"));
        Scene scene = new Scene(gameListPage);

        // 이벤트의 소스 (버튼)을 사용하여 현재 Stage를 얻습니다.
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        currentStage.setScene(scene);
    }
}
