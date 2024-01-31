package liga;

import java.util.List;

import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Equipo;


public class SimulacionMain {

	public static void main(String[] args) {

		EquipoImplementacionDAO eIDAO = new EquipoImplementacionDAO();
		JugadorImplementacionDAO jIDAO = new JugadorImplementacionDAO();

		// Cargar Datos en la BD
		//CargarDatos.cargarDatosBD();

		// Simulacion Jornada
		List<Equipo> listaEquipos = eIDAO.findAll();
		SimulacionPartidos.simularJornada(listaEquipos);

		// Fichajes
		FichajesTemporada.intercambiox2(eIDAO, jIDAO);
		FichajesTemporada.eliminarx2(jIDAO);		
		FichajesTemporada.nuevoFichajex2(eIDAO);

	}

	

	

	

}
