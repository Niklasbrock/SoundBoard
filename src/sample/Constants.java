package sample;

import com.sun.javafx.css.Size;
import com.sun.javafx.css.Style;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import static sample.IO.soundList;


class Constants {

    static void pressed(SoundButton soundButton){
        soundButton.setStyle("-fx-text-alignment: center;" + "-fx-font-size: 18;" + "-fx-text-fill: #98c0ff;" + "-fx-font-family: Calibri;"
                + "-fx-background-color: #6b1465;" + "-fx-background-image: url('file:src/assets/pictures/roundbuttonpressed.png')");
    }
    static void released(SoundButton soundButton){
        soundButton.setStyle("-fx-text-alignment: center;" + "-fx-font-size: 18;" + "-fx-text-fill: #98c0ff;" + "-fx-font-family: Calibri;"
                + "-fx-background-color: #6b1465;" + "-fx-background-image: url('file:src/assets/pictures/roundbutton.png')");
    }

    static GridPane defaultPane(){
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(25);
        pane.setVgap(25);
        pane.setStyle("-fx-background-image: url('file:src/assets/pictures/unicorn.gif');");

        pane.setOnKeyPressed(event -> {
            for (SoundButton soundButton : soundList) {
                if (event.isShiftDown() && event.getCode() == soundButton.getKeybind()) {
                    pressed(soundButton);
                    soundButton.repeatSound();
                } else if(soundButton.isPlaying() && event.isShiftDown() && event.getCode() == soundButton.getKeybind()) {
                    released(soundButton);
                    soundButton.stopSound();
                } else if (event.getCode() == soundButton.getKeybind()) {
                    pressed(soundButton);
                    soundButton.playSound();
                }
            }
        });
        pane.setOnKeyReleased(event -> {
            for (SoundButton soundButton : soundList) {
                if (event.isShiftDown() && event.getCode() == soundButton.getKeybind()) {
                    pressed(soundButton);
                } else if (event.getCode() == soundButton.getKeybind()) {
                    released(soundButton);
                }
            }
        });

        return pane;
    }
}
