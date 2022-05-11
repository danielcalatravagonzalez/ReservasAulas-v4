package org.iesalandalus.programacion.reservasaulas.mvc.vista.grafica.controladores;

import javafx.fxml.FXML;

import org.iesalandalus.programacion.reservasaulas.mvc.controlador.IControlador;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ControladorPaginaPrincipal {
	private IControlador controladorMVC;
	  @FXML
	    private TableColumn<Aula, String> tcNombreAula;
	  @FXML
	    private TableColumn<Aula, String> tcNumPuestos;
	  @FXML
	    private TableView<Aula> tvAulas;
	  
	  private ObservableList<Aula> aulas = FXCollections.observableArrayList();
	  
	  @FXML
	  private void initialize() {
		  tcNombreAula.setCellValueFactory(aula -> new SimpleStringProperty(aula.getValue().getNombre()));
		  tcNumPuestos.setCellValueFactory(aula -> new SimpleStringProperty(Integer.toString(aula.getValue().getPuestos())));
		  tvAulas.setItems(aulas);
	  }
	  public void setControladorMVC (IControlador controladorMVC) {
		  this.controladorMVC = controladorMVC;
	  }
	  public void inicializa () {
		  aulas.setAll(controladorMVC.getAulas());
	  }

}
