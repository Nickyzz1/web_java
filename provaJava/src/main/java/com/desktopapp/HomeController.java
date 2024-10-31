package com.desktopapp;

import java.io.IOException;
import java.net.URL;


import java.util.List;
import java.util.ResourceBundle;
import javafx.util.Callback;


import com.desktopapp.model.User;

import jakarta.persistence.TypedQuery;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.control.cell.PropertyValueFactory;

import com.desktopapp.model.Mensages;

public class HomeController implements Initializable {

    @FXML
    protected Button logout;

    @FXML
    protected Button btChangeToSendMensages;

    @FXML
    protected Button btGoToAdd;

    private User loggedUser;

    @FXML 
    private TableView<Mensages> tableView; // po objt vai ser um ptoduto na linahe na coluna

    @FXML
    private TableColumn<Mensages, String> remetenteCol; 

    @FXML
    private TableColumn<Mensages, String> titleCol; 

    @FXML
    private TableColumn<Mensages, String> mensageCol; 

    @FXML
    private TableColumn<Mensages, Void> readMensageCol; 



    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User setLoggedUser) {
        this.loggedUser = setLoggedUser;
    }

    public static Scene CreateScene(User user) throws Exception {
        try {
            URL sceneUrl = HomeController.class.getResource("homeScene.fxml");
            FXMLLoader loader = new FXMLLoader(sceneUrl);
            Parent root = loader.load();
        
            HomeController controller = loader.getController(); 
            controller.setLoggedUser(user);
        
            return new Scene(root);

        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }

    @FXML
    public void changeToSendMensages()
    {
        try {
            var scene = SendMensagesController.CreateScene(getLoggedUser());
            Stage currentStage = (Stage) btChangeToSendMensages.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (Exception e) {
            System.err.println(e);
        
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        remetenteCol.setCellValueFactory(new PropertyValueFactory<>("emailRemetend"));
        mensageCol.setCellValueFactory(new PropertyValueFactory<>("msg"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
      
        // Configuração da coluna de editar
        readMensageCol.setCellFactory(new Callback<TableColumn<Mensages, Void>, TableCell<Mensages, Void>>() { 

            // Quando você usa um Callback<TableColumn<Product, Void>, TableCell<Product, Void>>, você está definindo como a tabela deve criar células para uma coluna específica. Callback precisa saber o tipo da coluna que está sendo passada e o tipo da célula que será retornada //Quando você usa setCellFactory com Callback em uma coluna, está dizendo à coluna para usar o código do Callback sempre que precisar criar uma célula.

            @FXML
            public TableCell<Mensages, Void> call(TableColumn<Mensages, Void> param) { 
                return new TableCell<Mensages, Void>() {
                    //Dentro das chaves, estamos definindo o comportamento e a aparência da nova célula.
                    private final Button lerButton = new Button("Ler");
    
                    {
                        // Configurar o evento de clique para abrir a nova tela de edição
                        lerButton.setOnAction(event -> {
                            Mensages selectedMensage = getTableView().getItems().get(getIndex());
                            openReadMensageScreen(selectedMensage);
                        });
                    }
                    // TableCell representa uma célula em uma tabela //O primeiro parâmetro (Product) indica que a célula é associada a objetos do tipo Product// O nome do método é call, que é um nome padrão usado para métodos de callback//param: Este parâmetro representa a coluna da tabela que está criando a célula.
                    
                    //atualiza a tabela
                    @Override
                    protected void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        setGraphic(empty ? null : lerButton);
                    }
                };
            }
        });

        if (!tableView.getColumns().contains(readMensageCol)) {
            tableView.getColumns().add(readMensageCol);
        }
    

        // Adicionando as colunas de editar e excluir à tabela
        //tableView.getColumns().addAll(readMensageCol);

        // Carregar produtos na tabela
        ObservableList<Mensages> lista = AllMensages();
        if (lista != null && !lista.isEmpty()) {
            this.tableView.setItems(lista);
        } else {
            System.out.println("não há mensagens ainda.");
        }
    }
   

    public ObservableList<Mensages> AllMensages() {
        Context ctx = new Context();
        ObservableList<Mensages> lista = FXCollections.observableArrayList();
        try {
            String jpql = "SELECT p FROM Mensages p";
            // Um TypedQuery é uma interface na Java Persistence API (JPA) que permite realizar consultas tipadas em um banco de dados.
            TypedQuery<Mensages> query = ctx.createQuery(Mensages.class, jpql);
            List<Mensages> mensagens = query.getResultList();
            lista.addAll(mensagens);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return lista;
    }

    @FXML
    private void openReadMensageScreen(Mensages msg) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("readMensageScene.fxml"));
            Parent editRoot = loader.load();
    
            ReadMensageController readController = loader.getController();
            readController.setMsgs(msg);
    
            Stage lerMesagem = new Stage();
            lerMesagem.setScene(new Scene(editRoot));
            lerMesagem.setTitle("Ler mensagem");
            lerMesagem.show();
            
        
            lerMesagem.setOnHiding(event -> tableView.refresh());
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void logOut() {
        try {
            var scene = LoginSceneController.CreateScene();
            Stage currentStage = (Stage) logout.getScene().getWindow();
            currentStage.setScene(scene);
        } catch (Exception e) {
            System.err.println(e);
        }
    }


}