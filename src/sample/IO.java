package sample;

import javafx.scene.input.KeyCode;

import java.io.File;
import java.util.ArrayList;


class IO {
    static ArrayList<SoundButton> soundList;

    static void loadSounds(){
        soundList = new ArrayList<>();
        int j = 0;
        for (File file : IO.importFiles()){
            soundList.add(new SoundButton(KeyCode.getKeyCode(CharacterValues.getChar(j)),
                    file.getName().replace(".wav", ""), "file:"+file.toString().replace("\\", "/")));
            j++;
        }
    }
    static ArrayList<File> importFiles(){
        ArrayList<File> fileList = new ArrayList<>();
        File folder = new File("src/assets/sounds/");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles){
            if(file.isFile()){
                fileList.add(file);
            }
        }
        return fileList;
    }

}
