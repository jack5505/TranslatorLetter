package uzb.transfer.letter.utils;

import java.util.Map;
import java.util.Scanner;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class TranslateLogic {

    public static void main(String[] args) {



    }

    public static String translate(String text){
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < text.length();i ++){
            builder.append(Db.hashmap.get(text.charAt(i)));
        }
        return builder.toString();
    }
    
}
