/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement.controller;

import animatefx.animation.ZoomIn;
import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author EddyF
 */
public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane hms_splashPane;

    @FXML
    private JFXProgressBar hmsPro_Bar;

    @FXML
    private Label textProgress;

    private double xOffset = 0;
    private double yOffset = 0;

    /**
     * initialize the controller class.
     */
    public void progressLoader()  {
        JFXProgressBar jbar = new JFXProgressBar();
        jbar.setProgress(-1.0f);
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
                new KeyValue(hmsPro_Bar.progressProperty(), 0),
                new KeyValue(jbar.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(20),
                        new KeyValue(hmsPro_Bar.progressProperty(), 1),
                        new KeyValue(jbar.progressProperty(), 1)));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            progressLoader();
            textLoader();
    }

  public void textLoader() {
        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws InterruptedException {

                updateMessage("Loading");
                Thread.sleep(10000);
//                updateMessage("Loading Dashboard");
//                // some actions
//                Thread.sleep(2000);
//                updateMessage("Loading UI");
//
//                //more  time consuming actions
//                Thread.sleep(2000);
//                updateMessage("Loading Database");
//
//                Thread.sleep(2500);
//                updateMessage("Finalizing");
//                Thread.sleep(3400);
//
//                //finally done
//                updateMessage("Done");
//                Thread.sleep(100);
                return null;
            }
        };

        textProgress.textProperty().bind(task.messageProperty());
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent e) {
                textProgress.textProperty().unbind();
                ((Stage) hms_splashPane.getScene().getWindow()).close();
                try {
                  String path = "/hospitalmanagement/images/icons8_Natural_Food_100px.png";

                    Image img = new Image(path);

                    Stage stage = new Stage();
                    stage.getIcons().add(0, img);
                    Parent root = FXMLLoader.load(SplashScreenController.this.getClass().getResource("/hospitalmanagement/fxml/LoginPage.fxml"));
                    Scene scene = new Scene(root);
                    stage.initStyle(StageStyle.TRANSPARENT);
                    scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                    stage.setTitle("Login | Hms");
                    stage.setScene(scene);
                    stage.centerOnScreen();
                    
                    new ZoomIn(root).play();
                    
                    stage.show();
                    Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
                    stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
                    stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 2);

                    //dragable login stage
                    root.setOnMousePressed((MouseEvent event) -> {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    });

                    root.setOnMouseDragged((MouseEvent event) -> {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    });//end of draggable stage
                } catch (IOException ex) {
                    Logger.getLogger(SplashScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }
}
