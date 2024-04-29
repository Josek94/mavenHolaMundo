module pruebamaven.holamundo {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires poi.ooxml;

    opens pruebamaven.holamundo to javafx.fxml;
    exports pruebamaven.holamundo;
}
