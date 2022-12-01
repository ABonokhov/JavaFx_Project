package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.Expenses;
import sample.Income;

public class DBController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Income> income_table;

    @FXML
    private TableColumn<Income, Float> sum_income;

    @FXML
    private TableColumn<Income, String> com_income;

    @FXML
    private TableColumn<Income, String> user_income;


    @FXML
    private TableView<Expenses> expenses_table;

    @FXML
    private TableColumn<Expenses, Float> expenses_sum;

    @FXML
    private TableColumn<Expenses, String> expenses_com;

    @FXML
    private TableColumn<Expenses, String> expenses_user;


    ObservableList<Income> listIn = FXCollections.observableArrayList(
            new Income(140.69f, "Стипендия", "Сын"),
            new Income(1960.82f, "Зарплата", "Отец"),
            new Income(990.12f, "Пенсия", "Дед"),
            new Income(1280.36f, "Декретные", "Мать")
    );

    ObservableList<Expenses> listEx = FXCollections.observableArrayList(
            new Expenses(65.5f, "Тренажерный зал", "Сын"),
            new Expenses(280.34f, "Бензин", "Отец"),
            new Expenses(65.17f, "Рассада", "Дед"),
            new Expenses(320.36f, "Сапоги", "Мать")
    );

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sum_income.setCellValueFactory(new PropertyValueFactory<Income, Float>("sum_income"));
        com_income.setCellValueFactory(new PropertyValueFactory<Income, String>("com_income"));
        user_income.setCellValueFactory(new PropertyValueFactory<Income, String>("user_income"));

        expenses_sum.setCellValueFactory(new PropertyValueFactory<Expenses, Float>("expenses_sum"));
        expenses_com.setCellValueFactory(new PropertyValueFactory<Expenses, String>("expenses_com"));
        expenses_user.setCellValueFactory(new PropertyValueFactory<Expenses, String>("expenses_user"));

        income_table.setItems(listIn); //вывод информации в таблицы
        expenses_table.setItems(listEx);
    }

    public void switchToMainPage3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/sample/pages/MainPage.fxml")); // действие перехода на страницу "Подробная информация о текущих долгах и расходах"
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}