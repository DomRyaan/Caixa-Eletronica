package app.gerenciabancaria.controllers;

import app.gerenciabancaria.models.Conta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.imageio.IIOException;
import javafx.event.ActionEvent;
import java.io.IOException;

public class PageDeposito {
    @FXML
    Conta contanova;
    @FXML
    Button btnDepositar;
    @FXML
    TextField depositoField;
    @FXML
    Label lblMessagem;
    @FXML
    Hyperlink linkHome;

    @FXML
    public void contaLogado(Conta conta){
        contanova = conta;
    }

    @FXML
    public void setLinkHome(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) linkHome.getScene().getWindow();

            MainController pageController = loader.getController();
            pageController.contaLogado(contanova);

            stage.setScene(scene);
            stage.show();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void depositar(ActionEvent event) throws IOException {
        try {
            double valor = Double.parseDouble(depositoField.getText());
            if(valor > 0){
                contanova.depositar(valor);
                depositoField.clear();
                lblMessagem.setText("Deposito efetuado com sucesso!");
            }
            else {
                lblMessagem.setText("Digite um valor valido!");
            }
        } catch (Exception ex){
            lblMessagem.setText("Ocorreu um erro, tente novamente");
            System.out.println(ex.getMessage());
        }
    }
}
