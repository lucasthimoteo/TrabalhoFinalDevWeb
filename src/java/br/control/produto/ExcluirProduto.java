package br.control.produto;

import br.model.dao.Categoria_DAO;
import br.model.entity.Produto;
import br.model.dao.Produto_DAO;
import br.model.entity.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirProduto", urlPatterns = {"/ExcluirProduto"})
public class ExcluirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria_DAO categoria_dao = new Categoria_DAO();
        List<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("categorias", categorias);
        
        int id = Integer.parseInt(request.getParameter("id"));
        Produto prod = new Produto(id);
        Produto_DAO prod_dao = new Produto_DAO();
        try {

            prod_dao.get(prod);
            request.setAttribute("motivo", "excluir");
            request.setAttribute("produto", prod);
            RequestDispatcher rd = request.getRequestDispatcher("produto/FormProdutoView.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Produto prod = new Produto(id);
        Produto_DAO prod_dao = new Produto_DAO();
        try {
            prod_dao.Excluir(prod);
            request.setAttribute("mensagem", "Exclusão Com Sucesso");
            request.setAttribute("retorna", "ListaProdutos");
            RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("mensagem", "Impossivel deletar essa categoria. Ela esta sendo usada por algum produto");
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }

    }
}
