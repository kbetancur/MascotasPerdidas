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
 * Servlet implementation class ServletVerPublicaciones
 */

@WebServlet("/ServletVerPublicaciones")
public class ServletVerPublicaciones extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletVerPublicaciones() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        PublicacionController publicacion = new PublicacionController();
        String publicacionStr = publicacion.listarp();  
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
