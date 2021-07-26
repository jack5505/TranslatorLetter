package uzb.transfer.letter.utils;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Additions {

    protected void closeWithEvent(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

}
