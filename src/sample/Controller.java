package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private Button close_button;
    @FXML
    private ImageView closeImageView;

    public void closeOnAction(ActionEvent event){
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void goToMainPageOnAction(ActionEvent event){
        MainPage();
    }

    public void MainPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("LaptopMainPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToHPPageOnAction(ActionEvent event){
        HPPage();
    }
    public void HPPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("HP_Page.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void goToAcerPageOnAction(ActionEvent event){
        acerPage();
    }

    public void acerPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("acerPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToHuaweiPageOnAction(ActionEvent event){
        huaweiPage();
    }

    public void huaweiPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("huaweiPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToDellPageOnAction(ActionEvent event){
        dellPage();
    }

    public void dellPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("dellPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToAsusPageOnAction(ActionEvent event){
        asusPage();
    }

    public void asusPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("asusPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToApplePageOnAction(ActionEvent event){
        applePage();
    }

    public void applePage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("applePage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToMSIPageOnAction(ActionEvent event){
        msiPage();
    }

    public void msiPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("msiPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToMicrosoftPageOnAction(ActionEvent event){
        microsoftPage();
    }

    public void microsoftPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("microsoftPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }
    public void goToLenovoPageOnAction(ActionEvent event){
        lenovoPage();
    }

    public void lenovoPage(){
        try {
            Parent root  = FXMLLoader.load(getClass().getResource("lenovoPage.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 1000, 623));
            registerStage.show();
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    @FXML
    public void getAddView(MouseEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("feedbackPage.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void getAddLaptopView(MouseEvent event){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("addInfoPage.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        File exitFile = new File("images/close_icon.png");
        Image exitImage = new Image(exitFile.toURI().toString());
        closeImageView.setImage(exitImage);
    }
}
