
package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;


@WebServlet(name = "SvCambiarEstado", urlPatterns = {"/SvCambiarEstado"})
public class SvCambiarEstado extends HttpServlet {
    
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
        //Obtener el ID del turno de los parámetros de la solicitud
        Long id = Long.valueOf(request.getParameter("id"));

        //Cambiar el estado del turno a "Ya atendido"
        control.cambiarEstadoYaAtendido(id);
        
        // Redirigir de nuevo a la página principal de turnos
        response.sendRedirect("filtradoTurnos.jsp");
    }
    


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}