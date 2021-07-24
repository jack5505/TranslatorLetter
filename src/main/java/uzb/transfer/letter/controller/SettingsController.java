package uzb.transfer.letter.controller;

import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class SettingsController implements Initializable {

    @FXML
    private JFXComboBox combo;

    @FXML
    private TableView table;

    @Override public void initialize(URL location, ResourceBundle resources) {
           combo.getItems().addAll(readFromText());
    }

    private List<String> readFromText() {
            List<String> list = new ArrayList<>();
            Scanner scanner = readFromFile();
            if(scanner != null){
              while (scanner.hasNext()){
                  list.add(scanner.nextLine());
              }
            }
        return list;
    }

    private Scanner readFromFile(){
        try {
            checkFile();
            Scanner cin = new Scanner(new FileReader("db.txt"));
            return cin;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void checkFile() throws IOException {
        File file = new File("db.txt");
        if(file.createNewFile()){
            System.out.println("file created");
        }else{
            System.out.println("File existed");
        }
    }
}
