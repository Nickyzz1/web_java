package com.desktopapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// cria um modelo para o objeto user

@Entity
@Table(name = "tbMensages")
public class Mensages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
  
    private String emailDestined;

    public String getEmailDestined() {
        return emailDestined;
    }

    public void setEmailDestined(String email) {
        this.emailDestined = email;
    }

    
    private String msg;
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    private String emailRemetend;

    public String getEmailRemetend() {
        return emailRemetend;
    }

    public void setEmailRemetend(String emailRemetend) {
        this.emailRemetend = emailRemetend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
