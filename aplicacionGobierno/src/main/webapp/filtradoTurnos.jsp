<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.Turno"%>
<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>


<%
    Controladora control = new Controladora();
    List<Turno> turnos = control.obtenerListaTurnos();
    List<Turno> turnosFiltrados = (List<Turno>) request.getAttribute("turnosFiltrados");
%>

<!DOCTYPE html>
<html lang="es">
    <%@include file="componentes/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid">
                <h1 class="mt-4">Ver Turnos</h1>
                <div class="card mb-3"> 
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Número de Turno</th>
                                        <th>Fecha</th>
                                        <th>Descripción del Trámite</th>
                                        <th>Estado del Trámite</th>
                                        <th>ID Ciudadano Asignado</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for (Turno turno : turnos) {%>
                                    <tr>
                                        <td><%= turno.getId()%></td>
                                        <td><%= turno.getFecha()%></td>
                                        <td><%= turno.getTramite()%></td>
                                        <td><%= turno.getEstado() ? "Ya atendido" : "En espera"%></td>
                                        <td><%= turno.getUnCiudadano().getId()%></td>
                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container mt-4">
                <h3>Filtrar Turnos</h3>

                <!-- Formulario para filtrar por fecha -->
                <form action="SvFiltrado" method="POST">
                    <div class="row mb-3">
                        <div class="col-md-2">
                            <label for="fechaConsulta" class="form-label">Buscar por Fecha:</label>
                            <input type="date" class="form-control" id="fechaConsulta" name="fechaConsulta">
                        </div>
                        <div class="col-md-2">
                            <button type="submit" class="btn btn-primary">Filtrar por Fecha</button>
                        </div>
                    </div>
                </form>
                <!-- Mostrar la lista de turnos filtrados por fecha y posible modificación del estado-->
                               

                <!-- Formulario para filtrar por estado y posible modificación del estado-->
                <form action="SvFiltrado" method="GET">
                    <div class="form-group">
                        <label for="estadoTramite">Filtrar por Estado:</label>
                        <select class="form-control" id="estadoTramite" name="estadoTramite">
                            <option value="True">Ya atendido</option>
                            <option value="False">En espera</option>
                        </select>
                    </div>
                    <input type="hidden" name="fechaConsulta" value="<%= request.getParameter("fechaConsulta")%>" />
                    <button type="submit" class="btn btn-primary">Filtrar por Fecha y Estado</button>
                </form>
                     <div class="card mb-3"> 
                    <div class="card-body">
                        <div class="results-table">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                    <tr>
                                        <th>Número de Turno</th>
                                        <th>Fecha</th>
                                        <th>Descripción del Trámite</th>
                                        <th>Estado del Trámite</th>
                                        <th>ID Ciudadano Asignado</th>
                                    </tr>
                                </thead>
                                <tbody>                            
                                    <% for (Turno turno : turnosFiltrados) {%>
                                    <tr>
                                        <td><%= turno.getId()%></td>
                                        <td><%= turno.getFecha()%></td>
                                        <td><%= turno.getTramite()%></td>
                                        <td><%= turno.getEstado() ? "Ya atendido" : "En espera"%></td>
                                        <td><%= turno.getUnCiudadano().getId()%></td>
                                        <td>
                                            <% if (!"Ya atendido".equals(turno.getEstado())) {%>
                                            <form action="SvCambiarEstado" method="post">
                                                <input type="hidden" name="id" value="<%= turno.getId()%>">
                                                <button type="submit" class="btn btn-primary"><i class="fas fa-edit mr-2"></i>Modificar</button>
                                            </form>
                                            <% } %>
                                        </td>

                                    </tr>
                                    <% }%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

        </main>
        <footer class="py-4 bg-light mt-auto">
            <div class="container-fluid px-4">  
            </div>
        </footer>
    </div>
</div>
</html>
