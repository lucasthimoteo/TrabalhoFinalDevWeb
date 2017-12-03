package br.control.adm;

import br.model.entity.Administrador;
import br.model.dao.Administrador_DAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "IncluirADM", urlPatterns = {"/IncluirADM"})
public class IncluirADM extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("motivo", "incluir");
        RequestDispatcher rd = request.getRequestDispatcher("adm/FormADMView.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Administrador adm = HelperADM.parse(request);
            
            List<String> erros = new ArrayList<>();

            if (!HelperADM.valida(adm, erros)) {
                request.setAttribute("motivo", "incluir");
                request.setAttribute("adm", adm);
                request.setAttribute("erros", erros);
                RequestDispatcher rd = request.getRequestDispatcher("adm/FormADMView.jsp");
                rd.forward(request, response);
            } else {
                Administrador_DAO adm_dao = new Administrador_DAO();
                adm_dao.Inserir(adm);
                request.setAttribute("mensagem", "Inclusão Com Sucesso");
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