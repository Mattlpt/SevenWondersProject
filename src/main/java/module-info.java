module com.sevenwonders {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sevenwonders to javafx.fxml;
    exports com.sevenwonders;
}
