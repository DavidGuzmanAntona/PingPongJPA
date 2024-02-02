package liga;

import java.util.List;

import consultas.ConsultasCompeticion;
import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Competicion;
import entidades.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


public class SimulacionMain {

	public static void main(String[] args) {

		EquipoImplementacionDAO eIDAO = new EquipoImplementacionDAO();
		JugadorImplementacionDAO jIDAO = new JugadorImplementacionDAO();

		// Cargar Datos en la BD
		CargarDatos.cargarDatosBD();
/*
		// Simulacion Jornada
		List<Equipo> listaEquipos = eIDAO.findAll();
		SimulacionPartidos.simularJornada(listaEquipos);

		// Fichajes
		FichajesTemporada.intercambiox2(eIDAO, jIDAO);
		FichajesTemporada.eliminarx2(jIDAO);		
		FichajesTemporada.nuevoFichajex2(eIDAO);
*/

		// Consultas
	//	ConsultasCompeticion.consulta1();
	//	ConsultasCompeticion.consulta2();
	//	ConsultasCompeticion.consulta3("UCAM CARTAGENA TM");
	//	ConsultasCompeticion.consulta4("UCAM CARTAGENA TM");
	//	ConsultasCompeticion.consulta6("UCAM CARTAGENA TM");
	//	ConsultasCompeticion.consulta7();
	//	ConsultasCompeticion.consulta9();
	//	ConsultasCompeticion.consulta10();
	//	ConsultasCompeticion.consulta10();

		



	}

	

	

	

}
