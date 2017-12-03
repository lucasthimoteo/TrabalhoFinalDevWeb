package br.control.adm;

import br.model.dao.Administrador_DAO;
import br.model.entity.Administrador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarADM", urlPatterns = {"/EditarADM"})
public class EditarADM extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Administrador adm = new Administrador(id);
        Administrador_DAO adm_dao = new Administrador_DAO();
        try {
            adm_dao.get(adm);
            request.setAttribute("adm", adm);
            request.setAttribute("motivo", "editar");
            RequestDispatcher rd = request.getRequestDispatcher("adm/FormADMView.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Administrador adm = HelperADM.parse(request);
            adm.setId(Integer.parseInt(request.getParameter("id")));

            List<String> erros = new ArrayList<>();

            if (!HelperADM.valida(adm, erros)) {
                request.setAttribute("motivo", "editar");
                request.setAttribute("adm", adm);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("adm/FormADMView.jsp");
                rd.forward(request, response);
            } else {
                Administrador_DAO adm_dao = new Administrador_DAO();
                adm_dao.Alterar(adm);
                request.setAttribute("mensagem", "Ediçao Com Sucesso");
                request.setAttribute("retorna", "ListaADM");
                RequestDispatcher rd = request.getRequestDispatcher("RespostaView.jsp");
                rd.forward(request, response);
            }

        } catch (Exception e) {
            RequestDispatcher rd = request.getRequestDispatcher("ErroView.jsp");
            rd.forward(request, response);
        }
    }
}
