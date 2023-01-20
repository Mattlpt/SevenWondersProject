module com.sevenwonders {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.sevenwonders.controller to javafx.fxml;
    exports com.sevenwonders.controller;
    exports com.sevenwonders;
}
