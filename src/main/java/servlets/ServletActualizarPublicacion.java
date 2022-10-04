package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.PublicacionController;
import java.sql.Date;

/**
 * Servlet implementation class ServletActualizarPublicacion
 */
@WebServlet("/ServletActualizarPublicacion")
public class ServletActualizarPublicacion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarPublicacion() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        PublicacionController publicacionc = new PublicacionController();
        
        int id_publicacion = Integer.parseInt(request.getParameter("id_publicacion"));        
        int id_mascota = Integer.parseInt(request.getParameter("id_mascota")); 
        Date fecha_publicacion = Date.valueOf(request.getParameter("fecha_publicacion"));
        Date fecha_perdida = Date.valueOf(request.getParameter("fecha_perdida")); 
        String descripcion = request.getParameter("descripcion");
            
        String result = publicacionc.actualizarPublicacion(id_publicacion, id_mascota, fecha_publicacion, fecha_perdida, descripcion);

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
