package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AsusController implements Initializable {
    @FXML
    private TableColumn<Laptops_Info, String> column_brand;
    @FXML
    private TableColumn<Laptops_Info, String> column_laptop_name;
    @FXML
    private TableColumn<Laptops_Info, String> column_display_size;
    @FXML
    private TableColumn<Laptops_Info, String> column_processor_type;
    @FXML
    private TableColumn<Laptops_Info, String> column_graphics_card;
    @FXML
    private TableColumn<Laptops_Info, String> column_disk_space;
    @FXML
    private TableView<Laptops_Info> laptops_table;
    @FXML
    private ImageView backgroundImageView;
    @FXML
    private TextField searchField;
    @FXML
    private ImageView acer_icon;
    ObservableList<Laptops_Info> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("images/asus_icon.png");
        Image image = new Image(file.toURI().toString());
        acer_icon.setImage(image);

        column_brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        column_laptop_name.setCellValueFactory(new PropertyValueFactory<>("laptop_name"));
        column_display_size.setCellValueFactory(new PropertyValueFactory<>("display_size"));
        column_processor_type.setCellValueFactory(new PropertyValueFactory<>("processor_type"));
        column_graphics_card.setCellValueFactory(new PropertyValueFactory<>("graphics_card"));
        column_disk_space.setCellValueFactory(new PropertyValueFactory<>("disk_space"));

        try {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connection = databaseConnection.getConnection();
            String query = "SELECT brand, laptop_name, display_size, processor_type, graphics_card, disk_space FROM laptops WHERE brand = 'Asus'";

            ResultSet rs = connection.createStatement().executeQuery(query);

            while(rs.next()){
                observableList.add(new Laptops_Info(rs.getString("brand"), rs.getString("laptop_name"), rs.getString("display_size"),
                        rs.getString("processor_type"),rs.getString("graphics_card"), rs.getString("disk_space")));
            }

        } catch (SQLException e){
            Logger.getLogger(HPController.class.getName()).log(Level.SEVERE, null, e);
        }



        laptops_table.setItems(observableList);

        FilteredList<Laptops_Info> filteredList = new FilteredList<>(observableList, e -> true);


        searchField.setOnKeyReleased( e->  {
            searchField.textProperty().addListener((observable, oldValue, newValue) -> {

                filteredList.setPredicate((Predicate<? super Laptops_Info>) laptops_info->{

                    if(newValue == null || newValue.isEmpty()){
                        return true;
                    }
                    String lowerCaseFilter = newValue.toLowerCase();

                    if(laptops_info.getBrand().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(laptops_info.getLaptop_name().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(laptops_info.getDisplay_size().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(laptops_info.getProcessor_type().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(laptops_info.getGraphics_card().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    } else if(laptops_info.getDisk_space().toLowerCase().contains(lowerCaseFilter)){
                        return true;
                    }

                    return false;
                });
            });
            SortedList<Laptops_Info> sortedList = new SortedList<>(filteredList);

            sortedList.comparatorProperty().bind(laptops_table.comparatorProperty());

            laptops_table.setItems(sortedList);
        });






    }
}


