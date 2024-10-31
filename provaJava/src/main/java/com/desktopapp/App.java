package com.desktopapp;

import com.desktopapp.model.Contacts;
import com.desktopapp.model.Mensages;
import com.desktopapp.model.User;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    public static void main(String[] args) {

        // validator("1111111111111111111111111b@");

        Context ctx = new Context();

        User user1 = new User();
        user1.setName("trevis");
        user1.setEmail("trevis@trevis");
        user1.setPassword("123");

        ctx.begin();
        ctx.save(user1);
        ctx.commit();

        // para testes
        User user = new User();
        user.setName("");
        user.setPassword("");
        
        ctx.begin();
        ctx.save(user);
        ctx.commit();

        Contacts cot = new Contacts();
        
        cot.setUserCurr(user.getEmail());
        cot.setUserFriend(user1.getEmail());
        
        ctx.begin();
        ctx.save(cot);
        ctx.commit();

        // para testes
        Mensages msg = new Mensages();
        msg.setEmailRemetend("nini@email");
        msg.setTitle("Inquisicao");
        msg.setMsg("Inquisicao melhor livro do mundo inteiroooooooooooooooo, quero o terceirooooo");
        msg.setEmailDestined("trevis@trevis");
        
        ctx.begin();
        ctx.save(msg);
        ctx.commit();

        // User user2 = new User();
        // user2.setName("trevis");
        // user2.setPassword("inquisicaoMelhorLivro");

        // ctx.begin();
        // ctx.save(user2);
        // ctx.commit();

        // Product prod1 = new Product();
        // prod1.setNameProd("Inquisicao vol 1");
        // prod1.setPriceProd(10.0);

        // ctx.begin();
        // ctx.save(prod1);
        // ctx.commit();

        // Product prod2 = new Product();
        // prod2.setNameProd("Memorias do subsolo");
        // prod2.setPriceProd(10.0);

        // ctx.begin();
        // ctx.save(prod2);
        // ctx.commit();

        // Product prod3 = new Product();
        // prod3.setNameProd("Inquisicao vol 2");
        // prod3.setPriceProd(10.0);

        // ctx.begin();
        // ctx.save(prod3);
        // ctx.commit();

        launch(args);
    }
    @Override
    public void start(Stage arg0) throws Exception
    {
        Scene scene = LoginSceneController.CreateScene();
        arg0.setScene(scene);
        arg0.show();

    }
}