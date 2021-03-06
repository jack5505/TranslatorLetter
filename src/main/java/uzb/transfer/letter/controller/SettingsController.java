package uzb.transfer.letter.controller;

import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;
import uzb.transfer.letter.dto.Language;
import uzb.transfer.letter.utils.Additions;
import uzb.transfer.letter.utils.Db;
import uzb.transfer.letter.utils.Window;
import uzb.transfer.letter.utils.Windows;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class SettingsController extends Additions implements Initializable {

    @FXML
    private JFXComboBox combo;

    @FXML
    private TableView<Language> table;

    @FXML
    private Button add;


    @FXML
    private TableColumn<Language,String> fnumber;

    @FXML
    private TableColumn<Language,String> fromCapitalLetter;

    @FXML
    private TableColumn<Language,String>  fromLetter;

    @FXML
    private TableColumn<Language,String>  toCapitalLetter;

    @FXML
    private TableColumn<Language,String> toLetter;






    @Override public void initialize(URL location, ResourceBundle resources) {
           super.loadLanguages(combo);
           combo.valueProperty().addListener(new ChangeListener() {
               @Override public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                   //This begining of this
                   if(oldValue == null){

                   }else{
                       clearAndFillTable(newValue.toString());
                   }
               }
           });



           add.setOnAction(event -> {
               Window window = new Window("Add or modify", Windows.Main.add);
               AddModifyController addModifyController = window.getController();
               addModifyController.setSettingsController(this);
               addModifyController.setDirectionTransfer(combo.getSelectionModel().getSelectedItem().toString());
               window.show();
           });

           super.setColumn(fnumber,"fnumber");
           super.setColumn(fromCapitalLetter,"fromCapitalLetter");
           super.setColumn(fromLetter,"fromLetter");
           super.setColumn(toCapitalLetter,"toCapitalLetter");
           super.setColumn(toLetter,"toLetter");
           fillTable(combo.getSelectionModel().getSelectedItem().toString());


    }




    // Clear all data from Table
    public void clearTable(){
        table.getItems().clear();
    }

    // add new Data into table by direction
    public void fillTable(String direction){
        table.getItems().addAll(Db.getAllLanguages(direction));
    }

    // combile two methods method
    public void clearAndFillTable(String direction){
        clearTable();
        fillTable(direction);
    }






}
