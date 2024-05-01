package pruebamaven.holamundo;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import javafx.fxml.FXML;

public class MenuController {
	
	
	@FXML
	private TextField entradaNombre;
	
	@FXML
	private Label etiquetaNombre;
	
	@FXML
	private void enviarNombre() {
		String nombre = entradaNombre.getText();
		etiquetaNombre.setText("Hola " + nombre + ", ¿que tal?");
	}
	
	@FXML
	private void generarWord() {
		String tituloDocumento = entradaNombre.getText();
		String texto = "Este texto es de prueba";
		
		XWPFDocument documento = new XWPFDocument();//creamos el word
		//Declaramos el titulo y le asignamos algunas propiedades
		XWPFParagraph titulo_doc = documento.createParagraph();
		titulo_doc.setAlignment(ParagraphAlignment.CENTER);
		titulo_doc.setVerticalAlignment(TextAlignment.TOP);
		//Declaramos el parrafo y le asignamos algunas propiedades
		XWPFParagraph parrafo = documento.createParagraph();
		parrafo.setAlignment(ParagraphAlignment.BOTH);
		//formato
		//Para el titulo
		XWPFRun r1 = titulo_doc.createRun();
		r1.setBold(true);
		r1.setText(tituloDocumento);
		r1.setFontFamily("Arial");
		r1.setFontSize(14);
		r1.setTextPosition(10);
		r1.setUnderline(UnderlinePatterns.SINGLE);
		        
		//Para el parrafo
		XWPFRun r2 = parrafo.createRun();
		r2.setText(texto);
		r2.setFontSize(12);
		r2.addCarriageReturn();
		/*
		try {
			File ruta = new File(tituloDocumento+".docx");
		   OutputStream word = new FileOutputStream(ruta);
		    documento.write(word);
		    word.close();
		    Desktop.getDesktop().open(ruta);
		} catch (FileNotFoundException ex) {
		    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
		    Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	*/
		   try {
	            FileChooser fileChooser = new FileChooser();
	            fileChooser.setInitialFileName(tituloDocumento + ".docx");
	            fileChooser.getExtensionFilters().add(new ExtensionFilter("Documentos Word", "*.docx"));
	            File ruta = fileChooser.showSaveDialog(null);
	            if (ruta != null) {
	                OutputStream word = new FileOutputStream(ruta);
	                documento.write(word);
	                word.close();
	                Alert alert = new Alert(AlertType.INFORMATION);
	                alert.setTitle("Éxito");
	                alert.setHeaderText(null);
	                alert.setContentText("Documento generado correctamente");
	                alert.showAndWait();
	            }
	        } catch (FileNotFoundException ex) {
	            System.err.println("Error: No se pudo encontrar el archivo");
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            System.err.println("Error de entrada/salida");
	            ex.printStackTrace();
	        }
	    }
	
	@FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        
    }
	
	@FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
	
	@FXML
    private void salir() throws IOException {
		System.exit(0);
    }
}
