package liga;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import entidades.Competicion;
import entidades.Equipo;
import entidades.Estadio;
import entidades.Jornada;
import entidades.Jugador;
import entidades.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class CargarDatos {
	
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


	
	
	static void cargarDatosBD() {
		EntityManager entityManager = SimulacionMain.getFactory().createEntityManager();
		entityManager.getTransaction().begin();
		//Crear Competicion		
			Competicion competicion1 = new Competicion("LIGA IBERDROLA SUPERDIVISIÓN FEMENINA", LocalDate.parse("01/02/1980", FORMATTER), 4, 5);			
			entityManager.persist(competicion1);
		//Crear Estadio
			Estadio estadio1= new Estadio("CENTRO DE TECNIFICACION DE TENIS DE MESA", "AV. DE LA JUVENTUD 3", 300);
			Estadio estadio2= new Estadio("SALA MUNICIPAL TENIS DE MESA - ANEXO PABELLON CUATRO SANTOS", "C/ LUGO, S N - BDA. CUATRO SANTOS", 80);
			Estadio estadio3= new Estadio("PAVELLO MUNICIPAL D ESPORTS CASTELL D EN PLANES", "CARRETERA DE GURB, 1 (PLACA PARE MILLAN, S N)", 90);
			Estadio estadio4= new Estadio("SALA DE TENIS DE MESA DE BURGOS", "C/ LA BUREBA S/N NAVES RIO PICO nº 7", 220);
			Estadio estadio5= new Estadio("CLUB TENNIS TAULA GANXETS DE REUS", "CARRER. D'EVARIST FABREGAS, Nº 9", 110);
			Estadio estadio6= new Estadio("CENTRO DE TECNIFICACION DE TENIS DE MESA SONIA ETXAZARRETA", "C/OLAKETA S N", 60);
			

			
		//Crear Equipos
			Equipo equipo1 = new Equipo("MUSEO DE LA ALMENDRA FRANCISCO MORALES", "Córdoba", 14800, "Butterfly R40+*** - Blanca", "	Butterfly Europa 25 - - Azul", estadio1 );
			Equipo equipo2 = new Equipo("UCAM CARTAGENA TM", "Barcelona", 28360, "Butterfly R40+*** - Blanca", "Butterfly Europa 25 - - Azul", estadio2);
			Equipo equipo3 = new Equipo("GIRBAU VIC T.T.", "Sevilla", 48500, "Butterfly R40+*** - Blanca", "Butterfly Europa 25 - - Azul", estadio3);
			Equipo equipo4 = new Equipo("UNIVERSIDAD DE BURGOS - RM TERÁN", "Cadiz", 29360, "Joola Flash 40+*** - Blanca", "Joola 2000-S Pro - - Azul", estadio4);
			Equipo equipo5 = new Equipo("MIRÓ GANXETS REUS", "Badajoz", 23139, "Butterfly R40+*** - Blanca", "Butterfly Europa II - - Gris", estadio5);
			Equipo equipo6 = new Equipo("IRUN LEKA ENEA", "Valencia", 12345, "Joola Flash 40+*** - Blanca", "Butterfly Europa 25 - - Azul", estadio6);
			
			estadio1.setEquipo(equipo1);
			estadio2.setEquipo(equipo2);
			estadio3.setEquipo(equipo3);
			estadio4.setEquipo(equipo4);
			estadio5.setEquipo(equipo5);
			estadio6.setEquipo(equipo6);
			

			entityManager.persist(equipo1);
			entityManager.persist(equipo2);
			entityManager.persist(equipo3);
			entityManager.persist(equipo4);
			entityManager.persist(equipo5);
			entityManager.persist(equipo6);
			
			entityManager.persist(estadio1);
			entityManager.persist(estadio2);
			entityManager.persist(estadio3);
			entityManager.persist(estadio4);
			entityManager.persist(estadio5);
			entityManager.persist(estadio6);
			
		//Asignar competicion a equipos
			equipo1.setCompeticion(competicion1);	
			equipo2.setCompeticion(competicion1);
			equipo3.setCompeticion(competicion1);	
			equipo4.setCompeticion(competicion1);
			equipo5.setCompeticion(competicion1);
			equipo6.setCompeticion(competicion1);

		// Crear jugadores y asignarlos a los equipos 	
			
			equipo1.setJugadores(List.of(
					new Jugador(27020, "ISABEL CONCHILLO MARTINEZ", "ESPAÑOLA", LocalDate.parse("01/09/1991", FORMATTER), false, false),
					new Jugador(39598, "JIAQI MENG ", "CHINA", LocalDate.parse("01/09/2010", FORMATTER), false, false),
					new Jugador(21949, "JULIA MARTIN LINARES", "ESPAÑOLA", LocalDate.parse("01/09/1996", FORMATTER), false, false),
					new Jugador(41792, "KINGA IZABELLA STEFANSKA ", "POLACA", LocalDate.parse("01/09/2001", FORMATTER), false, false),
					new Jugador(39242, "KRISTAL ALONDRA MELENDEZ LAFONTAINE", "PUERTORIQUEÑA", LocalDate.parse("01/09/1999", FORMATTER), false, false)
					));		
			equipo2.setJugadores(List.of(
					new Jugador(19183, "CARMEN LOZANO MIRÓN", "ESPAÑOLA", LocalDate.parse("01/09/2012", FORMATTER), false, false),
					new Jugador(34298, "FEN LI ", "SUECA", LocalDate.parse("01/09/2010", FORMATTER), false, false),
					new Jugador(9486, "MARIA XIAO YAO", "ESPAÑOLA", LocalDate.parse("01/09/2009", FORMATTER), false, false),
					new Jugador(29161, "MIRIAN SEGURA FERNANDEZ", "ESPAÑOLA", LocalDate.parse("01/09/2003", FORMATTER), false, false),
					new Jugador(31669, "SILVIA ASIS DE SOUZA ERDELJI", "HUNGARA", LocalDate.parse("01/09/1995", FORMATTER), false, false)
					));
			equipo3.setJugadores(List.of(
					new Jugador(41902, "AIRI ABE", "JAPONES", LocalDate.parse("01/09/2012", FORMATTER), false, false),
					new Jugador(36159, "ANETA JUSTYNA OLENZKA-DZIENIEL ", "POLACA", LocalDate.parse("01/09/2002", FORMATTER), false, false),
					new Jugador(27607, "CAMILA RENATA MOSCOSO RAYA", "ESPAÑOLA", LocalDate.parse("01/09/2005", FORMATTER), false, false),
					new Jugador(33839, "CHARLOTTE CAREY ", "GALESA", LocalDate.parse("01/09/2008", FORMATTER), false, false),
					new Jugador(24301, "IRINA GIMENO FONT", "ESPAÑOLA", LocalDate.parse("01/09/2007", FORMATTER), false, false)
					));
			equipo4.setJugadores(List.of(
					new Jugador(42191, "ALBA GONZALEZ LAZARO", "ESPAÑOLA", LocalDate.parse("01/09/2005", FORMATTER), false, false),
					new Jugador(40685, "ALICIA DONCEL CARBALLO", "HUNGARA", LocalDate.parse("01/09/2001", FORMATTER), false, false),
					new Jugador(27846, "ANNAMARIA ERDELYI ", "Español", LocalDate.parse("01/09/2002", FORMATTER), false, false),
					new Jugador(22454, "CANDELA MOLERO ", "ARGENTINA", LocalDate.parse("01/09/1990", FORMATTER), false, false),
					new Jugador(8357, "CLARA IZQUIERDO ALONSO", "ESPAÑOLA", LocalDate.parse("01/09/2000", FORMATTER), false, false)
					));
			equipo5.setJugadores(List.of(
					new Jugador(38624, "AINA ARAQUE SOLER", "ESPAÑOLA", LocalDate.parse("01/09/2003", FORMATTER), false, false),
					new Jugador(17755, "ALBA VIRGILI CAPDEVILA", "ESPAÑOLA", LocalDate.parse("01/09/2003", FORMATTER), false, false),
					new Jugador(41971, "DEIMANTE ADLYTE ", "LITUANA", LocalDate.parse("01/09/2009", FORMATTER), false, false),
					new Jugador(19272, "ELVIRA FIONA RAD HIND", "ESPAÑOLA", LocalDate.parse("01/09/1994", FORMATTER), false, false),
					new Jugador(42996, "HINA KIZUKA ", "JAPONES", LocalDate.parse("01/09/2007", FORMATTER), false, false)
					));
			equipo6.setJugadores(List.of(
					new Jugador(19220, "ANA PEDREGOSA LADRON DE GUEVARA", "ESPAÑOLA", LocalDate.parse("01/09/2002", FORMATTER), false, false),
					new Jugador(19691, "ANGELA RODRÍGUEZ GARCIA", "ESPAÑOLA", LocalDate.parse("01/09/2006", FORMATTER), false, false),
					new Jugador(36884, "CLAUDIA RODRIGUEZ ZABALETA", "ESPAÑOLA", LocalDate.parse("01/09/2001", FORMATTER), false, false),
					new Jugador(41880, "DAEUN LEE", "JAPONES", LocalDate.parse("01/09/2008", FORMATTER), false, false),
					new Jugador(17118, "IOANA TECLA GHEMES", "ESPAÑOLA", LocalDate.parse("01/09/2007", FORMATTER), false, false)
					));
			
		//Crear Patrocinadores
			
			Patrocinador Patrocinador1 = new Patrocinador("CocaCola", 2000);
			Patrocinador Patrocinador2 = new Patrocinador("PriscoMovile", 600);
			Patrocinador Patrocinador3 = new Patrocinador("L'escala Empúries", 1200);
			Patrocinador Patrocinador4 = new Patrocinador("Anguriñas", 3000);
			Patrocinador Patrocinador5 = new Patrocinador("Burguer King", 3100);
			Patrocinador Patrocinador6 = new Patrocinador("Ikea", 6320);
			
			entityManager.persist(Patrocinador1);
			entityManager.persist(Patrocinador2);
			entityManager.persist(Patrocinador3);
			entityManager.persist(Patrocinador4);
			entityManager.persist(Patrocinador5);
			entityManager.persist(Patrocinador6);
					
			List<Patrocinador> patrocinio1 = List.of(Patrocinador1, Patrocinador2);
			List<Patrocinador> patrocinio2 = List.of(Patrocinador3);
			List<Patrocinador> patrocinio3 = List.of(Patrocinador3,Patrocinador1 );
			List<Patrocinador> patrocinio4 = List.of(Patrocinador4, Patrocinador2);
			List<Patrocinador> patrocinio5 = List.of(Patrocinador4, Patrocinador5);
			List<Patrocinador> patrocinio6 = List.of(Patrocinador2, Patrocinador5, Patrocinador6);
			
			equipo1.setPatrocinador(patrocinio1);
			equipo2.setPatrocinador(patrocinio2);
			equipo3.setPatrocinador(patrocinio3);
			equipo4.setPatrocinador(patrocinio4);
			equipo5.setPatrocinador(patrocinio5);
			equipo6.setPatrocinador(patrocinio6);

			
			
			// Crear una jornada
		    Jornada jornada1 = new Jornada("Primera Jornada");
		    Jornada jornada2 = new Jornada("Segunda Jornada");
		    Jornada jornada3 = new Jornada("Tercera Jornada");
		    Jornada jornada4 = new Jornada("Cuarta Jornada");
		    Jornada jornada5 = new Jornada("Quinta Jornada");
		    
		    competicion1.setJornadas(List.of(jornada1, jornada2, jornada3, jornada4, jornada5));
		    
		    entityManager.persist(jornada1);
		    entityManager.persist(jornada2);
		    entityManager.persist(jornada3);
		    entityManager.persist(jornada4);
		    entityManager.persist(jornada5);
		    
		    entityManager.getTransaction().commit();
		    entityManager.close();
		   	}


}
