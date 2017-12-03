package br.control.categoria;

import br.control.produto.*;
import br.control.cliente.*;
import br.model.dao.Categoria_DAO;
import br.model.entity.Cliente;
import br.model.dao.Cliente_DAO;
import br.model.dao.Produto_DAO;
import br.model.entity.Categoria;
import br.model.entity.Produto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarCategoria", urlPatterns = {"/EditarCategoria"})
public class EditarCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        Categoria categoria = new Categoria(id);
        Categoria_DAO categoria_dao = new Categoria_DAO();
        try {
            categoria_dao.get(categoria);
            request.setAttribute("categoria", categoria);
            request.setAttribute("motivo", "editar");
            RequestDispatcher rd = request.getRequestDispatcher("categoria/FormCategoriaView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Categoria categoria = HelperCategoria.parse(request);
            categoria.setId(Integer.parseInt(request.getParameter("id")));

            List<String> erros = new ArrayList<String>();

            if (!HelperCategoria.valida(categoria, erros)) {
                request.setAttribute("motivo", "editar");
                request.setAttribute("categoria", categoria);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("categoria/FormCategoriaView.jsp");
                rd.forward(request, response);
            } else {
                Categoria_DAO categoria_dao = new Categoria_DAO();
                categoria_dao.Alterar(categoria);
                request.setAttribute("mensagem", "Ediçao Com Sucesso");
                request.setAttribute("retorna", "ListaCategorias");
                RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }
}
