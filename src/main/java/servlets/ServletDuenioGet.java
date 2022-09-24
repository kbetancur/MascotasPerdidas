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
 * Servlet implementation class ServletDuenioGet
 */

@WebServlet("/ServletDuenioGet")
public class ServletDuenioGet extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletDuenioGet() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        DuenioController duenioc = new DuenioController();        
        String correo_electronico = request.getParameter("correo_electronico");
        String duenioStr = duenioc.obtenerDatos(correo_electronico);        
        
        PrintWriter out = response.getWriter();
        out.print(duenioStr);
        out.flush();
        out.close();
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doGet(request, response);
    }
    
    
}
