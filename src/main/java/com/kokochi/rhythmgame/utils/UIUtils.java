package com.kokochi.rhythmgame.utils;

import com.kokochi.rhythmgame.enumuration.MediaType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;

public class UIUtils {

    public static StackPane createMediaStack(String mediaPath) {
        MediaType mediaType = MediaType.determineMediaType(mediaPath);

        switch (mediaType) {
            case IMAGE:
                return createImageStack(mediaPath);
            case VIDEO:
                return createVideoStack(mediaPath);
            default:
                System.err.println("Unsupported media type for: " + mediaPath);
                return new StackPane();
        }
    }



    public static StackPane createImageStack(String imagePath) {
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

    public static StackPane createVideoStack(String videoPath) {

        Media media = new Media(new File(videoPath).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true); // 동영상이 자동으로 플레이되도록 설정
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // 동영상을 무한 반복하도록 설정

        MediaView mediaView = new MediaView(mediaPlayer);
        mediaView.setFitWidth(800); // 동영상의 너비 설정
        mediaView.setFitHeight(850); // 동영상의 높이 설정
        mediaView.setPreserveRatio(true); // 동영상의 원래 비율을 유지

        StackPane stackPane = new StackPane();
        stackPane.setStyle("-fx-background-color: black;");
        stackPane.setPrefSize(800, 850);
        stackPane.getChildren().add(mediaView);

        return stackPane;
    }

}
