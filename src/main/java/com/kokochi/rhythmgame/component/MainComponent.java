package com.kokochi.rhythmgame.component;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainComponent extends VBox {

    private final Stage stage;

    public MainComponent(Stage stage) {
        this.stage = stage;

        Label titleLabel = new Label("월드컵 게임");
        Button startButton = new Button("시작하기");
        Button loadButton = new Button("불러오기");
        Button createButton = new Button("제작하기");
        Button exitButton = new Button("나가기");
        startButton.setOnAction(event -> {
            // 게임 시작 목록 페이지로 이동하는 로직
            GameListComponent gameListPage = new GameListComponent(stage);
            Scene scene = new Scene(gameListPage);
            stage.setUserData(scene); // 현재 Scene 저장
            stage.setScene(scene);
        });

        // 다른 버튼에 대한 액션도 정의해야 함...

        this.getChildren().addAll(titleLabel, startButton, loadButton, createButton, exitButton);
    }
}