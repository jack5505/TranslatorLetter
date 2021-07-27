package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uzb.transfer.letter.utils.Additions;
import uzb.transfer.letter.utils.Db;
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

    //TODO make input only one character letter to add this make implement in the future
    @FXML
    private TextField toLetter;

    @FXML
    private Button save;

    @FXML
    private Button cancel;

    private String directionTransfer;

    @FXML
    private Label info;


    private SettingsController settingsController;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
            clicks();
    }

    private void clicks() {
           save.setOnAction(event -> {
                Db.readFromFile(Db.letterFormation);
                //TODO need to check if all field filled or not
                Db.writeIntoFile(fromCLetter.getText(),fromLetter.getText(),toCLetter.getText(),toLetter.getText(),directionTransfer);
                super.makeEmpty(fromLetter);
                super.makeEmpty(fromCLetter);
                super.makeEmpty(toCLetter);
                super.makeEmpty(toLetter);
                info.setText(info.getText() + "  " + " YOZILDI ");
                settingsController.clearAndFillTable(directionTransfer);
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

    public String getDirectionTransfer() {
        return directionTransfer;
    }

    public void setDirectionTransfer(String directionTransfer) {
        this.directionTransfer = directionTransfer;
        info.setText(info.getText() +  "   " + this.directionTransfer);
    }

    public SettingsController getSettingsController() {
        return settingsController;
    }

    public void setSettingsController(SettingsController settingsController) {
        this.settingsController = settingsController;
    }
}
