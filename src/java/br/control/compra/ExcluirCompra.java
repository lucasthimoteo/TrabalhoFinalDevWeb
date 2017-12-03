package br.control.compra;

import br.model.entity.Compras;
import br.model.dao.Compras_DAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCompra", urlPatterns = {"/ExcluirCompra"})
public class ExcluirCompra extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Compras comp = new Compras(id);
        Compras_DAO comp_dao = new Compras_DAO();
        try {
            comp_dao.get(comp);
            request.setAttribute("comp", comp);
//=========================== chamar o form de exclusão correto  =======================================================================
            RequestDispatcher rd = request.getRequestDispatcher("Form_Compras_Excluir.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Compras comp = new Compras(id);
        try {
                Compras_DAO compras_dao = new Compras_DAO();
                try {
                    compras_dao.Excluir(comp);
                    request.setAttribute("mensagem", "Exclusão Com Sucesso");
 // ================================= chama o metodo de Listar compras =================================================================================                   
                    request.setAttribute("retorna", "ListaCompras");
                    RequestDispatcher rd = request.getRequestDispatcher("Resposta.jsp");
                    rd.forward(request, response);
                } catch (Exception e) {
                    RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
                    rd.forward(request, response);
                }

            

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("Erro.jsp");
            rd.forward(request, response);
        }

    }
}
