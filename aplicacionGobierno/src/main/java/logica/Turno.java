
package logica;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Turno implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tramite;
    private Boolean estadoTramite;
    private LocalDate fecha;
    
    @ManyToOne
    @JoinColumn(name = "ciudadano_id")
    private Ciudadano unCiudadano;
    

    public Turno(Long id, String tramite, Boolean estadoTramite, LocalDate fecha, Ciudadano unCiudadano) {
        this.id = id;
        this.tramite = tramite;
        this.estadoTramite = estadoTramite;
        this.fecha = fecha;
        this.unCiudadano = unCiudadano;
    }

    public Turno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTramite() {
        return tramite;
    }

    public void setTramite(String tramite) {
        this.tramite = tramite;
    }

    public Boolean getEstado() {
        return estadoTramite;
    }

    public void setEstado(Boolean estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Ciudadano getUnCiudadano() {
        return unCiudadano;
    }

    public void setUnCiudadano(Ciudadano unCiudadano) {
        this.unCiudadano = unCiudadano;
    }

    
}
    