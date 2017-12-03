package br.control.adm;

import br.model.entity.Administrador;
import br.model.dao.Administrador_DAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaADM", urlPatterns = {"/ListaADM"})
public class ListaADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Administrador_DAO adm_dao = new Administrador_DAO();
        ArrayList<Administrador> adms = adm_dao.Listar();
        request.setAttribute("adms", adms);
        RequestDispatcher rd = request.getRequestDispatcher("adm/ListaADMView.jsp");
        rd.forward(request, response);

    }

}
