package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class feedbackController implements Initializable {

    @FXML
    private TextField nameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField subjectField;
    @FXML
    private TextField messageField;

    String query = null;
    Connection connection = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement;
    Feedback feedback = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }

    @FXML
    public void save(MouseEvent event){

        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
        String name = nameField.getText();
        String email = emailField.getText();
        String subject = subjectField.getText();
        String message = messageField.getText();

        if(name.isEmpty() || email.isEmpty() || subject.isEmpty() || message.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Толықтай толтыруыңызды өтінеміз");
            alert.showAndWait();
        } else{
            qetQuery();
            insert();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("      Хатыңыз жіберілді. \nКері байланысыңызға рақмет!");
            alert.showAndWait();

        }
    }

    private void qetQuery() {
        query = "INSERT INTO laptop_feedback(name, email, subject, message, message_date) " +
                "VALUES(?,?,?,?,SYSDATE) ";
    }
    private void insert() {

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameField.getText());
            preparedStatement.setString(2, emailField.getText());
            preparedStatement.setString(3, subjectField.getText());
            preparedStatement.setString(4, messageField.getText());
            preparedStatement.execute();
        } catch (SQLException e){
            Logger.getLogger(feedbackController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}
