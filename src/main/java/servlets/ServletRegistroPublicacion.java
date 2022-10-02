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
import java.text.SimpleDateFormat;


@WebServlet("/ServletRegistroPublicacion")
public class ServletRegistroPublicacion extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistroPublicacion() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PublicacionController publicacion = new PublicacionController();
        int id_mascota = Integer.parseInt(request.getParameter("id_mascota"));
        
        Date fecha_publicacion = Date.valueOf(request.getParameter("fecha_publicacion"));
        Date fecha_perdida = Date.valueOf(request.getParameter("fecha_perdida"));       
        
        String descripcion = request.getParameter("descripcion");
        String comentarios = request.getParameter("comentarios");
       
        
        String result = publicacion.registrop(id_mascota, fecha_publicacion, fecha_perdida, descripcion, comentarios);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
