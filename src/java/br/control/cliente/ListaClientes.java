package br.control.cliente;

import br.model.entity.Cliente;
import br.model.dao.Cliente_DAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaClientes", urlPatterns = {"/ListaClientes"})
public class ListaClientes extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cliente_DAO cliente_dao = new Cliente_DAO();
        ArrayList<Cliente> clientes = cliente_dao.Listar();
        request.setAttribute("clientes", clientes);
        RequestDispatcher rd = request.getRequestDispatcher("cliente/ListaClientesView.jsp");
        rd.forward(request, response);
    }
}
