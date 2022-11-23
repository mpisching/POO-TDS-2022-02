/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsc.fln.controller;

import br.edu.ifsc.fln.model.dao.ItemDeVendaDAO;
import br.edu.ifsc.fln.model.dao.ProdutoDAO;
import br.edu.ifsc.fln.model.dao.VendaDAO;
import br.edu.ifsc.fln.model.database.Database;
import br.edu.ifsc.fln.model.database.DatabaseFactory;
import br.edu.ifsc.fln.model.domain.Venda;
import br.edu.ifsc.fln.model.domain.ItemDeVenda;
import br.edu.ifsc.fln.model.domain.Produto;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mpisching
 */
public class FXMLAnchorPaneProcessoVendaController implements Initializable {

//    @FXML
//    private TableView<Venda> tableView;
//    @FXML
//    private TableColumn<Venda, Integer> tableColumnVendaCodigo;
//    @FXML
//    private TableColumn<Venda, LocalDate> tableColumnVendaData;
//    @FXML
//    private TableColumn<Venda, Venda> tableColumnVendaCliente;
//    @FXML
//    private Label labelVendaCodigo;
//    @FXML
//    private Label labelVendaData;
//    @FXML
//    private Label labelVendaValor;
//    @FXML
//    private Label labelVendaCliente;
//    @FXML
//    private CheckBox checkBoxVendaPago;
//    @FXML
//    private Button buttonInserir;
//    @FXML
//    private Button buttonAlterar;
//    @FXML
//    private Button buttonRemover;
//    
    @FXML
    private Button buttonAlterar;

    @FXML
    private Button buttonInserir;

    @FXML
    private Button buttonRemover;

    @FXML
    private CheckBox checkBoxVendaPago;

    @FXML
    private Label labelVendaCliente;

    @FXML
    private Label labelVendaData;

    @FXML
    private Label labelVendaDesconto;

    @FXML
    private Label labelVendaId;

    @FXML
    private Label labelVendaSituacao;

    @FXML
    private Label labelVendaTotal;

    @FXML
    private TableView<Venda> tableView;

    @FXML
    private TableColumn<Venda, Integer> tableColumnVendaId;

    @FXML
    private TableColumn<Venda, LocalDate> tableColumnVendaData;

    @FXML
    private TableColumn<Venda, Venda> tableColumnVendaCliente;

    private List<Venda> listaVendas;
    private ObservableList<Venda> observableListVendas;

    //acesso ao banco de dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final VendaDAO vendaDAO = new VendaDAO();
    private final ItemDeVendaDAO itemDeVendaDAO = new ItemDeVendaDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendaDAO.setConnection(connection);

        carregarTableView();

        tableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableView(newValue));
    }

    public void carregarTableView() {
        DateTimeFormatter myDateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        tableColumnVendaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        //tableColumnVendaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnVendaData.setCellFactory(column -> {
            return new TableCell<Venda, LocalDate>() {
                @Override
                protected void updateItem(LocalDate item, boolean empty) {
                    super.updateItem(item, empty);

                    if (item == null || empty) {
                        setText(null);
                    } else {
                        setText(myDateFormatter.format(item));
                    }
                }
            };
        });
       
        tableColumnVendaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        tableColumnVendaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));

        listaVendas = vendaDAO.listar();

        observableListVendas = FXCollections.observableArrayList(listaVendas);
        tableView.setItems(observableListVendas);
    }

    public void selecionarItemTableView(Venda venda) {
        if (venda != null) {
            labelVendaId.setText(Integer.toString(venda.getId()));
            labelVendaData.setText(String.valueOf(
                    venda.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
            labelVendaTotal.setText(String.format("%.2f", venda.getTotal()));
            labelVendaDesconto.setText((String.format("%.2f", venda.getTaxaDesconto())) + "%");
            checkBoxVendaPago.setSelected(venda.isPago());
            labelVendaSituacao.setText(venda.getStatusVenda().name());
            labelVendaCliente.setText(venda.getCliente().getNome());
        } else {
            labelVendaId.setText("");
            labelVendaData.setText("");
            labelVendaTotal.setText("");
            labelVendaDesconto.setText("");
            checkBoxVendaPago.setSelected(false);
            labelVendaSituacao.setText("");
            labelVendaCliente.setText("");
        }
    }

    @FXML
    private void handleButtonInserir(ActionEvent event) throws IOException, SQLException {
        Venda venda = new Venda();
        List<ItemDeVenda> itensDeVenda = new ArrayList<>();
        venda.setItensDeVenda(itensDeVenda);
        boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessoVendaDialog(venda);
        if (buttonConfirmarClicked) {
            try {
                connection.setAutoCommit(false);
                vendaDAO.setConnection(connection);
                vendaDAO.inserir(venda);
                itemDeVendaDAO.setConnection(connection);
                produtoDAO.setConnection(connection);
                for (ItemDeVenda itemDeVenda: venda.getItensDeVenda()) {
                    Produto produto = itemDeVenda.getProduto();
                    itemDeVenda.setVenda(vendaDAO.buscarUltimaVenda());
                    itemDeVendaDAO.inserir(itemDeVenda);
                    produto.getEstoque().setQuantidade(
                            produto.getEstoque().getQuantidade() - itemDeVenda.getQuantidade());
                    produtoDAO.alterar(produto);
                }
                connection.commit();
                carregarTableView();
            } catch (SQLException exc) {
                try {
                    connection.rollback();
                } catch (SQLException exc1) {
                    Logger.getLogger(FXMLAnchorPaneProcessoVendaController.class.getName()).log(Level.SEVERE, null, exc1);
                }
                Logger.getLogger(FXMLAnchorPaneProcessoVendaController.class.getName()).log(Level.SEVERE, null, exc);
            }   
        }
    }

    @FXML
    private void handleButtonAlterar(ActionEvent event) throws IOException {
        Venda venda = tableView.getSelectionModel().getSelectedItem();
        if (venda != null) {
            boolean buttonConfirmarClicked = showFXMLAnchorPaneProcessoVendaDialog(venda);
            if (buttonConfirmarClicked) {
                vendaDAO.alterar(venda);
                carregarTableView();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha um venda na Tabela.");
            alert.show();
        }        
    }

    @FXML
    private void handleButtonRemover(ActionEvent event) throws SQLException {
//        Venda venda = tableView.getSelectionModel().getSelectedItem();
//        if (venda != null) {
//            try {
//                connection.setAutoCommit(false);
//                vendaDAO.setConnection(connection);
//                itemDeVendaDAO.setConnection(connection);
//                produtoDAO.setConnection(connection);
//                for (ItemDeVenda itemDeVenda : venda.getItensDeVenda()) {
//                    Produto produto = itemDeVenda.getProduto();
//                    produto.setQuantidade(produto.getQuantidade() + itemDeVenda.getQuantidade());
//                    produtoDAO.alterar(produto);
//                    itemDeVendaDAO.remover(itemDeVenda);
//                }
//                vendaDAO.remover(venda);
//                connection.commit();
//                carregarTableView();
//            } catch (SQLException exc) {
//                try {
//                    connection.rollback();
//                } catch (SQLException exc1) {
//                    Logger.getLogger(FXMLAnchorPaneProcessoVendaController.class.getName()).log(Level.SEVERE, null, exc1);
//                }
//                Logger.getLogger(FXMLAnchorPaneProcessoVendaController.class.getName()).log(Level.SEVERE, null, exc);
//            }
//        } else {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setHeaderText("Por favor, escolha uma venda na tabela!");
//            alert.show();
//        }
    }

    public boolean showFXMLAnchorPaneProcessoVendaDialog(Venda venda) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneProcessoVendaDialogController.class.getResource(
                "../view/FXMLAnchorPaneProcessoVendaDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        //criando um estágio de diálogo  (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Cadastro de vendas");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        //Setando o venda ao controller
        FXMLAnchorPaneProcessoVendaDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setVenda(venda);

        //Mostra o diálogo e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfirmarClicked();
    }

}
