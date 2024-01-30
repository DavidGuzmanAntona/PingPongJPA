package liga;

import java.util.List;

import daoImplementacion.EquipoImplementacionDAO;

import entidades.Equipo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class SimulacionMain {

	public static void main(String[] args) {
		
		EquipoImplementacionDAO eIDAO = new EquipoImplementacionDAO();

		// Cargar Datos en la BD
		CargarDatos.cargarDatosBD();
		

		// Simulacion Jornada
		
		//List<Equipo> listaEquipos = eIDAO.findAll();
	//	System.out.println(listaEquipos.toString());
	//	SimulacionPartidos.simularJornada(listaEquipos);

	}

}
