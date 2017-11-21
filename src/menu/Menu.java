package menu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Actores;
import entidades.Peliculas;
import entidades.Reparto;
import hibernate.AccesoHibernate;

public class Menu {

	public static void main(String[] args) {
		AccesoHibernate ah = new AccesoHibernate();
		// TODO Auto-generated method stub
		System.out.println("Introduce el numero para realizar la accion");
		System.out.println("1. Insert/Update");
		System.out.println("2. Delete");
		System.out.println("3. Select");
		Scanner scanner = new Scanner(System.in);
		String choice = scanner.nextLine();

		switch (choice) {
		case "1":
			// Perform "original number" case.
			System.out.println("Introduce el numero para realizar la accion");
			System.out.println("1. Insert/Update Actores");
			System.out.println("2. Insert/Update Peliculas");
			System.out.println("3. Insert/Update Reparto");
			String choice11 = scanner.nextLine();

			switch (choice11) {
			case "1":
				Actores actor = new Actores();
				System.out.println("Introduce el id SOLO si quieres hacer update");
				String cod = scanner.nextLine();
				if (!cod.isEmpty()) {
					int codigo = Integer.parseInt(cod);
					actor.setCodigo(codigo);
				} else {
					actor.setCodigo(null);
				}

				System.out.println("Nombre:");

				String nombre = scanner.nextLine();
				actor.setNombre(nombre);
				System.out.println("Introduce fecha Nacimiento en formato yyyy-MM-dd (Ejemplo: 2017-07-97):");
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String Fnacimiento = scanner.nextLine();
				Date FNacimiento = null;
				try {
					FNacimiento = format.parse(Fnacimiento);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				actor.setFNacimiento(FNacimiento);
				System.out.println("Nacionalidad:");
				String nacionalidad = scanner.nextLine();
				actor.setNacionalidad(nacionalidad);
				ah.HibAddOrUp(actor, null, null);
				break;
			case "2":
				Peliculas peli = new Peliculas();
				System.out.println("Introduce el id SOLO si quieres hacer update");
				String codPelicula = scanner.nextLine();
				if (!codPelicula.isEmpty()) {
					int codigoPelicula = Integer.parseInt(codPelicula);
					peli.setCodigo(codigoPelicula);
				} else {
					peli.setCodigo(null);
				}
				System.out.println("Titulo:");
				String titulo = scanner.nextLine();
				peli.setTitulo(titulo);
				System.out.println("Introduce fecha  en formato yyyy-MM-dd (Ejemplo: 2017-07-97):");
				DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
				String fech = scanner.nextLine();
				Date fecha = null;
				try {
					fecha = format2.parse(fech);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				peli.setFecha(fecha);
				System.out.println("Introduce presupuesto:");
				String presupuesto = scanner.nextLine();
				Double pres = Double.parseDouble(presupuesto);
				peli.setPresupuesto(pres);
				ah.HibAddOrUp(null, peli, null);
				break;
			case "3":
				Reparto reparto = new Reparto();
				System.out.println("Introduce el id SOLO si quieres hacer update");
				String codReparto = scanner.nextLine();
				if (!codReparto.isEmpty()) {
					int codigoReparto = Integer.parseInt(codReparto);
					reparto.setCodigo(codigoReparto);
				} else {
					reparto.setCodigo(null);
				}
				
				System.out.println("Actor:");
				Actores actr = new Actores();
				String ctor = scanner.nextLine();
				actr.setCodigo(Integer.parseInt(ctor));
				reparto.setActores(actr);
				
				System.out.println("Titulo:");
				Peliculas pl = new Peliculas();
				String repPel = scanner.nextLine();
				pl.setCodigo(Integer.parseInt(repPel));
				reparto.setPeliculas(pl);
				
				System.out.println("Tipo de papel: principal / secundario");
				String tipPap = scanner.nextLine();
				reparto.setTipoPapel(tipPap);
				ah.HibAddOrUp(null, null, reparto);
				break;
			}

			break;
		case "2":
			// Perform "encrypt number" case.
			System.out.println("Introduce el numero para realizar la accion");
			System.out.println("1. Delete Actores");
			System.out.println("2. Delete Peliculas");
			System.out.println("3. Delete Reparto");
			String choice12 = scanner.nextLine();

			break;
		case "3":
			// Perform "decrypt number" case.
			System.out.println("Introduce el numero para realizar la accion");
			System.out.println("1. Select All Actores");
			System.out.println("2. Select Actores por su key");
			System.out.println("3. Select All Peliculas");
			System.out.println("4. Select Peliculas por su key");
			System.out.println("5. Select All Reparto");
			System.out.println("6. Select Reparto por su key");
			String choice13 = scanner.nextLine();

			break;
		default:
			// The user input an unexpected choice.
			System.out.println("Introduce solo un numero");
		}

	}

}
