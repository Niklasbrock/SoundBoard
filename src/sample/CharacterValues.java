package sample;

import java.util.ArrayList;

public class CharacterValues {
    static ArrayList<String> charList;

    static String getChar(int number) {
        charList = new ArrayList<>();
        charList.add("A");
        charList.add("B");
        charList.add("C");
        charList.add("D");
        charList.add("E");
        charList.add("F");
        charList.add("G");
        charList.add("H");
        charList.add("I");
        charList.add("K");
        charList.add("L");
        charList.add("M");
        charList.add("N");
        charList.add("O");
        charList.add("P");
        charList.add("Q");
        charList.add("R");
        charList.add("S");
        charList.add("T");
        charList.add("U");
        charList.add("V");
        charList.add("W");
        charList.add("X");
        charList.add("Y");
        charList.add("Z");
        charList.add("F1");
        charList.add("F2");
        charList.add("F3");
        charList.add("F4");
        charList.add("F5");
        charList.add("F6");
        charList.add("F7");
        charList.add("F8");
        charList.add("F9");
        charList.add("F10");
        charList.add("F11");
        charList.add("F12");

        return charList.get(number);
    }
}
