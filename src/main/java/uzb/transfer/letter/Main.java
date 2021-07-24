package uzb.transfer.letter;

import javafx.application.Application;
import javafx.stage.Stage;
import uzb.transfer.letter.utils.Window;
import uzb.transfer.letter.utils.Windows;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Window window = new Window("Transfer Letter", Windows.Main.main);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
