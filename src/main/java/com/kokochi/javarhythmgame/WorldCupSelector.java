package com.kokochi.javarhythmgame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class WorldCupSelector extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox root = new HBox();

        Pane leftPane = new Pane();
        Pane rightPane = new Pane();

        HBox.setHgrow(leftPane, Priority.ALWAYS);
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        leftPane.setMaxWidth(Double.MAX_VALUE);
        rightPane.setMaxWidth(Double.MAX_VALUE);

        leftPane.setStyle("-fx-background-color: #FFAAAA;");
        rightPane.setStyle("-fx-background-color: #AAAAFF;");

        leftPane.setOnMouseClicked(event -> {
            System.out.println("왼쪽 영역이 클릭되었습니다.");
        });

        rightPane.setOnMouseClicked(event -> {
            System.out.println("오른쪽 영역이 클릭되었습니다.");
        });

        root.getChildren().addAll(leftPane, rightPane);
        root.setPadding(new Insets(10)); // 옵션: 주위에 여백을 추가합니다.

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("월드컵 선택 게임 프로토타입");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}