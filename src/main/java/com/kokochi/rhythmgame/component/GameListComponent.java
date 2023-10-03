package com.kokochi.rhythmgame.component;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameListComponent extends VBox {

    private final Stage stage;

    public GameListComponent(Stage stage) {
        this.stage = stage;

        Label titleLabel = new Label("게임 목록");

        // 게임 목록을 로드하고 표시하는 로직 필요...

        // 예시 게임 아이템
        HBox gameItem = new HBox();
        ImageView thumbnail = new ImageView(); // 썸네일 이미지 설정 필요
        Label gameTitle = new Label("게임 제목");
        Button playButton = new Button("시작");
        Button saveButton = new Button("저장");
        Button deleteButton = new Button("삭제");
        gameItem.getChildren().addAll(thumbnail, gameTitle, playButton, saveButton, deleteButton);

        // 메인 페이지로 돌아가기 위한 버튼 생성
        Button backButton = new Button("메인 페이지로 돌아가기");
        backButton.setOnAction(event -> {
            // 이전 Scene으로 돌아감
            System.out.println("TEST :: 메인 페이지로 돌아가기");
            stage.setScene((Scene) stage.getUserData());
        });

        this.getChildren().addAll(titleLabel, gameItem, backButton);
    }
}
