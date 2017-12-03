package br.control.categoria;

import br.model.entity.Categoria;
import br.model.dao.Categoria_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaCategorias", urlPatterns = {"/ListaCategorias"})
public class ListaCategorias extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Categoria_DAO categoria_dao = new Categoria_DAO();
        ArrayList<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("categorias", categorias);
        RequestDispatcher rd = request.getRequestDispatcher("categoria/ListaCategoriasView.jsp");
        rd.forward(request, response);

    }

}
