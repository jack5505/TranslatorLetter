package uzb.transfer.letter.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public static List<Language> list = new ArrayList<>();
    public static Map<String,String> hashmap = new HashMap<>();

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
            // Bufferedwriter new FileWriter in constructor append make it true
            BufferedWriter printWriter = new BufferedWriter(new FileWriter(new File(letterFormation),true));
            printWriter.append(fromC +" " + from +" " + toC + " " + to + " " + direction + "\n");
            //printWriter.append(fromC +" " + from +" " + toC + " " + to + " " + direction);
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Language> getAllLanguages(String direction){
        System.out.println(direction);
        Scanner cin = readFromFile(letterFormation);
        list = new ArrayList<>();
        int cnt = 0;
        Language language = null;
        while (cin.hasNext())
        {
            String text = cin.next();
            if(cnt % 6 == 0){
                language = new Language();
                language.setId(cnt +" ");
                cnt++;
            }
            if(cnt % 6 == 1){
                language.setFromCapitalLetter(text);
            }
            if(cnt % 6 == 2){
                language.setFromLetter(text);
            }
            if(cnt % 6 == 3){
                language.setToCapitalLetter(text);
            }
            if(cnt % 6 == 4){
                language.setToLetter(text);
            }
            if(cnt % 6 == 5){
                //System.out.println("[" + text + "]  [" + direction +"]");
                if(text.equals(direction)){
                    list.add(language);
                }
            }
            cnt++;
        }
        return list;
    }


    public static List<String> readFromText() {
        List<String> list = new ArrayList<>();
        Scanner scanner = Db.readFromFile(Db.transferDirectionList);
        if(scanner != null){
            while (scanner.hasNext()){
                list.add(scanner.nextLine());
            }
        }
        return list;
    }

    public static void getIntoHashMap(){
        if(!list.isEmpty()){
            for (Language language : list) {
                hashmap.put(language.getFromCapitalLetter(),language.getToCapitalLetter());
                hashmap.put(language.getFromLetter(),language.getToLetter());
            }
        }
    }

    /*
     * This method will use when you want to rereset into new language
     * and value will be appear into HashMap
     */
    public static void resetIntoNewLanguage(String direction){
            getAllLanguages(direction);
            getIntoHashMap();

    }



}
