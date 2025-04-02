module com.hci.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.hci.javafx to javafx.fxml;
    exports com.hci.javafx;
}