/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement.controller;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.octicons.OctIconView;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import utils.ConnectionClass;

/**
 *
 * @author EddyF
 */
public class LoginPageController implements Initializable {

    // labels
    @FXML
    private Label label;
    @FXML
    private Label lbl_msg;

    // Achor Panes
    @FXML
    private AnchorPane Signin_Pane;
    @FXML
    private AnchorPane confirmExit_pane;

    // user  fields
    @FXML
    private JFXTextField txt_username;
    @FXML
    private JFXPasswordField txt_password;

    // buttons
    @FXML
    private JFXButton forgotpassword_btn;
    @FXML
    private JFXButton submitBtn;
    @FXML
    private JFXButton logDash_stayBtn;
    @FXML
    private JFXButton logDash_yesBtn;

    @FXML
    private void exitLogin(MouseEvent event) {
        confirmExit_pane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(confirmExit_pane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    private void minimiseLogin(MouseEvent event) {
        Stage stage = (Stage) Signin_Pane.getScene().getWindow();
        stage = (Stage) ((OctIconView) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void leave_appBtn(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void backtoSignin_btn(MouseEvent event) {
        Signin_Pane.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(Signin_Pane);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
        confirmExit_pane.setVisible(false);
    }

//    @FXML
//    private void handleSubmitBtn(ActionEvent event) {
//
//    }
    @FXML
    private void handleSubmitBtn(MouseEvent event) throws SQLException {
        
        loginValidation();

    }

    
    public void loginValidation()  throws SQLException{
                ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        Statement statement = connection.createStatement();
        String sql = " SELECT * FROM admins WHERE username= '" + txt_username.getText() + "' AND password= '" + txt_password.getText() + "'; ";
        ResultSet resultSet = statement.executeQuery(sql);

//        if(!connection){
//            lbl_msg.setText("Wrong");
//        } else {
//        }
        
        if (txt_username.equals(null) && txt_password.equals(null)) {
            Image image = new Image("hospitalmanagement/images/icons8_Natural_Food_100px.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Error")
                    .text("All Fields are Empty")
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on Notification");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        } else if (resultSet.next()) {
            Image image = new Image("hospitalmanagement/images/icons8_ok_hand_64px.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Login Success")
                    .text("You are Successfully Logged in")
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on Notification");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();

            try {

//                Node node = (Node) event.getSource();
//                Stage stage = (Stage) node.getScene().getWindow();
//                stage.close();
//
//                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("fxml/Dashboard_page.fxml")));
//                stage.setScene(scene);
//                stage.show();
                Parent parent = FXMLLoader.load(getClass().getResource("/hospitalmanagement/fxml/hospitalDashboard.fxml"));

                String path = "hospitalmanagement/images/icons8_Natural_Food_100px.png";
                Image img = new Image(path);
                Stage stage = new Stage();
                stage.setTitle("Home | Dashboard");
                stage.getIcons().add(0, img);
                stage.setScene(new Scene(parent));
                stage.initOwner(((Stage) Signin_Pane.getScene().getWindow()));
//            stage.setMinWidth(1200);
//            stage.setMinHeight(750);
//            stage.setMaximized(true);
                stage.show();
                new Bounce(parent).play();
               
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }

        } else if (!resultSet.next()) {
            Image image = new Image("hospitalmanagement/images/icons8_bug_filled_50px_2.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Error")
                    .text("Username or Password is wrong")
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER)
                    .onAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent event) {
                            System.out.println("Clicked on Notification");
                        }
                    });
            notificationBuilder.darkStyle();
            notificationBuilder.show();
        } else {
            lbl_msg.setText("Wrong");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Signin_Pane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if(event.getCode()== KeyCode.ENTER){
                try {
                    loginValidation();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginPageController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }
        });
    }

}
