module org.openjfx.Maven {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.base;
	opens org.openjfx.Maven to javafx.fxml;
    opens Models to javafx.base;
    exports org.openjfx.Maven;
}
