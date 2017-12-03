package br.control.categoria;

import br.model.entity.Categoria;
import br.model.dao.Categoria_DAO;
import br.model.dao.Produto_DAO;
import br.model.entity.Produto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCategoria", urlPatterns = {"/ExcluirCategoria"})
public class ExcluirCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = new Categoria(id);
        Categoria_DAO categoria_dao = new Categoria_DAO();
        try {

            categoria_dao.get(categoria);
            request.setAttribute("motivo", "excluir");
            request.setAttribute("categoria", categoria);
            RequestDispatcher rd = request.getRequestDispatcher("categoria/FormCategoriaView.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Categoria cat = new Categoria(id);

        Categoria_DAO cat_dao = new Categoria_DAO();
        try {
            cat_dao.Excluir(cat);
            request.setAttribute("mensagem", "Exclusão Com Sucesso");
            request.setAttribute("retorna", "ListaCategorias");
            RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }

    }
}
