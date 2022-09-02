/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mpisc
 */
public class MainFXMLController implements Initializable {

    @FXML
    private Label lblNomeCompleto;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnLimpar;
    @FXML
    private TextField tfPrimeiroNome;
    @FXML
    private TextField tfUltimoNome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtnOk(ActionEvent event) {
        String primeiroNome = tfPrimeiroNome.getText();
        String ultimoNome = tfUltimoNome.getText();
        lblNomeCompleto.setText("Nome Completo: " + primeiroNome + " " + ultimoNome);
    }

    @FXML
    private void handleBtnLimpar(ActionEvent event) {
        tfPrimeiroNome.setText(null);
        tfUltimoNome.setText(null);
        lblNomeCompleto.setText("Nome Completo: ");
        tfPrimeiroNome.requestFocus();
    }
    
}
