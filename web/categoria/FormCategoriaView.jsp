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
            document.getElementById("descricao").value = "Informatica";
        }
    </script>
    <body class="formBody">
        <jsp:include page="../includes/Acesso.jsp" />
        <div class="topDiv">
            <h1 class="title">Categoria</h1>
        </div>
        <%

            Categoria categoria = new Categoria();
            String readonly = "";
            String id_type = "hidden";
            String disabled = "";
            String action = "IncluirCategoria";
            String method = "POST";
            String button_value = "Salvar";

            if (request.getAttribute("motivo") != null) {
                categoria = (Categoria) request.getAttribute("categoria");

                String motivo = (String) request.getAttribute("motivo");
                if (motivo.equals("visualizar")) {
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ListaCategoria";
                    method = "GET";
                    button_value = "Voltar";
                }
                if (motivo.equals("editar")) {
                    readonly = "";
                    id_type = "text";
                    action = "EditarCategoria";
                }
                if (motivo.equals("incluir")) {
                    if (request.getAttribute("categoria") == null) {
                        categoria = new Categoria();
                    }
                }
                if (motivo.equals("excluir")) {
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ExcluirCategoria";
                    method = "POST";
                    button_value = "Excluir";
                }
            }%>
        <div class="contentDiv">
            <form class="form" action="<%=action%>" method="<%=method%>">
                <label class="formLbl" <%=id_type%>>ID:</label>   
                <input class="formInpt" type="<%=id_type%>" id="id" name="id" value="<%=categoria.getId()%>" readonly>
                <br><br>
                <label class="formLbl">Descrição:</label>
                <input class="formInpt" type="text" id="descricao" name="descricao" value="<%=categoria.getDesc()%>" <%=readonly%>>
                <br><br>
                <input type="submit" value="<%=button_value%>">
            </form>
            <form action="ListaCategorias" method="GET">
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

        </div>
    </body>
</html>
