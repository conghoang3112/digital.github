<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <div class="title">
                        ${top1.title}
                    </div>
                    <img src="${top1.img}" alt=""/>
                    <div class="description">
                        ${top1.description}
                    </div>
                    <div class="author">
                        <div class="comment"></div> 
                        <div class="timeicon"></div> 
                        By ${top1.author} | ${top1.date}
                    </div>
                </div>
                <jsp:include page="Right.jsp"/> 
            </div>
            <jsp:include page="Footer.jsp"/> 
        </div>
    </body>
</html>
