package br.control.cliente;

import br.model.entity.Cliente;
import br.model.dao.Cliente_DAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarCliente", urlPatterns = {"/EditarCliente"})
public class EditarCliente extends HttpServlet {
// ==================================  estra aqui depois de ter listado os clientes logo ja possui o id dele ========================

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);
        Cliente_DAO contato_dao = new Cliente_DAO();
        try {
            contato_dao.get(cliente);
            request.setAttribute("cliente", cliente);
            request.setAttribute("motivo", "editar");
            RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Cliente cliente = HelperCliente.parse(request);
            cliente.setId(Integer.parseInt(request.getParameter("id")));

            List<String> erros = new ArrayList<String>();

            if (!HelperCliente.valida(cliente, erros)) {
                request.setAttribute("motivo", "editar");
                request.setAttribute("cliente", cliente);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
                rd.forward(request, response);
            } else {
                Cliente_DAO cliente_dao = new Cliente_DAO();
                cliente_dao.Alterar(cliente);
                request.setAttribute("mensagem", "Ediçao Com Sucesso");
                request.setAttribute("retorna", "ListaClientes");
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
