package uzb.transfer.letter.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Db {
    public static final String transferDirectionList = "db.txt";
    public static final String defaultSettings = "selected.txt";
    public static final String letterFormation = "letters.txt";

    public static Scanner readFromFile(String text){
        try {
            checkFile(text);
            Scanner cin = new Scanner(new FileReader(text));
            return cin;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void checkFile(String letterFormation) throws IOException {
        File file = new File(letterFormation);
        if(file.createNewFile()){
            System.out.println("file created " + letterFormation);
        }else{
            System.out.println("File existed " + letterFormation);
        }
    }

    public static String checkSelectedLanguage(){
        try {
            checkFile(defaultSettings);
            Scanner cin = readFromFile(defaultSettings);
            while (cin.hasNext()){
                return cin.nextLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "no";
    }

}
