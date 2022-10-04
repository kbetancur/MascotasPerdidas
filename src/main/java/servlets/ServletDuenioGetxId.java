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
 * Servlet implementation class ServletDuenioGetxId
 */

@WebServlet("/ServletDuenioGetxId")
public class ServletDuenioGetxId extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletDuenioGetxId() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        DuenioController duenioc = new DuenioController();    
        
        int id_duenio = Integer.parseInt(request.getParameter("id_duenio"));
         System.out.println("id_duenio en servlet" + id_duenio);
        String duenioStr = duenioc.obtenerDatosxId(id_duenio);    
        System.out.println("string" + duenioStr);
        response.setContentType("text/html;charset=UTF8");
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
