package com.desktopapp;


import com.desktopapp.model.Contacts;
import com.desktopapp.model.Mensages;
import com.desktopapp.model.User;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WriteMensagController {

  private Mensages msgs;

  private Contacts cont;

  @FXML
  private TextField msgField;

  @FXML
  private TextField title;

  @FXML
  private Button btClose;

  @FXML
  private Button btSend;

  User loggedUser;

  public User getLoggedUser() {
      return loggedUser;
  }

  public void setLoggedUser(User loggedUser) {
      this.loggedUser = loggedUser;
  }

  public void myContact(Contacts cont) {
    this.cont = cont;
  }


  @FXML
  public void send() 
  {
      Mensages msg = new Mensages();
      msg.setMsg(msgField.getText());
      //msg.setEmailDestined();
      msg.setTitle(title.getText());

      msg.setEmailDestined(getCont().getUserFriend());

      msg.setEmailRemetend(getLoggedUser().getEmail());

      Context ctx = new Context();

      ctx.begin();
      ctx.save(msg);
      ctx.commit();
}

  @FXML
  private void initialize() {
  
    btClose.setOnAction(event -> closeWindow());

  }

  @FXML
  private void closeWindow() {
    Stage stage = (Stage) msgField.getScene().getWindow();
    stage.close();
  }

    public Contacts getCont() {
        return cont;
    }

    public void setCont(Contacts cont) {
        this.cont = cont;
    }

    

}