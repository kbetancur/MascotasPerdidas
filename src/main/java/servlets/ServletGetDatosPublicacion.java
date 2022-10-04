package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.PublicacionController;

/**
 * Servlet implementation class ServletGetDatosPublicacion
 */

@WebServlet("/ServletGetDatosPublicacion")
public class ServletGetDatosPublicacion extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletGetDatosPublicacion() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        PublicacionController publicacionc = new PublicacionController();        
        int id_publicacion = Integer.parseInt(request.getParameter("id_publicacion"));
        String publicacionStr = publicacionc.obtenerDatosPublicacion(id_publicacion);  
        //System.out.println("string " + publicacionStr);
        response.setContentType("text/html;charset=UTF8");
        PrintWriter out = response.getWriter();
        out.print(publicacionStr);
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
