<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD em servlet - Erro</title>
    </head>
    <body>
        <jsp:include page="includes/Acesso.jsp" />

        <h1>Erro! Não Foi possível processar a solicitação</h1>
        <%=request.getAttribute("mensagem")%>

        <jsp:include page="includes/Footer.jsp" />

    </body>
</html>
