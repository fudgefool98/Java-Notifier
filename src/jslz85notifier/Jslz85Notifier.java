/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jslz85notifier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Jordan
 */
public class Jslz85Notifier extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        //creating the field and buttons
        TextField textField = new TextField();
        Button notifyButton = new Button("Notify");
        Button clearButton = new Button("Clear");
        Button printButton = new Button("Print");
        Button alertButton = new Button("Alert");
        
       //setting the button widths and textfield width
        notifyButton.setMaxWidth(Double.MAX_VALUE);
        clearButton.setMaxWidth(Double.MAX_VALUE);
        printButton.setMaxWidth(Double.MAX_VALUE);
        alertButton.setMaxWidth(Double.MAX_VALUE);
        textField.setPrefWidth(350);
        //creating the VBox and laying it out
        VBox buttonBox  = new VBox();
        buttonBox.setPadding(new Insets(0, 0, 10, 0));
        buttonBox.setSpacing(10);               
        //adding buttons to the VBox
        buttonBox.getChildren().addAll( notifyButton, clearButton, printButton, alertButton);
        //creating the GridPane
        GridPane root = new GridPane();
        //setting layout
        root.setVgap(10);
        root.setHgap(10);
        root.setAlignment(Pos.CENTER);
        //adding text and VBox to root
        root.add(textField,0,0);       
        root.add(buttonBox,0,1);
        //creating the scene, setting, and showing it.
        Scene scene = new Scene(root, 420, 250);
        primaryStage.setTitle("Notifier");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //button functionality
       notifyButton.setOnAction((ActionEvent e) -> {
            
            textField.setText(invokeMe("jslz85"));
        });
       //clear
       clearButton.setOnAction((ActionEvent e) -> {
            textField.setText("");
        });
       //print
       printButton.setOnAction((ActionEvent e) -> {
            String toBePrinted = textField.getText();
            System.out.println(toBePrinted);
        });
        //alert
       alertButton.setOnAction((ActionEvent e) -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText("");
            alert.setContentText(textField.getText());
            alert.showAndWait();
        });
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
private static String invokeMe(String myPawPrint) {
    
    String hi = "";
        hi = "My PawPrint is " + myPawPrint;
        DateFormat dateFormat = new SimpleDateFormat(" yyyy/MM/dd HH:mm:ss ");
        Date date = new Date();
        hi += dateFormat.format(date);
        hi+= "Hello World.";
        
        return hi;
    }

} 