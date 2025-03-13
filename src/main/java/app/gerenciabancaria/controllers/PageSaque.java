package app.gerenciabancaria.controllers;

import app.gerenciabancaria.models.Conta;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PageSaque {
    @FXML
    Conta contanova;
    @FXML
    Hyperlink linkHome;
    @FXML
    TextField valorField;
    @FXML
    Label lblMessagem;
    @FXML
    Button btnSaque;

    @FXML
    public void contaLogado(Conta conta) {
        contanova = conta;
    }

    @FXML
    public void voltar(Event event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) linkHome.getScene().getWindow();

            MainController pageController = loader.getController();
            pageController.contaLogado(contanova);

            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    @FXML
    public void sacar(Event event) {
        double valor = Double.parseDouble(valorField.getText());
        if (valor < 0) {
            lblMessagem.setText("Digite um valor válido!");
        } else {
            try {
                if (contanova.sacar(valor)) {
                    lblMessagem.setText("Saque efetuado com sucesso! Você sacou: " + valor);
                } else {
                    lblMessagem.setText("Saldo Insuficiente!");
                }
            } catch (Exception ex) {
                lblMessagem.setText("Error ao sacar, Tente novamente!");
                System.out.println(ex);
            }
        }
    }


}
