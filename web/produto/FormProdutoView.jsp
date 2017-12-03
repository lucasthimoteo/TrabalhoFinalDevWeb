<%@page import="br.model.entity.Produto"%>
<%@page import="br.model.entity.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD em servlet</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <script>
        function teste() {
            document.getElementById("nome").value = "Geladeira";
            document.getElementById("idCat").value = "eletrodomestico";
            document.getElementById("descricao").value = "geladeira eletro lux";
            document.getElementById("valor").value = "2000";
        }
    </script>
    <body class="formBody">
        <jsp:include page="../includes/Acesso.jsp" />
        <div class="topDiv">
            <h1 class="title">Produto</h1>
        </div>
        <%

            List<Categoria> categorias = new ArrayList<Categoria>();
            if (request.getAttribute("categorias") != null) {
                categorias = (ArrayList<Categoria>) request.getAttribute("categorias");
            }
            Produto produto = new Produto();
            String readonly = "";
            String id_type = "hidden";
            String disabled = "";
            String action = "IncluirProduto";
            String method = "POST";
            String button_value = "Salvar";

            if (request.getAttribute("motivo") != null) {

                String motivo = (String) request.getAttribute("motivo");
                if (motivo.equals("visualizar")) {
                    produto = (Produto) request.getAttribute("produto");
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ListaProdutos";
                    method = "GET";
                    button_value = "Voltar";
                }
                if (motivo.equals("editar")) {
                    produto = (Produto) request.getAttribute("produto");
                    readonly = "";
                    id_type = "text";
                    action = "EditarProduto";
                }
                if (motivo.equals("incluir")) {
                    if (request.getAttribute("produto") != null) {
                        produto = (Produto) request.getAttribute("produto");
                    }
                }
                if (motivo.equals("excluir")) {
                    produto = (Produto) request.getAttribute("produto");
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ExcluirProduto";
                    method = "POST";
                    button_value = "Excluir";
                }
            }%>
        <div class="contentDiv">
            <form class="form" action="<%=action%>" method="<%=method%>">
                <label class="formLbl" <%=id_type%>>ID:</label>   
                <input class="formInpt" type="<%=id_type%>" id="id" name="id" value="<%=produto.getId()%>" readonly>
                <br><br>
                <label class="formLbl">Nome:</label>
                <input class="formInpt" type="text" id="nome" name="nome" value="<%=produto.getNome()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Categoria:</label>
                <select class="formInpt"  id="idCat" name="idCat" <%=disabled%>>
                    <%for (Categoria categoria : categorias) {%>
                    <option value="<%=categoria.getId()%>" <%if (produto.getIdcat() == categoria.getId()) {%>selected<%}%>><%=categoria.getDesc()%></option>
                    <%}%>
                </select>
                <br><br>
                <label class="formLbl">Descrição:</label>
                <input class="formInpt" type="text" id="descricao" name="descricao" value="<%=produto.getDesc()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Valor:</label>
                <input class="formInpt" type="text" id="valor" name="valor" value="<%=produto.getValor()%>" <%=readonly%>>
                <br><br>
                <input type="submit" value="<%=button_value%>">
            </form>
            <form action="ListaProdutos" method="GET">
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
