package servlets;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Ciudadano;
import logica.Controladora;

@WebServlet(name = "SvTurno", urlPatterns = {"/SvTurno"})
public class SvTurno extends HttpServlet {

    Controladora control = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obtener parámetros del formulario
        LocalDate fechaTurno = LocalDate.parse(request.getParameter("fechaTurno"));
        String descripcionTramite = request.getParameter("tramite");
        Boolean estadoTramite = Boolean.valueOf(request.getParameter("estadoTramite"));
        Long idCiudadanoAsignado = Long.valueOf(request.getParameter("ciudadanoAsignado"));

        
        Ciudadano ciudadanoAsignado = control.obtenerCiudadanoPorId(idCiudadanoAsignado);

        //Verificar si el ciudadano existe antes de crear el turno
        if (ciudadanoAsignado != null) {
            control.crearTurno(fechaTurno, descripcionTramite, estadoTramite, ciudadanoAsignado);
            response.sendRedirect("agregarTurno.jsp");
        } else {
            //El ciudadano no existe, redirigir al usuario a la página de inicio
            response.sendRedirect("indexError.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}