package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddInfoController implements Initializable {

    @FXML
    private TextField brandField;
    @FXML
    private TextField laptopNameField;
    @FXML
    private TextField sizeField;
    @FXML
    private TextField processorField;
    @FXML
    private TextField graphicField;
    @FXML
    private TextField diskField;

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
        String brand = brandField.getText();
        String laptopName = laptopNameField.getText();
        String size = sizeField.getText();
        String processor = processorField.getText();
        String graphic = graphicField.getText();
        String disk = diskField.getText();

        if(brand.isEmpty() || laptopName.isEmpty() || size.isEmpty() || processor.isEmpty() || graphic.isEmpty() || disk.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Толықтай толтыруыңызды өтінеміз");
            alert.showAndWait();
        } else{
            qetQuery();
            insert();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("   Ақпарат енгізілді.");
            alert.showAndWait();

        }
    }

    private void qetQuery() {
        query = "INSERT INTO new_laptops (brand ,laptop_name, display_size, processor_type, graphics_card, disk_space, updated_date) " +
                "VALUES(?,?,?,?,?,?,SYSDATE) ";
    }
    private void insert() {

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, brandField.getText());
            preparedStatement.setString(2, laptopNameField.getText());
            preparedStatement.setString(3, sizeField.getText());
            preparedStatement.setString(4, processorField.getText());
            preparedStatement.setString(5, graphicField.getText());
            preparedStatement.setString(6, diskField.getText());
            preparedStatement.execute();
        } catch (SQLException e){
            Logger.getLogger(feedbackController.class.getName()).log(Level.SEVERE, null, e);
        }

    }
}

