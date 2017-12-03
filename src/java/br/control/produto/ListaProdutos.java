package br.control.produto;

import br.model.entity.Produto;
import br.model.dao.Produto_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaProdutos", urlPatterns = {"/ListaProdutos"})
public class ListaProdutos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Produto_DAO prod_dao = new Produto_DAO();
        ArrayList<Produto> produtos = prod_dao.Listar();
        request.setAttribute("produtos", produtos);
        RequestDispatcher rd = request.getRequestDispatcher("produto/ListaProdutosView.jsp");
        rd.forward(request, response);

    }

}
