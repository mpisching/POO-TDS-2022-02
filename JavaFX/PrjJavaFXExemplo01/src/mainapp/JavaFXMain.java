/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package mainapp;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author mpisc
 */
public class JavaFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });
//        
//        StackPane root = new StackPane();
//        root.getChildren().add(btn);

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("MainFXML.fxml"));
        } catch (IOException ex) {
            System.out.println("Não foi possível carregar o formulário");
        }
        
        Scene scene = new Scene(root, 359, 250);
        
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("IFSC_logo_vertical.png")));
        primaryStage.setTitle("POO - TDS - I F S C");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
