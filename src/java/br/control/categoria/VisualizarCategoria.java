package br.control.categoria;

import br.model.entity.Categoria;
import br.model.dao.Categoria_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VisualizarCategoria", urlPatterns = {"/VisualizarCategoria"})
public class VisualizarCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = new Categoria(id);
        Categoria_DAO cat_dao = new Categoria_DAO();
        try {
            cat_dao.get(categoria);
            request.setAttribute("categoria", categoria);
            request.setAttribute("motivo","visualizar");
            RequestDispatcher rd = request.getRequestDispatcher("categoria/FormCategoriaView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

}