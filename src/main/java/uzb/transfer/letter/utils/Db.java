package uzb.transfer.letter.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import uzb.transfer.letter.dto.Language;

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
    public static void writeIntoFile(String fromC,String from, String toC, String to, String direction){
        try {
            PrintWriter printWriter = new PrintWriter(new File(letterFormation));
            printWriter.append(fromC +" " + from +" " + toC + " " + to + " " + direction);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<Language> getAllLanguages(String direction){
        System.out.println(direction);
        return new ArrayList<>();
    }



}
