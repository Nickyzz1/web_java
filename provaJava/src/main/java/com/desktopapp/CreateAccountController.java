package com.desktopapp;

import java.net.URL;

import com.desktopapp.model.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController  {

    @FXML
    protected TextField userName;
    @FXML
    protected TextField userEmail;
    @FXML
    protected PasswordField userPass;
    @FXML
    protected PasswordField userPassRep;
    @FXML
    protected Button btCreateAccount;
    @FXML
    protected Button voltar;

    // @Override
    // public void initialize(URL location, ResourceBundle resources) 
    // {
        
    // }

    @FXML
    protected void createAccount(ActionEvent e) throws Exception 
    {

        if(userPass.getText() == null ? userPassRep.getText() != null : !userPass.getText().equals(userPassRep.getText())) {

             Alert alert = new Alert(
                AlertType.ERROR,
                "As senhas devem ser iguais!",
                ButtonType.OK
            );
            alert.showAndWait();
            return;
            
        } 
        if(userPass.getText() == null ? userPassRep.getText() == null : userPass.getText().equals(userPassRep.getText())) {

            // if (userPass.validateSmallPass()) {
                
                User user = new User();
                user.setName(userName.getText());
                user.setPassword(userPass.getText());
                user.setEmail(userEmail.getText());
            
                Context ctx = new Context();
                ctx.begin();
                ctx.save(user);
                ctx.commit();
            // }

        }

        

        
        URL newSceneUrl = getClass().getResource("loginScene.fxml");
        Parent newRoot = FXMLLoader.load(newSceneUrl);
        Scene newScene = new Scene(newRoot);
        Stage currentStage = (Stage) btCreateAccount.getScene().getWindow();
        currentStage.setScene(newScene);
        currentStage.show();
    }

    @FXML
    public void goToLogin() {

        try {
            var scene = LoginSceneController.CreateScene();
            Stage currentStage = (Stage) voltar.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (Exception e) {
            System.err.println(e);
        }   

    }
}
