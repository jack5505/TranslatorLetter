package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import uzb.transfer.letter.utils.Window;
import uzb.transfer.letter.utils.Windows;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class HeaderController implements Initializable {


    @FXML
    private MenuItem openFile;

    @FXML
    private MenuItem settings;

    @FXML
    private MenuItem close;

    @FXML
    private MenuItem mainMenu;

    @FXML
    private MenuItem about;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        close.setOnAction(event -> {
            callOtherScreen("Exit",Windows.Main.confirmation);
        });


        settings.setOnAction(event -> {
            callOtherScreen("Settings",Windows.Main.settings);
        });

        mainMenu.setOnAction(event -> {
            callOtherScreen("Transfer Letter",Windows.Main.main);
        });

    }

    private void callOtherScreen(String title, String url){
        Window window = new Window(title, url);
        window.show();
    }
}
