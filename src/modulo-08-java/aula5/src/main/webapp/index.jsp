<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    </head>
    <body>
        <h1>Hello World!</h1>
        <form class="form-horizontal" action="pessoa" method="get">
            <label for="nome">Nome</label>
            <input type="text" name="pessoa.nome">
            <label for="idade">Idade</label>
            <input type="number" name ="idade">
            <button class="btn btn-control">Enviar</button>
        </form>
    </body>
</html>
