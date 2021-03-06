//Paquete al que pertence la clase
package manejador_archivo;

//Importaciones
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

//La Clase Conexion permitira comunicarse con el archivo que alberga los procesos
public class Conexion {
	
	//ATRIBUTOS DE LA CLASE
	private final String DIRECCION_ARCHIVO="recursos/receptor/procesos.txt";//Direccion del archivo con las descripciones de los procesos
	private File Archivo=null;//Referencia del archivo
	private FileReader Lector=null;//Referencia del lector
	private BufferedReader FlujoLector=null;//Referencia del flujo lector
	
	
	//Constructor Conexion
	public Conexion() {
		//Vacio
	}
	
	
	
							//INICIAR LA RECUPERACION
	
	
	//Verificamos si en la direccion dada 'DIRECCION_ARCHIVO' existe un archivo (Primera Fase)
	public File ObtenerArchivo() {
		//Control de Excepciones
		try {
			//Se intenta obtener el archivo
			Archivo=new File(DIRECCION_ARCHIVO);
			
			//Comprobamos que exista
			if((Archivo.exists()) && (!Archivo.isDirectory())) {
				//Existe
				return Archivo;
			}else {
				//No existe	
				System.err.println("Error de lectura: el archivo no existe o es un directorio, Direccion Provista:'"+DIRECCION_ARCHIVO+"' <Err:Primera Fase>");
				//Abortar conexion
				CerrarLectura();
				return null;
			}
		} catch (Exception e) {
			//Excepcion
			System.err.println("Error de lectura: ha ocurrido un error al momento de obtener el archivo desde la direccion indicada, Direccion Provista: '"+DIRECCION_ARCHIVO+"' <Err:Primera Fase>");
			//Abortar conexion
			CerrarLectura();
			return null;
		}
	}
	
	
	//En este metodo se tratara de definir el lector en base al archivo previamente encontrado (Segunda Fase)
	public FileReader DefinirLector(File referencia) {
		//Control de Excepciones
		try {
			
			//Se trata de definir el lector del archivo
			Lector=new FileReader(referencia);
			
			//Se comprueba que la definicion sea exitosa
			if(Lector!=null) {
				//Exitosa
				return Lector;
			}else {
				//Error
				System.err.println("Error de lectura: no se pudo definir el lector en base al archivo proporcionado <Err:Segunda Fase>");
				//Abortar conexion
				CerrarLectura();
				return null;
			}
			
		} catch (Exception e) {
			//Excepcion
			System.err.println("Error de lectura: ha ocurrido un error al momento de establecer el lector <Err:Segunda Fase>");
			//Abortar conexion
			CerrarLectura();
			return null;
		}
	}
	
	
	//Metodo para tratar de establecer el flujo lector (Tercera Fase)
	public BufferedReader DefinirFlujoLector(FileReader referencia) {
		//Control de excepciones
		try {
			
			//Se trata de definir el flujo lector del archivo
			FlujoLector=new BufferedReader(referencia);
			
			//Se comprueba que la definicion sea exitosa
			if(FlujoLector!=null) {
				//Exitosa
				return FlujoLector;
			}else {
				//Error
				System.err.println("Error de lectura: no se pudo definir el flujo lector en base al lector proporcionado <Err:Tercera Fase>");
				//Abortar conexion
				CerrarLectura();
				return null;
			}
			
		} catch (Exception e) {
			//Excepcion
			System.err.println("Error de lectura: ha ocurrido un error al momento de definir el flujo lector <Err:Tercera Fase>");
			//Abortar conexion
			CerrarLectura();
			return null;
		}
	}
	
	
						//FINALIZAR LA RECUPERACION
	
	
	//Metodo para cerrar el flujo de lectura con el archivo
	public void CerrarLectura() {
		try {FlujoLector.close();}catch(Exception e) {}//Cerrar flujo
		try {Lector.close();}catch(Exception e) {}//Cerrar Lector
	}
	
	
}
