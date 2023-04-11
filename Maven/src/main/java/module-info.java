module org.openjfx.Maven {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;

    opens org.openjfx.Maven to javafx.fxml;
    exports org.openjfx.Maven;
}
