package com.kokochi.javarhythmgame;

import com.kokochi.javarhythmgame.model.DataItem;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TournamentApplication extends Application {
    List<DataItem> data = new ArrayList<>();
    private int currentRound = 0;
    private Pane leftPane, rightPane;

    @Override
    public void start(Stage primaryStage) {
        initializeData();
        Collections.shuffle(data);

        HBox root = new HBox();

        leftPane = new Pane();
        rightPane = new Pane();

        HBox.setHgrow(leftPane, Priority.ALWAYS);
        HBox.setHgrow(rightPane, Priority.ALWAYS);

        updateUI();

        root.getChildren().addAll(leftPane, rightPane);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("월드컵 토너먼트 게임");
        primaryStage.setScene(scene);
        primaryStage.setWidth(1600);
        primaryStage.setHeight(900);
        primaryStage.show();
    }

    private void initializeData() {
        for (int i = 1; i <= 32; i++) {
            data.add(new DataItem("문호 스트레이 독스 " + i + "기", "/img/bungo_straydogs_5.jpg", "문호 스트레이 독스 " + i + "기"));
        }
    }

    private void updateUI() {
        StackPane leftImageStack = createImageStack(data.get(currentRound * 2).getImagePath());
        StackPane rightImageStack = createImageStack(data.get(currentRound * 2 + 1).getImagePath());

        Label leftLabel = createOverlayLabel(data.get(currentRound * 2).getDescription());
        Label rightLabel = createOverlayLabel(data.get(currentRound * 2 + 1).getDescription());

        StackPane leftStack = new StackPane(leftImageStack, leftLabel);
        StackPane rightStack = new StackPane(rightImageStack, rightLabel);

        leftPane.getChildren().setAll(leftStack);
        rightPane.getChildren().setAll(rightStack);

        leftPane.setOnMouseClicked(event -> {
            proceedTournament(currentRound * 2);
        });

        rightPane.setOnMouseClicked(event -> {
            proceedTournament(currentRound * 2 + 1);
        });
    }


    private void proceedTournament(int winnerIndex) {
        data.remove(winnerIndex == currentRound * 2 ? (currentRound * 2 + 1) : (currentRound * 2));
        if (data.size() == 1) {
            showWinner();
        } else {
            currentRound++;
            if (currentRound * 2 + 1 >= data.size()) {
                currentRound = 0;
            }
            updateUI();
        }
    }

    private void showWinner() {
        VBox winnerBox = new VBox(new Label("Winner: " + data.get(0)));
        leftPane.getChildren().clear();
        rightPane.getChildren().clear();
        leftPane.getChildren().add(winnerBox);
    }

    private Node createImageContainer(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(800);
        imageView.setFitHeight(850);
        imageView.setPreserveRatio(true);

        Pane imageContainer = new Pane(imageView);
        imageContainer.setStyle("-fx-background-color: black;");
        imageContainer.setMinSize(800, 850);

        imageView.layoutXProperty().bind(Bindings.subtract(400, imageView.fitWidthProperty().divide(2)));
        imageView.layoutYProperty().bind(Bindings.subtract(425, imageView.fitHeightProperty().divide(2)));

        return imageContainer;
    }

    private Label createOverlayLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-background-color: rgba(255, 255, 255, 0.6); -fx-padding: 5px; -fx-border-color: black; -fx-border-width: 1px;");
        label.setMaxWidth(Double.MAX_VALUE);
        StackPane.setAlignment(label, Pos.BOTTOM_CENTER);  // 이미지의 중앙 아래에 라벨 위치 설정
        return label;
    }

    private StackPane createImageStack(String imagePath) {
        Image image = new Image(imagePath);
        ImageView imageView = new ImageView(image);

        imageView.setFitWidth(800);
        imageView.setFitHeight(850);
        imageView.setPreserveRatio(true);

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: black;");
        stackPane.setPrefSize(800, 850);
        stackPane.getChildren().add(imageView);

        return stackPane;
    }


    public static void main(String[] args) {
        launch();
    }
}
