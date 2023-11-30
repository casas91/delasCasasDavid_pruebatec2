package logica;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import persistencia.ControladoraPersistencia;

public class Controladora {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearCiudadano(String nombre, String apellido) {

        Ciudadano ciu = new Ciudadano();

        ciu.setNombre(nombre);
        ciu.setApellido(apellido);

        controlPersis.crearCiudadano(ciu);

    }

    public void crearTurno(LocalDate fecha, String tramite, Boolean estadoTramite, Ciudadano unCiudadano) {
        Turno turn = new Turno();
        turn.setFecha(fecha);
        turn.setTramite(tramite);
        turn.setEstado(estadoTramite);
        turn.setUnCiudadano(unCiudadano);

        controlPersis.crearTurno(turn);
    }

    public Ciudadano obtenerCiudadanoPorId(Long idCiudadano) {
        return controlPersis.obtenerCiudadanoPorId(idCiudadano);
    }

    public List<Ciudadano> obtenerListaCiudadanos() {
        return controlPersis.listarCiudadanos();
    }

    public List<Turno> obtenerListaTurnos() {
        return controlPersis.listarTurnos();
    }

    public List<Turno> obtenerListaFiltradaFecha(LocalDate fechaConsulta){
    return controlPersis.listarTurnos().stream()
            .filter(f->f.getFecha().equals(fechaConsulta))
            .collect(Collectors.toList());
    }
    
    public List<Turno> obtenerListaFiltradaFechaEstado(LocalDate fechaConsulta, Boolean estadoTramite){
        return controlPersis.listarTurnos().stream()
            .filter(f->f.getFecha().equals(fechaConsulta))
            .filter(f->f.getEstado().equals(estadoTramite))
            .collect(Collectors.toList());
    }
    

    public void cambiarEstadoYaAtendido(Long id) {
        controlPersis.cambiarEstadoTurno(id, true);
    }

}
