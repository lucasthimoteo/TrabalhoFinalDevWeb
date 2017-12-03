<%@page import="java.util.List"%>
<%@page import="br.model.entity.Cliente"%>
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

        <h1>Lista de Contatos</h1>

        <a href="IncluirCliente">Incluir Cliente</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Nome</th>
            <th>Idade</th>
            <th>Ações</th>
        </thead>
        <%
            List<Cliente> clientes = (ArrayList) request.getAttribute("clientes");
            for (Cliente cliente : clientes) {    
        %>
        <tr>
            <td><%=cliente.getId()%></td>
            <td><%=cliente.getNome()%></td> 
            <td><%=cliente.getIdade()%></td>
            <td><a href="VisualizarCliente?id=<%=cliente.getId()%>">Visualizar</a> | <a href="EditarCliente?id=<%=cliente.getId()%>">Editar</a> | <a href="ExcluirCliente?id=<%=cliente.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
    <jsp:include page="../includes/Footer.jsp" />
</body>
</html>

