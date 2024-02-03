package liga;

import java.util.List;

import consultas.ConsultasCompeticion;
import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Equipo;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Clase principal y ejecutable desde donde llamaremos a todos los métodos
 * principales del programa: Cargar Datos, simular jornada, fichajes y
 * consultas. Tambien abrimos un EntityManagerFactory que se utilizara por todo
 * el programa para realizar la conexión a la BD.
 * 
 * @author DavidGuzmán
 * @version 1.0
 * @since 2024-02-03
 */

public class SimulacionMain {

	public static EntityManagerFactory factory = Persistence.createEntityManagerFactory("competicion");

	public static void main(String[] args) {

		EquipoImplementacionDAO eIDAO = new EquipoImplementacionDAO();
		JugadorImplementacionDAO jIDAO = new JugadorImplementacionDAO();

		// Cargar Datos en la BD
		CargarDatos.cargarDatosBD();

		// Simulacion Jornada
		List<Equipo> listaEquipos = eIDAO.findAll();
		SimulacionPartidos.simularJornada(listaEquipos);

		// Fichajes

		System.out.println("Comienzan los fichajes");
		FichajesTemporada.intercambiox2(eIDAO, jIDAO);
		FichajesTemporada.eliminarx2(jIDAO);
		FichajesTemporada.nuevoFichajex2(eIDAO);

		// Consultas
		ConsultasCompeticion.consulta1();
		ConsultasCompeticion.consulta2();
		ConsultasCompeticion.consulta3("UCAM CARTAGENA TM");
		ConsultasCompeticion.consulta4("IRUN LEKA ENEA");
		ConsultasCompeticion.consulta5("IRUN LEKA ENEA");
		ConsultasCompeticion.consulta6("UCAM CARTAGENA TM");
		ConsultasCompeticion.consulta7();
		ConsultasCompeticion.consulta8();
		ConsultasCompeticion.consulta9();
		ConsultasCompeticion.consulta10();
		ConsultasCompeticion.consulta11();
		ConsultasCompeticion.consulta12();
		ConsultasCompeticion.consulta13("MIRÓ GANXETS REUS", "IRUN LEKA ENEA");
		ConsultasCompeticion.consulta14_1();
		ConsultasCompeticion.consulta14_2();
		ConsultasCompeticion.consulta14_3();

		factory.close();

	}

	public static EntityManagerFactory getFactory() {
		return factory;
	}

	public static void setFactory(EntityManagerFactory factory) {
		SimulacionMain.factory = factory;
	}

}
