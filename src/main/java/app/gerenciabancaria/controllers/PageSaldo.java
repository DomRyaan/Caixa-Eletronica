package app.gerenciabancaria.controllers;

import app.gerenciabancaria.models.Conta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class PageSaldo {

    @FXML
    Conta contanova;
    @FXML
    TextArea saldoArea;
    boolean contaLogado;
    @FXML
    CheckBox checkSaldo;
    @FXML
    Hyperlink homeLink;

    @FXML
    public void initialize(){
        saldoArea.setText("Clique na caixinha para ver seu saldo!");
    }

    @FXML
    public void contaLogado(Conta conta){
        try{
            contanova = conta;
        } catch (NullPointerException e) {
            System.out.println(e);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    @FXML
    public void verSaldo(){
        try{
            if (checkSaldo.isSelected()){
            atulizarSaldo();
        }else {
                saldoArea.setText("Clique na caixinha para mostrar seu saldo!");
            }
        }catch (Exception e) {
            System.out.println(e);
            saldoArea.setText("Conta não pode ser carregada");
        }
    }

    @FXML
    public void atulizarSaldo(){
        double saldo = contanova.getSaldo();
        saldoArea.setText("Você tem " + saldo + "R$ na sua conta!");
    }

    @FXML
    public void voltar(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/gerenciabancaria/home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) homeLink.getScene().getWindow();

            MainController pageController = loader.getController();
            pageController.contaLogado(contanova);

            stage.setScene(scene);
            stage.show();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }

}
