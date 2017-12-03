package br.control.cliente;

import br.model.entity.Cliente;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

final class HelperCliente {

    static boolean valida(Cliente cliente, List<String> erros) {
        boolean flag = true;
        if (cliente.getNome().isEmpty()) {
            erros.add("nome vazio");
            flag= false;
        }
        if (cliente.getIdade() < 18) {
            erros.add("idade menor que 18 anos");
            flag= false;
        }
        
        return flag;
    }
    
    static Cliente parse(HttpServletRequest request){
            String nome = request.getParameter("nome");
            int idade = Integer.parseInt(request.getParameter("idade"));
            String endereco = request.getParameter("endereco");
            String bairro = request.getParameter("bairro");
            String cidade = request.getParameter("cidade");
            String estado = request.getParameter("estado");
            String referencia = request.getParameter("referencia");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String sexo = request.getParameter("sexo");
            String estado_civil = request.getParameter("estado_civil");
            String email = request.getParameter("email");
            String telefone = request.getParameter("telefone");
            String celular = request.getParameter("celular");
            String numero_cartao = request.getParameter("numero_cartao");
            String bandeira_cartao = request.getParameter("bandeira_cartao");
            String loggin = request.getParameter("loggin");
            String senha = request.getParameter("senha");

            Cliente cliente = new Cliente(nome, idade, endereco, bairro, cidade, estado, referencia, cpf, rg, sexo, estado_civil, email, telefone, celular, numero_cartao, bandeira_cartao, loggin, senha);
            
            return cliente;
    }
}
