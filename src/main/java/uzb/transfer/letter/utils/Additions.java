package uzb.transfer.letter.utils;

import com.jfoenix.controls.JFXComboBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Additions <S,T> {

    protected void closeWithEvent(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.close();
    }

    protected void makeEmpty(TextField makeEmpty){
        makeEmpty.setText("");
    }

    protected void setColumn(TableColumn<S,T> column,String name){
        column.setCellValueFactory(new PropertyValueFactory<S,T>(name));
    }


    protected void loadLanguages(JFXComboBox selected){
        selected.getItems().addAll(Db.readFromText());
        selectLanguage(selected);
    }

    private void selectLanguage(JFXComboBox selected) {
        selected.getSelectionModel().select(Db.checkSelectedLanguage());
    }

}
