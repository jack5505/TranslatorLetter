package uzb.transfer.letter.utils;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/*
 *
 *  @author Sabirov Jakhongir
 *
 */
public class Window {
    private Stage stage;
    private String title;
    private String url;
    private FXMLLoader loader;
    private Double width;
    private Double height;

    public Window(String title, String url) {
        this.title = title;
        this.url = url;
        this.init();
    }
    public Window(String title, String url,double width, double height) {
        this.title = title;
        this.url = url;
        this.width = width;
        this.height = height;
        this.init();
    }



    private void init() {
        System.out.println(this.url);
        loader = new FXMLLoader(getClass().getClassLoader().getResource(url));
        try
        {
            Parent root = loader.load();
            stage = new Stage();
            if(this.width != null && this.height != null){
                stage.setScene(new Scene(root,this.width,this.height));
            }else{
                stage.setScene(new Scene(root));
            }
            stage.setTitle(this.title);
            stage.initModality(Modality.APPLICATION_MODAL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setModality(Modality modality) {
        this.stage.initModality(modality);
    }

    public void setStageStyle(StageStyle stageStyle) {
        this.stage.initStyle(stageStyle);
    }

    public void show(){
        stage.show();
    }

    public void setFullScreen(boolean yes){
        stage.setMaximized(yes);
    }

    public void showAndWait(){
        stage.showAndWait();
    }

    public <T> T getController(){
        return loader.getController();
    }

    public Stage getStage(){
        return this.stage;
    }
}
