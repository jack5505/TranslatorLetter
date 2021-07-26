package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class AddModifyController implements Initializable {


    @FXML
    private TextField fromCLetter;

    @FXML
    private TextField fromLetter;

    @FXML
    private TextField toCLetter;

    @FXML
    private TextField toLetter;

    @FXML
    private Button save;

    @FXML
    private Button cancel;

    


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
