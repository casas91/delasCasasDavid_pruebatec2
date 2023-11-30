package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import logica.Turno;

@WebServlet(name = "SvFiltrado", urlPatterns = {"/SvFiltrado"})
public class SvFiltrado extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //Obtener la fecha de consulta desde los parámetros del formulario
        String fechaConsultaStr = request.getParameter("fechaConsulta");

        if (fechaConsultaStr != null && !fechaConsultaStr.isEmpty()) {
            try {
                //Convertir la cadena de fecha a LocalDate
                LocalDate fechaConsulta = LocalDate.parse(fechaConsultaStr);

                //Obtener la lista filtrada de turnos
                List<Turno> turnosFiltrados = control.obtenerListaFiltradaFecha(fechaConsulta);

                //Establecer la lista filtrada como atributo de solicitud
                request.setAttribute("turnosFiltrados", turnosFiltrados);

                //Redirigir a la página JSP para mostrar los resultados
                RequestDispatcher dispatcher = request.getRequestDispatcher("filtradoTurnos.jsp");
                dispatcher.forward(request, response);

            } catch (DateTimeParseException e) {
                //Manejar error si la fecha no está en el formato esperado
                request.setAttribute("error", "Formato de fecha incorrecto");
                RequestDispatcher dispatcher = request.getRequestDispatcher("indexError.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            //Manejar el caso en el que no se proporciona fecha de consulta
            request.setAttribute("error", "Fecha de consulta no proporcionada");
            RequestDispatcher dispatcher = request.getRequestDispatcher("indexError.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        //Obtener parámetros de la solicitud
        String fechaConsultaStr = request.getParameter("fechaConsulta");
        String estadoTramiteStr = request.getParameter("estadoTramite");

        //Validar y convertir la fecha    
        if (fechaConsultaStr != null && !fechaConsultaStr.isEmpty()) {
            LocalDate fechaConsulta = LocalDate.parse(fechaConsultaStr);
            //Validar y convertir el estado del trámite

            if (estadoTramiteStr != null && !estadoTramiteStr.isEmpty()) {
                Boolean estadoTramite = Boolean.valueOf(estadoTramiteStr);

                //Filtrar la lista de turnos
                List<Turno> turnosFiltrados = control.obtenerListaFiltradaFechaEstado(fechaConsulta, estadoTramite);

                //Establecer la lista filtrada como atributo de solicitud
                request.setAttribute("turnosFiltrados", turnosFiltrados);

                //Redirigir a la página JSP para mostrar los resultados
                RequestDispatcher dispatcher = request.getRequestDispatcher("filtradoTurnos.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
