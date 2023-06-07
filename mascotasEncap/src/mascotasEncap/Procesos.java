package mascotasEncap;

import javax.swing.JOptionPane;
import java.util.HashMap;

public class Procesos {

	String mensaje2;
	
	HashMap<String, Mascota> mapaMascotas = new HashMap<String, Mascota>();

	public void iniciar() {

		int opcion;

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu()));
			validarOpcion(opcion);
		} while (opcion != 5);
	}

	private String menu() {

		String menu = "";

		menu += "---- menu ----";
		menu += "\n\nIngrese una opcion:\n";
		menu += "\n1- Registrar mascotas.";
		menu += "\n2- Consultar lista de mascotas.";
		menu += "\n3- Consultar mascota.";
		menu += "\n4- Modificar datos de una mascota.";
		menu += "\n5- Salir.\n\n";

		return menu;
	}

	private void validarOpcion(int opcion) {

		switch (opcion) {

		case 1:
			registrarMascotas();
			break;

		case 2:
			if (!mapaMascotas.isEmpty()) {
				listaMascotas();
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese almenos un registro");
			}
			break;

		case 3:
			if (!mapaMascotas.isEmpty()) {
				buscarMascota();
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese almenos un registro");
			}
			break;

		case 4:
			if (!mapaMascotas.isEmpty()) {
				actualizarMascota();
			} else {
				JOptionPane.showMessageDialog(null, "Ingrese almenos un registro");
			}
			break;

		case 5: JOptionPane.showMessageDialog(null, "Gracias por usar el programa");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opcion incorrecta");
		}
	}


	private void registrarMascotas() {
		int n, edad;
		String nombre, ide, especie;

		n = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas"));

		for (int i = 0; i < n; i++) {

			Mascota mascota = new Mascota();
			
			nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota #" + (i+1));
			mascota.setNombre(nombre);
			ide = JOptionPane.showInputDialog("Ingrese el ide de " + mascota.getNombre());
			especie = JOptionPane.showInputDialog("Ingrese la especie de " +mascota.getNombre());
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " +mascota.getNombre()));
			
			mascota.setIdentificacion(ide);
			mascota.setEspecie(especie);
			mascota.setEdad(edad);
			
			mapaMascotas.put(mascota.getIdentificacion(), mascota);
		}
	}

	
	public void listaMascotas() {

		String mensaje = "---- mascotas registradas ----\n";
		
		for (Mascota mascota : mapaMascotas.values()) {
			mensaje += "Identificacion: " + mascota.getIdentificacion() + "\n";
			mensaje += "Nombre: " + mascota.getNombre() + "\n";
			mensaje += "Especie: " + mascota.getEspecie() + "\n";
			mensaje += "Edad: " + mascota.getEdad() + "\n";
			mensaje += "Sonido: " + mascota.hacerSonido() + "\n";
			mensaje += "Actividades: " + mascota.actividades() + "\n";
			mensaje += "comer: " + mascota.comer(mascota.getNombre()) + "\n \n";
		}

		JOptionPane.showMessageDialog(null, mensaje);
	}

	
	public void buscarMascota() {
		String mensaje = null;
		
		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");
		
		if (mapaMascotas.containsKey(identificacion)) {
			
			Mascota mascota = mapaMascotas.get(identificacion);
			mensaje = "---- Buscar máscota por ide: " + identificacion + "----\n";

			mensaje += "Identificacion: " + mascota.getIdentificacion() + "\n";
			mensaje += "Nombre: " + mascota.getNombre() + "\n";
			mensaje += "Especie: " + mascota.getEspecie() + "\n";
			mensaje += "Edad: " + mascota.getEdad() + "\n";
			mensaje += "Sonido: " + mascota.hacerSonido() + "\n";
			mensaje += "Actividades: " + mascota.actividades() + "\n";
			mensaje += "comer: " + mascota.comer(mascota.getNombre());
			mensaje += "\n \n";
			
			JOptionPane.showMessageDialog(null, mensaje);
			
		} else {
			JOptionPane.showMessageDialog(null, "La identificación de la mascota ingresada no se encuentra en el sistema");
		}
	}
	
	
	private void actualizarMascota() {

		String identificacion = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota a consultar");
		
		String nombre = "", especie = "";
		int edad = 0, opcion = 0; 
		
		if (mapaMascotas.containsKey(identificacion)) {
			
			Mascota mascota = mapaMascotas.get(identificacion);
			
			do {				
				opcion = Integer.parseInt(JOptionPane.showInputDialog("Elija que desea actualizar: 1.Nombre | 2.Especie | 3.Edad"));
			}while(opcion < 1 || opcion > 3);
			
			switch (opcion) {
				
			case 1:
				nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre de " +mascota.getNombre());
				mascota.setNombre(nombre);
				break;
					
			case 2:
				especie = JOptionPane.showInputDialog("Ingrese la nueva especie de " +mascota.getNombre());
				mascota.setEspecie(especie);
				break;
				
			case 3:
				edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad de " +mascota.getNombre()));
				mascota.setEdad(edad);
				break;
			}	
			
			JOptionPane.showMessageDialog(null, "Actualizacion exitosa");
			
		}else {
			JOptionPane.showMessageDialog(null, "La identificacion ingresada no se encuentra en el sistema");
		}
	}
	
}
