package sample;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import static sample.IO.soundList;

class SoundBoard {
    final Stage soundBoardStage;
    final Scene soundBoardScene;
    final GridPane soundBoardPane;
    double xOffset;
    double yOffset;

    SoundBoard() {
        IO.loadSounds();
        soundBoardStage = new Stage();
        soundBoardPane = Constants.defaultPane();
        soundBoardScene = new Scene(soundBoardPane, 1280, 720);

        soundBoardPane.setOnMousePressed(event -> {
            xOffset = soundBoardStage.getX() - event.getScreenX();
            yOffset = soundBoardStage.getY() - event.getScreenY();
        });
        soundBoardPane.setOnMouseDragged(event -> {
            soundBoardStage.setX(event.getScreenX() + xOffset);
            soundBoardStage.setY(event.getScreenY() + yOffset);
        });

        soundBoardStage.setScene(soundBoardScene);
        soundBoardStage.setResizable(false);
        soundBoardStage.initStyle(StageStyle.UNDECORATED);
        soundBoardStage.show();

        soundBoardPane.getChildren().addAll(soundList);

        int row = 0;
        int column = 0;
        for (int i = 0; i < soundList.size(); i++) {
            if (i % 6 == 0) {
                row++;
                column = 0;
            }
            GridPane.setConstraints(soundList.get(i), column, row);
            column++;
        }

    }
}
