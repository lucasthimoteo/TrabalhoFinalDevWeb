package br.control.categoria;

import br.model.entity.Categoria;
import br.model.dao.Categoria_DAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirCategoria", urlPatterns = {"/IncluirCategoria"})
public class IncluirCategoria extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("motivo", "incluir");
        RequestDispatcher rd = request.getRequestDispatcher("categoria/FormCategoriaView.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            
            Categoria categoria = HelperCategoria.parse(request);
            
            List<String> erros = new ArrayList<String>();

            if (!HelperCategoria.valida(categoria, erros)) {
                request.setAttribute("motivo", "incluir");
                request.setAttribute("categoria", categoria);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("categorias/FormCategoriasView.jsp");
                rd.forward(request, response);
            } else {
                Categoria_DAO categoria_dao = new Categoria_DAO();
                categoria_dao.Inserir(categoria);
                request.setAttribute("mensagem", "Inclusão Com Sucesso");
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