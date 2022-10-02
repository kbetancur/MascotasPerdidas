package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.MascotaController;

/**
 * Servlet implementation class ServletActualizarEstadoMascota
 */
@WebServlet("/ServletActualizarEstadoMascota")
public class ServletActualizarEstadoMascota extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletActualizarEstadoMascota() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        MascotaController mascotac = new MascotaController();
        int id_mascota = Integer.parseInt(request.getParameter("id_mascota"));
        String estado = request.getParameter("estado");
        String result = mascotac.actualizarEstado(id_mascota, estado);

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
