<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/right.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="right">
            <div class="title">
                Digital new
            </div>
            <div class="shortDes">
                ${top1.shortDescription}
            </div>
            <div class="title">
                Search
            </div>
            <form action="search" method="post">
                <input class="searchBox" value="${textSearch}" type="text" name="txtSearch">
                <button type="submit">GO</button>
            </form>
            <div class="title">
                Last Articles
            </div>
            <div class="arctile">
                <c:forEach items="${top5}" var="o">
                    <a href="detail?did=${o.id}">${o.title}</a> <br><br>
                </c:forEach>
            </div>
        </div>
    </body>
</html>