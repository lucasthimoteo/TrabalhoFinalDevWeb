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

@WebServlet(name = "IncluirCliente", urlPatterns = {"/IncluirCliente"})
public class IncluirCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("motivo", "incluir");
        RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            Cliente cliente = HelperCliente.parse(request);
            
            List<String> erros = new ArrayList<String>();

            if (!HelperCliente.valida(cliente, erros)) {
                request.setAttribute("motivo", "incluir");
                request.setAttribute("cliente", cliente);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("cliente/FormClienteView.jsp");
                rd.forward(request, response);
            } else {
                Cliente_DAO cliente_dao = new Cliente_DAO();
                cliente_dao.Inserir(cliente);
                request.setAttribute("mensagem", "Inclusão Com Sucesso");
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
