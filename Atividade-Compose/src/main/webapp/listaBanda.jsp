<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="css/style.css">
       	<link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-responsive.css"/>
        <title>Todas as Bandas</title>
    </head>
    <body>
        <div class="container espaco">
            <div class="row">
                 <h2 class="form-signin-heading">Escolha uma Banda Para seu Album</h2>
                <div class="offset3 span6 offset3 ">
                    <table class="table  table-hover table-bordered table-striped ">

                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nome</th>               
                                <th>Local de Origem</th>

                                <th colspan=2>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${bandas}" var="banda">
                                <tr>
                                    <td><c:out value="${banda.id}" /></td>
                                    <td><c:out value="${banda.nome}" /></td>
                                    <td><c:out value="${banda.localDeOrigem}"/></td>
                                    <td><a href="AlbumController?action=insert&idBanda=<c:out value="${banda.id}" />">Add</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>