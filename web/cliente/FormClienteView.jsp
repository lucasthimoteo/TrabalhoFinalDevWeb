<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.model.entity.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css"
    </head>
    <script>
        function teste() {
            document.getElementById("nome").value = "Lucas Thimotoeo";
            document.getElementById("idade").value = "23";
            document.getElementById("endereco").value = "Rua Pedro Gomes";
            document.getElementById("bairro").value = "Realengo";
            document.getElementById("cidade").value = "Rio de Janeiro";
            document.getElementById("estado").value = "RJ";
            document.getElementById("referencia").value = "perto do bombeiro";
            document.getElementById("cpf").value = "14845272750";
            document.getElementById("rg").value = "28277273 ";
            document.getElementById("sexo").value = "M";
            document.getElementById("estado_civil").value = "S";
            document.getElementById("email").value = "luca.lic@hotmail.it";
            document.getElementById("telefone").value = "2134629529";
            document.getElementById("celular").value = "21997336525";
            document.getElementById("numero_cartao").value = "5323";
            document.getElementById("bandeira_cartao").value = "M";
            document.getElementById("loggin").value = "luca.lic";
            document.getElementById("senha").value = "123";
        }
    </script>
    <body class="formBody">
        <jsp:include page="../includes/Acesso.jsp" />
        <div class="topDiv">
            <h1 class="title">Cliente</h1>
        </div>
        <%
            String[] estados = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
            Cliente cliente = new Cliente();
            String readonly = "";
            String id_type = "hidden";
            String disabled = "";
            String action = "IncluirCliente";
            String method = "POST";
            String button_value = "Salvar";

            if (request.getAttribute("motivo") != null) {

                String motivo = (String) request.getAttribute("motivo");
                if (motivo.equals("visualizar")) {
                    cliente = (Cliente) request.getAttribute("cliente");
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ListaClientes";
                    method = "GET";
                    button_value = "Voltar";
                }
                if (motivo.equals("editar")) {
                    cliente = (Cliente) request.getAttribute("cliente");
                    readonly = "";
                    id_type = "text";
                    action = "EditarCliente";
                }
                if (motivo.equals("incluir")) {
                    if (request.getAttribute("cliente") != null) {
                        cliente = (Cliente) request.getAttribute("cliente");
                    }
                }
                if (motivo.equals("excluir")) {
                    cliente = (Cliente) request.getAttribute("cliente");
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ExcluirCliente";
                    method = "POST";
                    button_value = "Excluir";
                }
            }%>
        <div class="contentDiv">
            <form class="form" action="<%=action%>" method="<%=method%>">
                <label class="formLbl" <%=id_type%>>ID:</label>   
                <input class="formInpt" type="<%=id_type%>" id="id" name="id" value="<%=cliente.getId()%>" readonly>
                <br><br>
                <label class="formLbl">Nome Completo:</label>
                <input class="formInpt" type="text" id="nome" name="nome" value="<%=cliente.getNome()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Idade:</label>
                <input class="formInpt" type="text" id="idade" name="idade" value="<%=cliente.getIdade()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Endereço:</label>
                <input class="formInpt" type="text" id="endereco" name="endereco" value="<%=cliente.getEndereco()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Bairro:</label>
                <input class="formInpt" type="text" id="bairro" name="bairro" value="<%=cliente.getBairro()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Cidade:</label>
                <input class="formInpt" type="text" id="cidade" name="cidade" value="<%=cliente.getCidade()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Estado:</label>
                <select class="formInpt"  id="estado" name="estado" <%=disabled%>>
                    <%for (int i = 0; i < estados.length; i++) {%>
                    <option value="<%=estados[i]%>" <%if (cliente.getEstado().equals(estados[i])) {%>selected<%}%>><%=estados[i]%></option>
                    <%}%>
                </select>
                <br><br>
                <label class="formLbl">Referênica:</label>
                <input class="formInpt" type="text" id="referencia" name="referencia" value="<%=cliente.getReferencia()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">CPF:</label>
                <input class="formInpt" type="text" id="cpf" name="cpf" value="<%=cliente.getCpf()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">RG:</label>
                <input class="formInpt" type="text" id="rg" name="rg" value="<%=cliente.getRg()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Sexo:</label>
                <select class="formInpt" id="sexo" name="sexo" <%=disabled%>>
                    <option value="M"<%if (cliente.getSexo().equals("M")) {%>selected<%}%>>Masculino</option>
                    <option value="F"<%if (cliente.getSexo().equals("F")) {%>selected<%}%>>Feminino</option>
                </select>
                <br><br>
                <label class="formLbl">Estado Civil:</label>
                <select class="formInpt" id="estado_civil" name="estado_civil" <%=disabled%>>
                    <option value="S"<%if (cliente.getEstado_civil().equals("S")) {%>selected<%}%>>Solteiro</option>
                    <option value="C"<%if (cliente.getEstado_civil().equals("C")) {%>selected<%}%>>Casado</option>
                </select>
                <br><br>
                <label class="formLbl">E-mail:</label>
                <input class="formInpt" type="email" id="email" name="email" value="<%=cliente.getEmail()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Telefone fixo:</label>
                <input class="formInpt" type="text" id="telefone" name="telefone" value="<%=cliente.getTelefone()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Celular:</label>
                <input class="formInpt" type="text" id="celular" name="celular" value="<%=cliente.getCelular()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Numero Cartao de Crédito:</label>
                <input class="formInpt" type="text" id="numero_cartao" name="numero_cartao" value="<%=cliente.getNumero_cartao()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Bandeira:</label>
                <select class="formInpt" id="bandeira_cartao" name="bandeira_cartao" <%=disabled%>>
                    <option value="V"<%if (cliente.getBandeira_cartao().equals("V")) {%>selected<%}%>>Visa</option>
                    <option value="M"<%if (cliente.getBandeira_cartao().equals("M")) {%>selected<%}%>>Mastercard</option>
                </select>
                <br><br>
                <label class="formLbl">Loggin</label>
                <input class="formInpt" type="text" id="loggin" name="loggin" value="<%=cliente.getLoggin()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Senha:</label>
                <input class="formInpt" type="password" id="senha" name="senha" value="" <%=readonly%>>
                <br><br>
                <label class="formLbl">Confirma Senha</label>
                <input class="formInpt" type="password" id="confirma_senha" name="confirma_senha" value="" <%=readonly%>>
                <br><br>
                <input type="submit" value="<%=button_value%>">
            </form>
            <form action="ListaClientes" method="GET">
                <input type="submit" value="Voltar">
            </form>
            <button onclick="teste()">Valores Teste</button>
            <br>
            <%if (request.getAttribute("erros") != null) {
                        List<String> erros = (ArrayList<String>) request.getAttribute("erros");
                        for (String erro : erros) {%>
            <font color="red"> ERRO: <%=erro.toUpperCase()%> </font><br>
            <%}
                }%>

            <jsp:include page="../includes/Footer.jsp" />
        </div>
    </body>
</html>
