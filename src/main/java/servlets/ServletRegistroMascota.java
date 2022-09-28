package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.MascotaController;


@WebServlet("/ServletRegistroMascota")
public class ServletRegistroMascota extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistroMascota() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MascotaController mascota = new MascotaController();
        int id_duenio = Integer.parseInt(request.getParameter("id_duenio"));
        String nombre = request.getParameter("nombre");
        String especie = request.getParameter("especie");
        String raza = request.getParameter("raza");
        int anio_nacimiento = Integer.parseInt(request.getParameter("anio_nacimiento"));
        String color = request.getParameter("color");
        String estado = request.getParameter("estado");
        
        String result = mascota.registrom(id_duenio, nombre, especie, raza, anio_nacimiento, color, estado);
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
