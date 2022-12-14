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
 * Servlet implementation class ServletVerMisPublicaciones
 */

@WebServlet("/ServletVerMisPublicaciones")
public class ServletVerMisPublicaciones extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletVerMisPublicaciones() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        PublicacionController publicacionc = new PublicacionController();
        int id_duenio = Integer.parseInt(request.getParameter("id_duenio"));
        String PublicacionStr = publicacionc.vermisPublicaciones(id_duenio);  
        response.setContentType("text/html;charset=UTF8");        
        PrintWriter out = response.getWriter();
        out.print(PublicacionStr);
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
