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
 * Servlet implementation class ServletDuenioListar
 */

@WebServlet("/ServletDuenioListar")
public class ServletDuenioListar extends HttpServlet {

        private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public ServletDuenioListar() {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        DuenioController duenioc = new DuenioController();        
        boolean ordenar = Boolean.parseBoolean(request.getParameter("ordenar"));
        String orden = request.getParameter("orden");
        String duenioStr = duenioc.listar(ordenar,orden);  
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
