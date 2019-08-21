package sample;


import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.media.AudioClip;

import static sample.Constants.*;

public class SoundButton extends Button {

    private AudioClip sound;
    private KeyCode keybind;

    SoundButton(KeyCode keybind, String text, String path){
        super();
        sound = new AudioClip(path);
        this.keybind = keybind;
        setText(keybind.toString()+"\n"+text);
//        using static methods "pressed" and "released" from Constants class
        released(this);
        setOnMousePressed(event -> pressed(this));
        setOnMouseReleased(event -> released(this));

        setMinSize(100,75);
        setMaxSize(100,75);
        setOnAction(event -> playSound());
    }

    void playSound(){
        if (sound.getCycleCount() == AudioClip.INDEFINITE){
            sound.setCycleCount(0);
            sound.stop();
        }
        sound.play();
    }
    void repeatSound(){
        sound.setCycleCount(AudioClip.INDEFINITE);
        sound.play();
    }
    void stopSound(){
        sound.setCycleCount(0);
        sound.stop();

    }
    boolean isPlaying(){
        if (sound.isPlaying()){
            return true;
        } else{
            return false;
        }
    }

    public KeyCode getKeybind() {
        return keybind;
    }
}
