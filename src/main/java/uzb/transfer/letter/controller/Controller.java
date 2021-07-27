package uzb.transfer.letter.controller;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import uzb.transfer.letter.utils.Additions;

public class Controller extends Additions implements Initializable {



    @FXML
    private JFXComboBox selectedLanguage;


    public void initialize(URL location, ResourceBundle resources) {
        super.loadLanguages(selectedLanguage);

    }


}
