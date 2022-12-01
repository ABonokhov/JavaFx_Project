package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.sun.javafx.menu.MenuItemBase;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DatabaseHandler;
import sample.User;

public class Controller {

    private Stage stage;
    private Scene scene;

    @FXML
    private Button InputButton;

    @FXML
    private Button SaveButton;

    @FXML
    private TextField login;


    @FXML
    private PasswordField password;

    @FXML
    void switchToMainPage() {
        InputButton.setOnAction(new EventHandler<ActionEvent>() {            //действие при нажатии на кнопку Войти
            @Override
            public void handle(ActionEvent event) {
                InputButton.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/pages/MainPage.fxml"));
                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();
            }
        });
        InputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                openMainPage("/sample/pages/MainPage.fxml");
            }
        });
        InputButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String loginText = login.getText().trim();
                String passwordText = password.getText().trim();

                if (!loginText.equals("") && !passwordText.equals("")) {
                    try {
                        EnterUser(loginText, passwordText);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @FXML
    void initialize() {
        final DatabaseHandler dbHandler = new DatabaseHandler();
        SaveButton.setOnAction(new EventHandler<ActionEvent>() {            //действие при нажатии на кнопку Войти
            @Override
            public void handle(ActionEvent event) {
                try {
                    dbHandler.signUpUser(login.getText(), password.getText()); // считываем данные логина и пароля после нажатия на кнопку запомнить
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

    private void EnterUser(String login, String password) throws SQLException, ClassNotFoundException {
        DatabaseHandler databaseHandler = new DatabaseHandler();
        User user = new User();
        user.setUser_name(login);
        user.setUser_password(password);
        ResultSet resultSet = databaseHandler.getUser(user);

        int counter = 0;
        while (resultSet.next()) {          // цикл для проверки массива пользователей
            counter++;
        }
        if (counter >= 1) {
            openMainPage("/sample/pages/MainPage.fxml");
        }

    }

    public void openMainPage(String window) {
        InputButton.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}





