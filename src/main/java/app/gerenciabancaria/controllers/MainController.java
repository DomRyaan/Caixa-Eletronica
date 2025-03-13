package app.gerenciabancaria.controllers;

import app.gerenciabancaria.models.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    Conta contaNova;
    @FXML
    Button btnDepositar;
    @FXML
    Button btnSaque;
    @FXML
    Button btnSaldo;

    @FXML
    public void initialize(){

    }

    @FXML
    public void contaLogado(Conta conta){
        contaNova = conta;
    }

    @FXML
    public void pageSaque(ActionEvent event)throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/saque.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnSaque.getScene().getWindow();

        PageSaque pageController = loader.getController();
        pageController.contaLogado(contaNova);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void pageDepositar(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/Pagedepositar.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            PageDeposito pageController = loader.getController();
            pageController.contaLogado(contaNova);
            
            Stage stage = (Stage) btnDepositar.getScene().getWindow();



            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    public void pageSaldo(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/saldo.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) btnSaldo.getScene().getWindow();

        PageSaldo pageController = loader.getController();
        pageController.contaLogado(contaNova);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void sair(ActionEvent event){
        Platform.exit();
    }
}
