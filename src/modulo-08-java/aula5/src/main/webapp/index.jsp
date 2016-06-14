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
        <h1>Mini-Cadastro</h1>
        <form class="form-horizontal" action="pessoa" method="get">
            <div class="form-group">
                <label for="nome" class="col-sm-2 control-label">Nome</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="pessoa.nome">
                </div>
            </div>
            <div class="form-group">
                <label for="idade" class="col-sm-2 control-label">Idade</label>
                <div class="col-sm-10">
                    <input type="number" name ="idade" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <label class="radio-inline"><input type="radio" name="sexo" value="Feminino">F</label>
                    <label class="radio-inline"><input type="radio" name="sexo" value="Masculino">M</label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Enviar</button>
                </div>
            </div>
        </form>
        
        
        
    </body>
</html>
