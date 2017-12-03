package br.control.adm;

import br.model.entity.Administrador;
import br.model.dao.Administrador_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VisualizarADM", urlPatterns = {"/VisualizarADM"})
public class VisualizarADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador adm = new Administrador(id);
        Administrador_DAO adm_dao = new Administrador_DAO();
        try {
            adm_dao.get(adm);
            request.setAttribute("adm", adm);
            request.setAttribute("motivo","visualizar");
            RequestDispatcher rd = request.getRequestDispatcher("adm/FormADMView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

}