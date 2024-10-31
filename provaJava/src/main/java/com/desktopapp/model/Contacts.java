package com.desktopapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// cria um modelo para o objeto user

@Entity
@Table(name = "tbContacts")
public class Contacts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContact;

    public Long getIdContact() {
        return idContact;
    }

    public void setIdContact(Long id) {
        this.idContact = id;
    }
    private String userCurr;

    public String getUserCurr() {
        return userCurr;
    }

    public void setUserCurr(String user) {
        this.userCurr = user;
    }

    private String userFriend;

    public String getUserFriend() {
        return userFriend;
    }

    public void setUserFriend(String userFriend) {
        this.userFriend = userFriend;
    }
}



// package com.desktopapp.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "tbContacts")
// public class Contacts {
    
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private long id;
    
//     public long getId() {
//         return id;
//     }
    
//     public void setId(long id) {
//         this.id = id;
//     }

//     private String user;
//     private String userFriend;
    

//     public String getUser() {
//         return user;
//     }

//     public void setUser(String user) {
//         this.user = user;
//     }

//     public String getUserFriend() {
//         return userFriend;
//     }

//     public void setUserFriend(String userFriend) {
//         this.userFriend = userFriend;
//     }
  
// }
