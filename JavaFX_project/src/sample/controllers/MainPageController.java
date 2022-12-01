package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainPageController {

    private Stage stage;
    private Scene scene;

    public void switchToIncomePage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/IncomePage.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void switchToExpensesPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/ExpensesPage.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToSample(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/sample.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switchToDBPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/DBPage.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
