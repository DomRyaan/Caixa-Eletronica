package app.gerenciabancaria.controllers;

import app.gerenciabancaria.models.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.gerenciabancaria.models.ConexaoBD;



public class Login {

    @FXML
    Conta contaNova;
    @FXML
    private Button btnEntrar;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField sobreField;
    @FXML
    private TextField cpfField;

    @FXML
    private Label lblMessagem;


    @FXML
    public void autenticacao(ActionEvent event) throws IOException {
        if (nomeField.getText().isEmpty() || sobreField.getText().isEmpty() || cpfField.getText().isEmpty()) {
            lblMessagem.setText("Por favor, preencha todos os campos!");
        }

        String nome = nomeField.getText();
        String sobrenome = sobreField.getText();
        String cpf = cpfField.getText();

        contaNova = new Conta(nome, sobrenome, cpf);

        if(Conta.autenticar(contaNova)){

            entrar();
        }else{
            lblMessagem.setText("Autenticação Invalida!");
        }

        }


    @FXML
    public void entrar() throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            MainController homeController = loader.getController();
            homeController.contaLogado(contaNova);

            Stage stage = (Stage) btnEntrar.getScene().getWindow();

            stage.setScene(scene);
            stage.show();
            } catch (Exception e) {
                System.out.println("Deu esser erro: " + e);
            }
        }
    }

