package liga;

import daoImplementacion.EquipoImplementacionDAO;
import daoImplementacion.JugadorImplementacionDAO;
import entidades.Equipo;
import entidades.Jugador;
import jakarta.persistence.EntityTransaction;

public class FichajesTemporada24 {
	
	private static EquipoImplementacionDAO equipoDAO;
	private static JugadorImplementacionDAO jugadorDAO;
	
	
	
	
	public static void intercambiarJugadores(Equipo equipoOrigen, Equipo equipoDestino, Jugador jugadorOrigen,  Jugador jugadorDestino ) {
		
/*		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		//Intercambiar jugdores
		try {
			jugadorDAO.updateEquipo(jugadorOrigen.getIdDeportista(), equipoDestino);
			jugadorDAO.updateEquipo(jugadorDestino.getIdDeportista(), equipoOrigen);
			
			entityManager.merge();
			
			//Añade el jugador al equipo
			
			transaction.commit();
		} catch (Exception e) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
			System.out.println("Error en la transaccion"+ e.getMessage());
			
		}
		
	}
	public static void eliminarJugadores() {
*/		
	}
	

}


