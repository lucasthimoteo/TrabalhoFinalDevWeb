package br.control.cliente;

import br.model.entity.Cliente;
import br.model.dao.Cliente_DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VisualizarCliente", urlPatterns = {"/VisualizarCliente"})
public class VisualizarCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Cliente cliente = new Cliente(id);
        Cliente_DAO contato_dao = new Cliente_DAO();
        try {
            contato_dao.get(cliente);
            request.setAttribute("cliente", cliente);
            request.setAttribute("motivo", "visualizar");
// =============================== chama o form de vizializar o cliente ======================================
            RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

}
