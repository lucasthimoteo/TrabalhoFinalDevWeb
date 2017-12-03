package br.control.compra;

import br.model.entity.Compras;
import br.model.dao.Compras_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaCompras", urlPatterns = {"/ListaCompras"})
public class ListaCompras extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Compras_DAO comp_dao = new Compras_DAO();
        ArrayList<Compras> minhasCompras = comp_dao.Listar();
        request.setAttribute("minhasCompras", minhasCompras);
// ====================  chamar o lista compras view correto ======================================================        
        RequestDispatcher rd = request.getRequestDispatcher("ListaComprasView.jsp");
        rd.forward(request, response);

    }

}
