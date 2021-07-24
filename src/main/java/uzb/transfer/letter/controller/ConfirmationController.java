package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ConfirmationController implements Initializable {

    @FXML
    private Button yes;

    @FXML
    private Button no;

    @Override public void initialize(URL location, ResourceBundle resources) {

        yes.setOnAction(event -> {
            System.exit(0);
        });

        no.setOnAction(event -> {
           Node node = (Node) event.getSource();
           Stage stage = (Stage) node.getScene().getWindow();
           stage.close();
        });

    }
}
