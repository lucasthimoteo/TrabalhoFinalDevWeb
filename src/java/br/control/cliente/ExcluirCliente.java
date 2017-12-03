package br.control.cliente;

import br.model.entity.Cliente;
import br.model.dao.Cliente_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCliente", urlPatterns = {"/ExcluirCliente"})
public class ExcluirCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);
        Cliente_DAO cliente_dao = new Cliente_DAO();
        try {
            cliente_dao.get(cliente);
            request.setAttribute("motivo", "excluir");
            request.setAttribute("cliente", cliente);

            RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
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
        Cliente contato = new Cliente(id);
        Cliente_DAO contato_dao = new Cliente_DAO();
        
        try {
            contato_dao.Excluir(contato);
            request.setAttribute("mensagem", "Exclusão Com Sucesso");
            request.setAttribute("retorna", "ListaClientes");
            RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }

    }
}
