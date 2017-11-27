<%@ page language="java" contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="css/style.css">
       	<link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-responsive.css"/>
        <title>Todos os Albuns</title>
    </head>
    <body>
        <div class="container espaco">
            <div class="row">
                 <h2 class="form-signin-heading">Lista de Albuns</h2>
                <div class="offset3 span6 offset3 ">
                    <table class="table  table-hover table-bordered table-striped ">

                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Estilo</th>               
                                <th>Banda</th>
                                <th>Ano de Lançamento</th>

                                <th colspan=2>Ação</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${albuns}" var="album">
                                <tr>
                                    <td><c:out value="${album.id}" /></td>
                                    <td><c:out value="${album.estilo}" /></td>
                                    <td><c:out value="${album.nomeBanda}"/></td>
                                    <td><c:out value="${album.anoDeLancamento}"/></td>
                                    <td><a href="AlbumController?action=edit&id=<c:out value="${album.id}"/>">Update</a></td>
                                    <td><a href="AlbumController?action=delete&id=<c:out value="${album.id}"/>">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <p><a href="AlbumController?action=addBanda">Add Album</a></p>
                </div>
            </div>
        </div>
    </body>
</html>