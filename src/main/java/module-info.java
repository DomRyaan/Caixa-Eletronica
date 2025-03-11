module app.gerenciabancaria {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;
    requires java.desktop;


    exports app.gerenciabancaria.controllers to javafx.fxml;

    exports app.gerenciabancaria;


    opens app.gerenciabancaria.controllers to javafx.fxml;
    opens app.gerenciabancaria to javafx.fxml;
}