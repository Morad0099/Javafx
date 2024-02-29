module com.example.assignment_13 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assignment_13 to javafx.fxml;
    exports com.example.assignment_13;
}