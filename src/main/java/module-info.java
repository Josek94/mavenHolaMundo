module pruebamaven.holamundo {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires poi.ooxml;
	requires javafx.graphics;

    opens pruebamaven.holamundo to javafx.fxml;
    exports pruebamaven.holamundo;
}
