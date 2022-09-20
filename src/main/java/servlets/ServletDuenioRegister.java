package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DuenioController;

/**
 * Servlet implementation class ServletDuenioRegister
 */
@WebServlet("/ServletDuenioRegister")
public class ServletDuenioRegister extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDuenioRegister() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        DuenioController duenioc = new DuenioController();
        
        String correo_electronico = request.getParameter("correo_electronico");
        String contrasena = request.getParameter("contrasena");
        String tipo_identificacion = request.getParameter("tipo_identificacion");
        String identificacion = request.getParameter("identificacion");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String ciudad = request.getParameter("ciudad");
        String barrio = request.getParameter("barrio");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        
        String result = duenioc.register(tipo_identificacion, identificacion, nombre, apellidos, correo_electronico, contrasena, ciudad, barrio, direccion, telefono);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.print(result);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    
    

}
