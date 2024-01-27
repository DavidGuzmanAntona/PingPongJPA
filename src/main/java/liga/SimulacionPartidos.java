package liga;

import java.util.List;
import java.util.Random;

import entidades.Equipo;

public class SimulacionPartidos {
	
	
	private static void simularJornada(List<Equipo> equiposLiga) {
		
		System.out.println("Iniciando simulacion de Jornada:");
		
		Random random = new Random();
		
		for (int i = 0; i < equiposLiga.size(); i++) {
            for (int j = i + 1; j < equiposLiga.size(); j++) {
                Equipo equipoLocal = equiposLiga.get(i);
                Equipo equipoVisitante = equiposLiga.get(j);
                int equipoLocRes = random.nextInt(6);
                int equipoVisRes = 5-equipoLocRes;
               
                
                if(equipoLocRes>equipoVisRes) {
                	equipoLocal.sumarVictoria();
                	equipoVisitante.sumarDerrota();
                	
                	System.out.println("El equipo: "+equipoLocal.getNombre()+ "Gana el partido contra: "+ equipoVisitante.getNombre());
                
                }else if(equipoLocRes<equipoVisRes) {
                	equipoVisitante.sumarVictoria();
                	System.out.println("El equipo: "+equipoVisitante.getNombre()+ "Gana el partido contra: "+ equipoLocal.getNombre());
                	
                }else{
                	equipoVisitante.sumarEmpate();
                	equipoLocal.sumarEmpate();
                	System.out.println("El equipo: "+equipoLocal.getNombre()+ "Empata el partido contra: "+ equipoVisitante.getNombre());
                	
                }
                
                updateDBResultados(equipoLocal, equipoVisitante, equipoLocRes, equipoVisRes);
                
				
			}
		}
		
	}

	private static void updateDBResultados(Equipo equipoLocal, Equipo equipoVisitante, int equipoLocRes,
			int equipoVisRes) {
		
		
	}


	
	
	
	

}
