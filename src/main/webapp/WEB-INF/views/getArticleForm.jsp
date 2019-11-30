<%-- 
    Document   : getArticleForm
    Created on : 23-nov-2019, 18:05:56
    Author     : Mari
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- Latest compiled and minified CSS -->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <spring:url value="/resources" var="urlPublic"/>
        <title>JSP Page</title>
    </head>
    <body

        <nav>
            <a class="navbar-brand" href="#">
                <img class="img-responsive" src="${urlPublic}/img/logo.png" alt="logo">
            </a>
                 <ul class="nav nav-pills">
                         <li role="presentation" class="active">
                                 <a href="<spring:url value= '/'/>">
                                        Inici
                                     </a>
                             </li>
                         <li role="Presentation" class="">
                                 <a href="<spring:url value= '/'/>"  class="btn btndanger btn-mini pull-right">desconnectar</a>
                             </li>                        
                     </ul>    
        </nav>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1  class="text-primary">${banner}</h1>
                    <h3>${tagline}</h3>
                </div>
            </div>
        </section>

        <section class="container">
            <div class="row">
                <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                    <form action="/dawm07eac3Treemark/get" method="post">
                        <p>Codi :
                            <input type="text" name="codi">
                        </p> 
                        <div class="col-sm-6 col-md-3" style="padding-bottom: 15px"></div>
                        <input type="submit" value="Enviar">
                    </form>
                </div> 
            </div>
        </section>
    </body>
</html>
