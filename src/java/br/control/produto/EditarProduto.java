package br.control.produto;

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

@WebServlet(name = "EditarProduto", urlPatterns = {"/EditarProduto"})
public class EditarProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Categoria_DAO categoria_dao = new Categoria_DAO();
        List<Categoria> categorias = categoria_dao.Listar();
        request.setAttribute("categorias",categorias);

        int id = Integer.parseInt(request.getParameter("id"));
        Produto produto = new Produto(id);
        Produto_DAO produto_dao = new Produto_DAO();
        try {
            produto_dao.get(produto);
            request.setAttribute("produto", produto);
            request.setAttribute("motivo", "editar");
            RequestDispatcher rd = request.getRequestDispatcher("produto/FormProdutoView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Produto produto = HelperProduto.parse(request);
            produto.setId(Integer.parseInt(request.getParameter("id")));

            List<String> erros = new ArrayList<String>();

            if (!HelperProduto.valida(produto, erros)) {
                request.setAttribute("motivo", "editar");
                request.setAttribute("produto", produto);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
                rd.forward(request, response);
            } else {
                Produto_DAO produto_dao = new Produto_DAO();
                produto_dao.Alterar(produto);
                request.setAttribute("mensagem", "Ediçao Com Sucesso");
                request.setAttribute("retorna", "ListaProdutos");
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
