package com.desktopapp;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.desktopapp.model.Contacts;
import com.desktopapp.model.User;

import jakarta.persistence.TypedQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;


public class SendMensagesController implements Initializable {

  private User loggedUser;

  public User getLoggedUser() {
      return loggedUser;
  }

  public void setLoggedUser(User loggedUser) {
      this.loggedUser = loggedUser;
  }

   @FXML
    protected Button voltar;


    @FXML 
    private TableView<Contacts> tableView; // po objt vai ser um ptoduto na linahe na coluna

    @FXML
    private TableColumn<Contacts, String> userContCol; 

    @FXML
    private TableColumn<Contacts, Void> writeMsgCol;


  
   public static Scene CreateScene(User user) throws Exception {
    try {
        URL sceneUrl = SendMensagesController.class.getResource("sendMensagesScene.fxml");
        FXMLLoader loader = new FXMLLoader(sceneUrl);
        Parent root = loader.load();
    
        SendMensagesController controller = loader.getController(); 
        controller.setLoggedUser(user);
    
        return new Scene(root);

    } catch (IOException e) {
        System.err.println(e);
        return null;
    }
    }

    @FXML
    public void voltarHome()
    {
        try {
            var scene = HomeController.CreateScene(getLoggedUser());
            Stage currentStage = (Stage) voltar.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        userContCol.setCellValueFactory(new PropertyValueFactory<>("userFriend"));

      
        // Configuração da coluna de editar
        writeMsgCol.setCellFactory(new Callback<TableColumn<Contacts, Void>, TableCell<Contacts, Void>>() { 

            // Quando você usa um Callback<TableColumn<Product, Void>, TableCell<Product, Void>>, você está definindo como a tabela deve criar células para uma coluna específica. Callback precisa saber o tipo da coluna que está sendo passada e o tipo da célula que será retornada //Quando você usa setCellFactory com Callback em uma coluna, está dizendo à coluna para usar o código do Callback sempre que precisar criar uma célula.

            @FXML
            public TableCell<Contacts, Void> call(TableColumn<Contacts, Void> param) { 
                return new TableCell<Contacts, Void>() {
                    //Dentro das chaves, estamos definindo o comportamento e a aparência da nova célula.
                    private final Button EnviarMensagem = new Button("contactar");
    
                    {
                        // Configurar o evento de clique para abrir a nova tela de edição
                        EnviarMensagem.setOnAction(event -> {
                            Contacts selectedCont = getTableView().getItems().get(getIndex());
                            openSendMensageScreen(selectedCont);
                        });
                    }
                    // TableCell representa uma célula em uma tabela //O primeiro parâmetro (Product) indica que a célula é associada a objetos do tipo Product// O nome do método é call, que é um nome padrão usado para métodos de callback//param: Este parâmetro representa a coluna da tabela que está criando a célula.
                    
                    //atualiza a tabela
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : EnviarMensagem);
                    }
                };
            }
        });

        if (!tableView.getColumns().contains(writeMsgCol)) {
            tableView.getColumns().add(writeMsgCol);
        }
    

        // Adicionando as colunas de editar e excluir à tabela
        //tableView.getColumns().addAll(readMensageCol);

        // Carregar produtos na tabela
        ObservableList<Contacts> lista = AllContacts();
        if (lista != null && !lista.isEmpty()) {
            this.tableView.setItems(lista);
        } else {
            System.out.println("não há contatos ainda.");
        }
    }
   

    public ObservableList<Contacts> AllContacts() {
        Context ctx = new Context();
        ObservableList<Contacts> lista = FXCollections.observableArrayList();
        try {

            var jpql = ctx.find(User.class,
            "SELECT u FROM Contacts u WHERE u.userCurr = :arg0",
            getLoggedUser().getEmail()
    );
            // Um TypedQuery é uma interface na Java Persistence API (JPA) que permite realizar consultas tipadas em um banco de dados.
            TypedQuery<Contacts> query = ctx.createQuery(Contacts.class, jpql.toString());
            List<Contacts> conts = query.getResultList();
            lista.addAll(conts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    private void openSendMensageScreen(Contacts cont) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("writeMensageScene.fxml"));
            Parent editRoot = loader.load();
    
            WriteMensagController wController = loader.getController();
            wController.myContact(cont);
    
            Stage escreverMensagem = new Stage();
            escreverMensagem.setScene(new Scene(editRoot));
            escreverMensagem.setTitle("escrever mensagem");
            escreverMensagem.show();
            
            // Atualizar a tabela após fechar a janela de edição
            escreverMensagem.setOnHiding(event -> tableView.refresh());
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


  
}
