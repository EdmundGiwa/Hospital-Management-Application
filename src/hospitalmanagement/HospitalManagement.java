/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement;

import animatefx.animation.ZoomIn;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author EddyF
 */
public class HospitalManagement extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/SplashScreen.fxml"));
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        
        stage.setScene(scene);
        stage.show();
        
           // app default icon
        Image image = new Image("hospitalmanagement/images/icons8_Natural_Food_100px.png");
        stage.getIcons().add(image);
        new ZoomIn(root).play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
