<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/search.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="all">
            <jsp:include page="Header.jsp"/> 
            <div class="content">
                <div class="left">
                    <c:forEach items="${listS}" var="o">
                        <div class="QNews">
                            <div class="title">
                                ${o.title}
                            </div>
                            <img src="${top1.img}" alt=""/>
                            <div class="sDes">
                                ${o.shortDescription}
                            </div>
                        </div>
                    </c:forEach>
                    <div class="paging">
                        <!--check pageS if >=1 display paging-->
                        <c:if test="${pageS>=1}">
                            <c:forEach begin="1" end="${pageS}" var="i">
                                <a class="${pageN==i?"active":""}" href="search?pageN=${i}&txtSearch=${textSearch}">${i}</a>
                            </c:forEach>
                        </c:if >
                        <!--check pageS if pageS < pageN display Not Found-->
                        <c:if test="${pageS<pageN}">
                            <h2>Not Found</h2>
                        </c:if>
                        <!--check = false display Error-->    
                        <c:if test="${check==false}"><h1>${Error}</h1> </c:if>

                        </div>
                    </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/> 
        </div>
    </body>
</html>
