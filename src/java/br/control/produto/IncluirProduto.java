package br.control.produto;

import br.model.dao.Categoria_DAO;
import br.model.entity.Produto;
import br.model.dao.Produto_DAO;
import br.model.entity.Categoria;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirProduto", urlPatterns = {"/IncluirProduto"})
public class IncluirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria_DAO categoria_dao = new Categoria_DAO();
        List<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("categorias",categorias);
        
        request.setAttribute("motivo", "incluir");
        RequestDispatcher rd = request.getRequestDispatcher("produto/FormProdutoView.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            Produto produto = HelperProduto.parse(request);
            
            List<String> erros = new ArrayList<String>();

            if (!HelperProduto.valida(produto, erros)) {
                request.setAttribute("motivo", "incluir");
                request.setAttribute("produto", produto);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("produto/FormProdutoView.jsp");
                rd.forward(request, response);
            } else {
                Produto_DAO produto_dao = new Produto_DAO();
                produto_dao.Inserir(produto);
                request.setAttribute("mensagem", "Inclusão Com Sucesso");
                request.setAttribute("retorna", "ListaProdutos");
                RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("mensagem", e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

}
