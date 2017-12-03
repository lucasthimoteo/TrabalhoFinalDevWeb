package br.control.categoria;

import br.control.produto.*;
import br.model.entity.Categoria;
import br.model.entity.Produto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

final class HelperCategoria {
     static boolean valida(Categoria categoria, List<String> erros) {
        boolean flag = true;
        if (categoria.getDesc().isEmpty()) {
            erros.add("Descrição vazia");
            flag= false;
        }

        
        return flag;
    }
    
    static Categoria parse(HttpServletRequest request){
        
            String descricao = request.getParameter("descricao");
            
            Categoria categoria = new Categoria(descricao);
            
            return categoria;
    }
}
