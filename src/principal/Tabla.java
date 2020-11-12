package principal;

import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

//Clase Tabla para hacer posible la gesti�n de empleados
public class Tabla extends JTable{
	
	//Modelo de la tabla
	private DefaultTableModel modeloTabla;
	
	//Constructor
	public Tabla(){
		
	
		//Caracter�sticas del modelo de tabla empleado
		modeloTabla=new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID","Estado", "T. llegada","P. Inicial ","P. Actual", "T. Procesador Requerido", "T. Procesador restante",
				"M. requerida", "Ubicaci�n en Memoria", "Impresora Solicitada","Impresora Asignada"," Scaner Solicitado", 
				"Scaner Asignado", "Modem Solicitado", "Modem Asignado", "CD Solicitado", "CD Asignado"
			}
		);
		
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setDefaultEditor(Object.class,null);
		this.setModel(modeloTabla);



	}
	

	
}
