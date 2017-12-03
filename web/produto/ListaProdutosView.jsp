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

        <h1>Lista de Produtos</h1>

        <a href="IncluirProduto">Incluir Produto</a>
        <p></p>
        <table>
            <thead>
            <th>Id</th>
            <th>Categoria</th>
            <th>Nome</th>
            <th>Valor</th>
        </thead>
        <%
            List<Produto> produtos = (ArrayList) request.getAttribute("produtos");
            Categoria_DAO categoria_dao = new Categoria_DAO();
            Categoria categoria = new Categoria();
            for (Produto produto : produtos) {
                categoria.setId(produto.getIdcat());
                categoria = categoria_dao.get(categoria);
        %>
        <tr>
            <td><%=produto.getId()%></td>
            <td><%=categoria.getDesc()%></td> 
            <td><%=produto.getNome() %></td>
            <td><%=produto.getValor() %></td>
            <td><a href="VisualizarProduto?id=<%=produto.getId()%>">Visualizar</a> | <a href="EditarProduto?id=<%=produto.getId()%>">Editar</a> | <a href="ExcluirProduto?id=<%=produto.getId()%>">Excluir</a></td>
        </tr>
        <%
            }
        %>

    </table>
    <jsp:include page="../includes/Footer.jsp" />
</body>
</html>

