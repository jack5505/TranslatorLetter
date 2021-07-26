package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import uzb.transfer.letter.utils.Additions;
import uzb.transfer.letter.utils.Window;
import uzb.transfer.letter.utils.Windows;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class AddModifyController extends Additions implements Initializable {


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
            clicks();
    }

    private void clicks() {
           save.setOnAction(event -> {

           });
           cancel.setOnAction(event -> {
               Window window = new Window("are you sure ?" , Windows.Main.confirmation);
               if(checkFilled()){
                   ConfirmationController controller = window.getController();
                   controller.setSwitcher("add");
                   controller.setEvent(event);
                   window.show();
               }
               else
                    super.closeWithEvent(event);
           });
    }

    private boolean checkFilled() {
        return (!fromCLetter.getText().isEmpty() ||
               !fromLetter.getText().isEmpty()  ||
               !toLetter.getText().isEmpty()    ||
               !toCLetter.getText().isEmpty());
    }
}
