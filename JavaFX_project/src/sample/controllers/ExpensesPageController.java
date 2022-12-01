package sample.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;

import java.io.IOException;
import java.sql.SQLException;

public class ExpensesPageController {

    @FXML
    private TextField SumField;
    @FXML
    private TextField ComField;

    @FXML
    private Button SendExpensesButton;

    @FXML
    void initialize() throws IOException {
        final DatabaseHandler dbHandler = new DatabaseHandler();
        SendExpensesButton.setOnAction(new EventHandler<ActionEvent>() {            //действие при нажатии на кнопку Войти
            @Override
            public void handle(ActionEvent event) {
                try {
                    dbHandler.signUpExpenses(Float.parseFloat(SumField.getText()), ComField.getText()); // считываем данные логина и пароля после нажатия на кнопку запомнить
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }

            }

        });


    }

    public void switchToMainPage2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/MainPage.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
