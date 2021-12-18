<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="all">
            <jsp:include page="Header.jsp"/> 
            <div class="content">
                <div class="left">
                    <c:if test="${check==0}"><h1>${Error}</h1> </c:if>
                    <c:if test="${detail!= null&& check==1}">
                        <div class="title">
                            ${detail.title}
                        </div>
                        <img src=${detail.img} alt=""/>
                        <div class="description">
                            ${detail.description}
                        </div>
                        <div class="author">
                            <div class="comment"></div> 
                            <div class="timeicon"></div>
                            By ${detail.author} | ${detail.date}
                        </div> 
                    </c:if>

                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/> 
        </div>
    </body>
</html>
