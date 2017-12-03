package br.control.adm;

import br.model.entity.Administrador;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

final class HelperADM {
     static boolean valida(Administrador adm, List<String> erros) {
        boolean flag = true;
        if (adm.getLoggin().isEmpty()) {
            erros.add("Loggin vazio");
            flag= false;
        }

        
        return flag;
    }
    
    static Administrador parse(HttpServletRequest request){
        
            String loggin = request.getParameter("loggin");
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            
            Administrador adm = new Administrador(loggin, nome, senha);
            
            return adm;
    }
}
