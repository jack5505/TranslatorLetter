package uzb.transfer.letter.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
        //TODO when you click each of fxml window it opens as many you clicked
        close.setOnAction(event -> {
            callOtherScreen("Exit",Windows.Main.confirmation,StageStyle.UTILITY);
        });


        settings.setOnAction(event -> {
            callOtherScreen("Settings",Windows.Main.settings,null);
        });

        mainMenu.setOnAction(event -> {
            callOtherScreen("Transfer Letter",Windows.Main.main,null);
        });

        about.setOnAction(event -> {
            callOtherScreen("about",Windows.Main.about,StageStyle.UTILITY);
        });



    }

    private void callOtherScreen(String title, String url,StageStyle style){
        Window window = new Window(title, url);
        if(style != null)
            window.setStageStyle(style);
        window.show();


    }
}
