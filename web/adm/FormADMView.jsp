<%@page import="br.model.entity.Administrador"%>
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
            document.getElementById("loggin").value = "admin";
            document.getElementById("nome").value = "Leandro";
            document.getElementById("senha").value = "123456";
        }
    </script>
    <body class="formBody">
        <jsp:include page="../includes/Acesso.jsp" />
        <div class="topDiv">
            <h1 class="title">Administrador</h1>
        </div>
        <%

            Administrador adm = new Administrador();
            String readonly = "";
            String id_type = "hidden";
            String disabled = "";
            String action = "IncluirADM";
            String method = "POST";
            String button_value = "Salvar";

            if (request.getAttribute("motivo") != null) {
                adm = (Administrador) request.getAttribute("adm");

                String motivo = (String) request.getAttribute("motivo");
                if (motivo.equals("visualizar")) {
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ListaADM";
                    method = "GET";
                    button_value = "Voltar";
                }
                if (motivo.equals("editar")) {
                    readonly = "";
                    id_type = "text";
                    action = "EditarADM";
                }
                if (motivo.equals("incluir")) {
                    if (request.getAttribute("adm") == null) {
                        adm = new Administrador();
                    }
                }
                if (motivo.equals("excluir")) {
                    readonly = "readonly";
                    id_type = "text";
                    disabled = "disabled";
                    action = "ExcluirADM";
                    method = "POST";
                    button_value = "Excluir";
                }
            }%>
        <div class="contentDiv">
            <form class="form" action="<%=action%>" method="<%=method%>">
                <label class="formLbl" <%=id_type%>>ID:</label>   
                <input class="formInpt" type="<%=id_type%>" id="id" name="id" value="<%=adm.getId()%>" readonly>
                <br><br>
                <label class="formLbl">Loggin:</label>
                <input class="formInpt" type="text" id="loggin" name="loggin" value="<%=adm.getLoggin()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Nome:</label>
                <input class="formInpt" type="text" id="nome" name="nome" value="<%=adm.getNome()%>" <%=readonly%>>
                <br><br>
                <label class="formLbl">Senha:</label>
                <input class="formInpt" type="password" id="senha" name="senha" value="<%=adm.getSenha()%>" <%=readonly%>>
                <br><br>
                <input type="submit" value="<%=button_value%>">
            </form>
            <form action="ListaADM" method="GET">
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
