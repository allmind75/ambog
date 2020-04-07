package sample;

import java.awt.event.ActionEvent;
import java.rmi.StubNotFoundException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class Main extends Application {

    private StandardPBEStringEncryptor jasypt;
    private static final String ALGORITHM = "PBEWithMD5AndDES";
    private String password;

    private Label label;
    private TextField field;
    private Button button;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
////        primaryStage.setTitle("Hello World");
//        primaryStage.setScene(new Scene(root, 300, 275));
//        primaryStage.show();

        label = new Label("test");
        field = new TextField();
        button = new Button("click");

        jasyptInit("");

        button.setOnAction((ActionEvent) -> {
//            String msg = "button msg " + field.getText();
//            label.setText(msg);
            String msg = field.getText();
            String decryptStr = jasypt.decrypt(msg);
            label.setText(decryptStr);

        });

        BorderPane pane = new BorderPane();
        pane.setTop(label);
        pane.setCenter(field);
        pane.setBottom(button);
        Scene scene = new Scene(pane, 320, 120);
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public void jasyptInit(String password) {
        jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword(password);
        jasypt.setAlgorithm(ALGORITHM);
    }

    public void encrypt() {

    }

    public void decrypt() {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
