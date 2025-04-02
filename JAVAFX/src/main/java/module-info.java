module com.hci.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.fasterxml.jackson.databind;


    opens com.hci.javafx to javafx.fxml;
    exports com.hci.javafx;
}