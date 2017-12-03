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

        <h1>Lista de Categorias</h1>

        <a href="IncluirCategoria">Incluir Categoria</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Descriçao</th>

        </thead>
        <%
            List<Categoria> categorias = (ArrayList) request.getAttribute("categorias");
            for (Categoria categoria : categorias) {

        %>
        <tr>
            <td><%=categoria.getId()%></td>
            <td><%=categoria.getDesc()%></td> 
            <td><a href="VisualizarCategoria?id=<%=categoria.getId()%>">Visualizar</a> | <a href="EditarCategoria?id=<%=categoria.getId()%>">Editar</a> | <a href="ExcluirCategoria?id=<%=categoria.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
    <jsp:include page="../includes/Footer.jsp" />
</body>
</html>

