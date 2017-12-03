<%@page import="br.model.entity.Administrador"%>
<%@page import="br.model.entity.Categoria"%>
<%@page import="br.model.dao.Categoria_DAO"%>
<%@page import="br.model.entity.Produto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>CRUD em servlet</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="stylesheet.css"
    </head>
    <body>
        <jsp:include page="../includes/Acesso.jsp" />

        <h1>Lista de ADM</h1>

        <a href="IncluirADM">Incluir Administrador</a>
        <p></p>
        <table>
            <thead>
            <th>Loggin</th>
            <th>Nome</th>

        </thead>
        <%
            List<Administrador> adms = (ArrayList) request.getAttribute("adms");
            for (Administrador adm : adms) {

        %>
        
            <td><%=adm.getLoggin()%></td>
            <td><%=adm.getNome()%></td> 
            <td><a href="VisualizarADM?id=<%=adm.getId()%>">Visualizar</a> | <a href="EditarADM?id=<%=adm.getId()%>">Editar</a> | <a href="ExcluirADM?id=<%=adm.getId()%>">Excluir</a></td>
        
        <%
            }
        %>

    </table>
    <jsp:include page="../includes/Footer.jsp" />
</body>
</html>

