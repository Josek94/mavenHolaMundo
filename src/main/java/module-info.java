module pruebamaven.holamundo {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.desktop;
	requires poi.ooxml;
	requires javafx.graphics;
	requires org.apache.pdfbox;

    opens pruebamaven.holamundo to javafx.fxml;
    exports pruebamaven.holamundo;
}
