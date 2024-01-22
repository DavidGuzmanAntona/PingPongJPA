package dao;

import entidades.Equipo;

public interface EquipoDAO {
	
	public void insertarEquipo(Equipo equipo);
	
	public void updateEqupo(int idEquipo);
	
	public void deleteEquipo(int id);
	
	public Equipo mostrarEquipo(int id);

}
