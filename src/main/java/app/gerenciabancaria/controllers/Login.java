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
import javax.imageio.IIOException;
import java.io.IOException;



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
    public void criarConta(ActionEvent event) throws IOException {
        if (nomeField.getText().isEmpty() || sobreField.getText().isEmpty() || cpfField.getText().isEmpty()){
            lblMessagem.setText("Por favor, preencha todos os campos!");
        }

        String nome = nomeField.getText();
        String sobrenome = sobreField.getText();
        String cpf = cpfField.getText();

        contaNova = new Conta(nome, sobrenome, cpf, 0);
        try{
        if (contaNova != null){
          entrar();
        }else{
            lblMessagem.setText("Erro ao criar conta! Tente novamente");
        }
        }catch (Exception ex ){
            System.out.println(ex);
        }
    }

    @FXML
    public void entrar() throws IOException{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) btnEntrar.getScene().getWindow();
            MainController homeController = loader.getController();
            homeController.contaLogado(contaNova);

            stage.setScene(scene);
            stage.show();
        } catch (IIOException ex){
            lblMessagem.setText("Erro ao entrar!");
            System.out.println(ex);
        }
    }

}
