package com.desktopapp;

import com.desktopapp.model.Mensages;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class ReadMensageController {

  private Mensages msgs;

  @FXML
  private TextArea msgArea;

  @FXML
  private TextArea title;

  @FXML
  private Button close;

  User loggedUser;

  public User getLoggedUser() {
      return loggedUser;
  }

  public void setLoggedUser(User loggedUser) {
      this.loggedUser = loggedUser;
  }

  public void setMsgs(Mensages msgem) {

    this.msgs = msgem;

    if (msgem != null) {
      msgArea.setText(msgem.getMsg());
      title.setText(msgem.getTitle());
    }
   
}

  @FXML
  private void initialize() {
  
    close.setOnAction(event -> closeWindow());

  }

  @FXML
  private void closeWindow() {
    Stage stage = (Stage) msgArea.getScene().getWindow();
    stage.close();
  }

    

}
