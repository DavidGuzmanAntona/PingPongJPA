package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Match")
public class Partido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdMAtch")
    private Long id;
    
    @Column(name = "MatchWinner")
    private String Resultado ;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipo equipoVisitante;

    @ManyToOne
    @JoinColumn(name = "jornada_id")
    private Jornada jornada;

	public Partido() {
		super();
	}



	public Partido( Equipo equipoLocal, Equipo equipoVisitante, Jornada jornada, Equipo resultado) {
		super();
		
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.jornada = jornada;
		Resultado = resultado;
	}


	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public Long getId() {
		return id;
	}

	public Equipo getResultado() {
		return Resultado;
	}

	public void setResultado(String string) {
		Resultado = string;
	}

    
    
    
}
