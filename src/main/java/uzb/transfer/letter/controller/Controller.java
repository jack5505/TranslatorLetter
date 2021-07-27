package uzb.transfer.letter.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import uzb.transfer.letter.utils.Additions;

public class Controller extends Additions implements Initializable {


    @FXML
    private StackPane drag;

    @FXML
    private JFXComboBox selectedLanguage;
    //TODO think about refactoring here

    @FXML
    private JFXButton clickMe;

    public void initialize(URL location, ResourceBundle resources) {
        super.loadLanguages(selectedLanguage);
        Text text = new Text();
        drag.getChildren().add(text);

        drag.setOnDragOver(event -> {
            if(event.getDragboard().hasFiles()){
                event.acceptTransferModes(TransferMode.LINK);
            }
        });

        drag.setOnDragDropped(event -> {
            text.setText(event.getDragboard().getFiles().stream().map(File::getAbsolutePath).collect(Collectors.joining("\n")));
        });

        
    }


}
