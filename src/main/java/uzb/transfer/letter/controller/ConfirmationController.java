package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import uzb.transfer.letter.utils.Additions;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class ConfirmationController extends Additions implements Initializable  {

    @FXML
    private Button yes;

    @FXML
    private Button no;

    private String switcher;

    private ActionEvent event;

    @Override public void initialize(URL location, ResourceBundle resources) {

        yes.setOnAction(event -> {
                if(switcher.equals("add") && this.event != null){
                    closeWithEvent(this.event);
                }
                closeWithEvent(event);
        });

        no.setOnAction(event -> {
            closeWithEvent(event);
        });

    }

    protected void closeWithEvent(ActionEvent event) {
        super.closeWithEvent(event);
    }

    public String getSwitcher() {
        return switcher;
    }

    public void setSwitcher(String switcher) {
        this.switcher = switcher;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(ActionEvent event) {
        this.event = event;
    }
}
