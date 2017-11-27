<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Add Novo Album</title>
        <link rel="stylesheet" href="css/style.css">
       	<link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-responsive.css"/>
    </head>
    <body>
        <div class="container espaco">
            <div class="offset3 span6 offset3">
                <form class="form-signin" role="form" method="POST" action='AlbumController' name="frmAddAlbum">
                    <h2 class="form-signin-heading">Insira seus dados</h2>

                    <input
                        type="hidden" name="id"  class="form-control"
                        value="<c:out value="${album.id}" />" /> 

                    Estilo : <input type="text"  placeholder="Rock, Pop, Sertanejo" class="form-control" name="estilo"
                                    value="<c:out value="${album.estilo}" />" /> <br /> 
                    Banda : <input
                        type="text" name="nomeBanda" readonly="readonly" class="form-control"
                        value="<c:out value="${banda}" />" /> <br /> 
                            <input
                        type="hidden" name="banda" class="form-control"
                        value="<c:out value="${idBanda}" />" />
                    Ano de Lancamento : <input
                        type="text" name="anoDeLancamento"  class="form-control"
                        value="<c:out value="${album.anoDeLancamento}" />" /> <br /> 

                    <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
                </form>

            </div>
        </div>
    </body>
</html>