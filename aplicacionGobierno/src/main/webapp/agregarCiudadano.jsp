<%@page import="java.util.List"%>
<%@page import="logica.Controladora"%>
<%@page import="logica.Ciudadano"%>
<%@page contentType="text/html charset=UTF-8" pageEncoding="UTF-8"%>

<%
    // Obtener la lista de ciudadanos desde la base de datos
    Controladora controladora = new Controladora();
    List<Ciudadano> ciudadanos = controladora.obtenerListaCiudadanos();
%>

<!DOCTYPE html>
<html lang="es">
<%@include file="componentes/header.jsp"%>
        <div id="layoutSidenav_content">
            <main>
               
                <div class="container mt-4">
                    <h3>Dar de Alta a un Ciudadano</h3>
                    <form action="SvCiudadano" method="POST">
                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre:</label>
                            <input type="text" class="form-control" id="nombre" name="nombre" required>
                        </div>
                        <div class="mb-3">
                            <label for="apellido" class="form-label">Apellido:</label>
                            <input type="text" class="form-control" id="apellido" name="apellido" required>
                        </div> 
                        <button type="submit" class="btn btn-primary">Dar de Alta</button>
                    </form>
                    </div>
                <div class="container-fluid">
                    <h1 class="mt-4">Ver Ciudadanos</h1>
                    <div class="card mb-4">
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Nombre</th>
                                            <th>Apellido</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <% for (Ciudadano ciudadano : ciudadanos) { %>
                                            <tr>
                                                <td><%= ciudadano.getId() %></td>
                                                <td><%= ciudadano.getNombre() %></td>
                                                <td><%= ciudadano.getApellido() %></td>
                                            </tr>
                                        <% } %>
                                    </tbody>
                                </table>
                            </div>
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
</body>
</html>