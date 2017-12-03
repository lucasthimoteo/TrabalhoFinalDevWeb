
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>Acesso Restrito</title>
    </head>
    <body>
        <jsp:include page="includes/Acesso.jsp" />
        <div class="contentDiv">
            <a href="ListaClientes">Lista de Clientes</a>  ||  <a href="ListaProdutos">Lista de Produtos</a>  ||  <a href="ListaCategorias">Lista de Categorias</a> ||  <a href="ListaADM">Lista de Administradores</a>
        </div>
        <jsp:include page="includes/Footer.jsp" />
    </body>
</html>
