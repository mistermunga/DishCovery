module com.hci.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hci.javafx to javafx.fxml;
    exports com.hci.javafx;
}