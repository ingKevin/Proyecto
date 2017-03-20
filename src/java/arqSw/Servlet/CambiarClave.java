package arqSw.Servlet;

import arqSw.DAO.AdministradorDAO;
import arqSw.DAO.ArtistaDAO;
import arqSw.DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "CambiarContraseña", urlPatterns = {"/CambiarContrase_a"})
public class CambiarClave extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);

        HttpSession session = request.getSession();
        String tipo = (String) session.getAttribute("type");
        String pass = request.getParameter("clave");
        int id = Integer.parseInt(session.getAttribute("id").toString());
        out.print(id);
        if (tipo.equals("Cliente")) {
            ClienteDAO cli = new ClienteDAO();
            //cli.updatePass(id, pass);
        } else if (tipo.equals("Artista")) {
            ArtistaDAO art = new ArtistaDAO();
            //art.updatePass(id, pass);
        } else if (tipo.equals("Administrador")) {
            AdministradorDAO art = new AdministradorDAO();
            art.updatePass(id, pass);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
