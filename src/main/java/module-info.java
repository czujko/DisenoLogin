module com.ndynmate.disenologin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.ndynmate.disenologin to javafx.fxml;
    exports com.ndynmate.disenologin;
}