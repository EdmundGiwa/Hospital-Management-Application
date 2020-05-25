/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalmanagement.controller;

import animatefx.animation.Bounce;
import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import tray.animations.FadeAnimation;

/**
 * FXML Controller class
 *
 * @author EddyF
 */
public class HospitalDashboardController implements Initializable {

    @FXML
    private AnchorPane mainDashboard;

    @FXML
    private AnchorPane mainHos_Dashboard;

    @FXML
    private ImageView imageSlideShow;

    @FXML
    private JFXButton dashBtn;

    @FXML
    private JFXButton departmentBtn;

    @FXML
    private JFXButton doctorBtn;

    @FXML
    private JFXButton patientBtn;

    @FXML
    private JFXButton nurseBtn;

    @FXML
    private JFXButton pharmarcistBtn;

    @FXML
    private JFXButton laboratoristBtn;

    @FXML
    private JFXButton accountantBtn;

    @FXML
    private JFXButton profileBtn;

    @FXML
    private JFXButton settingsBtn;

    // anchor pane pages start
    @FXML
    private AnchorPane departmentPage;
    @FXML
    private AnchorPane doctorPage;
    @FXML
    private AnchorPane patientPage;
    @FXML
    private AnchorPane NursePage;
    @FXML
    private AnchorPane pharmarcistPage;

    // end of anchor pane pages
    @FXML
    private JFXButton backHomeBtn;
    @FXML
    private JFXButton backHomeBtn1;

    @FXML
    private JFXButton viewDoctorsBtn;
    @FXML
    private JFXButton viewPatientsBtn;

    // Stack Panes
    @FXML
    private StackPane viewDocTblStack;
    @FXML
    private StackPane viewPatientTblStack;
    @FXML
    private StackPane viewNurseTblStack;
    @FXML
    private StackPane viewPharmarcistTblStack;
    // end of stack panes

    //Code to go back to dashboard
    @FXML
    void backHomeHandle(ActionEvent event) {
        mainHos_Dashboard.setVisible(true);
        departmentPage.setVisible(false);
        doctorPage.setVisible(false);
        patientPage.setVisible(false);
        NursePage.setVisible(false);
        pharmarcistPage.setVisible(false);
    }
    //Code to go back to dashboard end

    // action event to enter selected pages
    @FXML
    void departmentHandle(ActionEvent event) {
        departmentPage.setVisible(true);
    }

    @FXML
    void doctorHandle(ActionEvent event) {
        doctorPage.setVisible(true);
        departmentPage.setVisible(false);
    }

    @FXML
    void patientHandle(ActionEvent event) {
        patientPage.setVisible(true);
        doctorPage.setVisible(false);
        departmentPage.setVisible(false);
    }

    @FXML
    void nurseHandle(ActionEvent event) {
        NursePage.setVisible(true);
        patientPage.setVisible(false);
        doctorPage.setVisible(false);
        departmentPage.setVisible(false);
    }

    @FXML
    void pharmacistHandle(ActionEvent event) {
        pharmarcistPage.setVisible(true);
        NursePage.setVisible(false);
        patientPage.setVisible(false);
        doctorPage.setVisible(false);
        departmentPage.setVisible(false);
    }
    // action event to enter selected pages

    // Code to view all information table
    //start
    @FXML
    void openViewAllDoc(MouseEvent event) {
        viewDocTblStack.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(viewDocTblStack);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void openViewAllPatient(MouseEvent event) {
        viewPatientTblStack.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(viewPatientTblStack);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void openViewAllNurse(MouseEvent event) {
        viewNurseTblStack.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(viewNurseTblStack);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void openViewAllPharmacist(MouseEvent event) {
        viewPharmarcistTblStack.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(viewPharmarcistTblStack);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    //end
    // Code to view all information table
    //Code to go back to previous page start
    @FXML
    void backToDocHome(ActionEvent event) {
        viewDocTblStack.setVisible(false);
        doctorPage.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(doctorPage);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void backToPatientHome(ActionEvent event) {
        viewPatientTblStack.setVisible(false);
        patientPage.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(patientPage);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void backToNurseHome(ActionEvent event) {
        viewNurseTblStack.setVisible(false);
        NursePage.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(NursePage);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }

    @FXML
    void backToPharmacistHome(ActionEvent event) {
        viewPharmarcistTblStack.setVisible(false);
        pharmarcistPage.setVisible(true);
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.millis(500));
        fade.setNode(pharmarcistPage);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();
    }
    //Code to go back to previous page end

    @FXML
    private void openDash_departPage(ActionEvent event) throws IOException {
        System.out.println("clicked");
        Parent dash_page_parent = FXMLLoader.load(getClass().getResource("/hospitalmanagement/fxml/DashPage.fxml"));
        Scene dash_page_scene = new Scene(dash_page_parent);
        Stage dashStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dashStage.setScene(dash_page_scene);

//        String path = "hospitalmanagement/images/icons8_Natural_Food_100px.png";
//        Image img = new Image(path);
//        dashStage.setTitle("Dashboard | Department");
//        dashStage.getIcons().add(0, img);
//        dashStage.show();
        new FadeIn(dash_page_parent).play();
    }

    // for my slide show
    //begining
    int count;

    public void slideShow() {
        ArrayList<Image> images = new ArrayList<Image>();
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide2.jpg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide3.jpg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide4.jpeg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide5.jpeg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide6.jpg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide7.jpg"));
        images.add(new Image("hospitalmanagement/images/imageSlideShow/slide1.jpeg"));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            imageSlideShow.setImage(images.get(count));
            count++;

            if (count == 7) {
                count = 0;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
    // end

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        slideShow();

    }

}
