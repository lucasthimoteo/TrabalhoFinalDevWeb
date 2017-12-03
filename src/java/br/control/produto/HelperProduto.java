package br.control.produto;

import br.model.entity.Produto;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

final class HelperProduto {
     static boolean valida(Produto produto, List<String> erros) {
        boolean flag = true;
        if (produto.getNome().isEmpty()) {
            erros.add("nome vazio");
            flag= false;
        }

        
        return flag;
    }
    
    static Produto parse(HttpServletRequest request){
            String nome = request.getParameter("nome");
            int idCat = Integer.parseInt(request.getParameter("idCat"));
            String descricao = request.getParameter("descricao");
            double valor = Double.parseDouble(request.getParameter("valor"));

            Produto produto = new Produto(nome,idCat,descricao,valor);
            
            return produto;
    }
}
