package br.control.produto;

import br.model.dao.Categoria_DAO;
import br.model.entity.Produto;
import br.model.dao.Produto_DAO;
import br.model.entity.Categoria;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VisualizarProduto", urlPatterns = {"/VisualizarProduto"})
public class VisualizarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria_DAO categoria_dao = new Categoria_DAO();
        List<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("categorias",categorias);

        int id = Integer.parseInt(request.getParameter("id"));
        Produto prod = new Produto(id);
        Produto_DAO prod_dao = new Produto_DAO();
        try {
            prod_dao.get(prod);
            request.setAttribute("produto", prod);
            request.setAttribute("motivo", "visualizar");
// =============================== chama o form de vizializar o prod ======================================
            RequestDispatcher rd = request.getRequestDispatcher("produto/FormProdutoView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

}
