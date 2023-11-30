<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Turno"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
    <%@include file="componentes/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <!-- Agregar un Nuevo Turno -->
            <div class="container mt-4">
                <h3>Agregar un Nuevo Turno</h3>
                <form action="SvTurno" method="post">
                    <div class="mb-3">
                        <label for="fechaTurno" class="form-label">Fecha del Turno:</label>
                        <input type="date" class="form-control" id="fechaTurno" name="fechaTurno" required>
                    </div>
                    <div class="mb-3">
                        <label for="tramite" class="form-label">Descripción del Trámite:</label>
                        <textarea class="form-control" id="tramite" name="tramite" required></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="estadoTramite" class="form-label">Estado del Trámite:</label>
                        <select class="form-select" id="estadoTramite" name="estadoTramite" required>
                            <option value="" selected disabled>Selecciona el estado del trámite</option>
                            <option value="false">En espera</option>
                            <option value="true">Ya atendido</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="ciudadanoAsignado" class="form-label">ID Ciudadano Asignado:</label>
                        <input type="text" class="form-control" id="ciudadanoAsignado" name="ciudadanoAsignado" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Agregar Turno</button>
                </form>
                
            </div>
        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">  
            </div>
        </footer>
    </div>
</div>
</html>
