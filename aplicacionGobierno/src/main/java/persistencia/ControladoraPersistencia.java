package persistencia;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Ciudadano;
import logica.Turno;

public class ControladoraPersistencia {

    CiudadanoJpaController ciuJpa = new CiudadanoJpaController();
    TurnoJpaController turnJpa = new TurnoJpaController();

    public ControladoraPersistencia() {
    }

    public void crearCiudadano(Ciudadano ciu) {
        ciuJpa.create(ciu);
    }

    public List<Ciudadano> listarCiudadanos() {
        return ciuJpa.findCiudadanoEntities();
    }

    public void crearTurno(Turno turno) {
        turnJpa.create(turno);
    }

    public Ciudadano obtenerCiudadanoPorId(Long id) {
        return ciuJpa.findCiudadano(id);
    }

    public List<Turno> listarTurnos() {
        return turnJpa.findTurnoEntities();
    }
    

    public List<Turno> buscarTurnosFecha(LocalDate fecha){
        return turnJpa.findTurnoEntities().stream().filter(t -> t.getFecha().equals(fecha)).toList();
    }
    
    public List<Turno> buscarTurnosFechaEstado(LocalDate fecha, Boolean estadoTramite){
        return turnJpa.findTurnoEntities().stream().filter(t -> t.getFecha().equals(fecha)).filter(e -> e.getEstado()).toList();
    }
    
    public void modificarTurno (Turno turno){
        try{
            turnJpa.edit(turno);
        }catch(Exception e){
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void cambiarEstadoTurno(Long id, Boolean nuevoEstado) {
        Turno turno = turnJpa.findTurno(id);
        turno.setEstado(nuevoEstado);
        try {
            turnJpa.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

}