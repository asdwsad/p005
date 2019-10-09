<%-- 
    Document   : home
    Created on : 01-10-2019, 19:01:05
    Author     : dattv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/home.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/overview.css" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <div class="container">

            <div class="header">
                <h1 class="title">Blogging About My Life</h1>
                <p class="subtitle">Welcome to my blog</p>
                <div class="menu">
                    <a id="menuMyBlog" class="link-banner" href="MyBlogController">My Blog</a>
                    <a id="menuAbout"class="link-banner" href="AboutMeController">About Me</a>
                </div>
            </div>



            <div class="content">
                <div class="block1">
                    <p class="content-header">Overview</p>

                    <% int i = 0;

                    %>
                    <c:forEach var="item" items="${list}">

                        <c:forEach var="month" items="${monthlist}">
                            <c:if test="${month.entryId==item.id}">
                                <% i++; %>
                                <div class="month">
                                    <div class="leftMonth">
                                        ${month.createdate}
                                    </div>
                                    <% if (i == 1) { %>
                                    <div class="rightMonth">
                                        <p>Date</p>
                                    </div>
                                    <% } else {%>
                                    <div class="rightMonth">

                                    </div>
                                    <%}%>
                                    <div class="clear"></div>
                                </div>

                            </c:if>
                        </c:forEach>


                        <div class="month">
                            <div class="leftside">
                                ${item.title}
                            </div>
                            <div class="rightside">
                                <p>

                                    <fmt:formatDate value="${item.createDate}" pattern="dd-MM-yyyy" />
                                </p>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </c:forEach>

                    <!--paging-->
                    <div class="overview">

                        <% int maxPage = (Integer) request.getAttribute("maxpage");
                            int pages = (Integer) request.getAttribute("page");

                            for (int j = 1; j <= maxPage; j++) {
                                if (pages == j) {%>

                        <%=j%> 
                        <%} else {%> 

                        <a class="page"  href="OverviewController?page=<%=j%>"><%=j%></a>
                        <%}
                            }%>


                    </div>

                </div>

                <div class="block2">
                    <div class="share">
                        <p class="share-title">Share this page</p>

                        <ul>
                            <li><a class="share-link" href="">Share on Facebook</a></li>
                            <li><a class="share-link" href="">Share on Twitter</a></li>
                            <li> <a class="share-link" href="">Share on Google+</a></li>
                        </ul>

                    </div>
                </div>



                <div class="clear">
                </div>
            </div>
            <div class="footer">
                <%
                    int total = (Integer) request.getAttribute("total");

                    String[] output = String.valueOf(total).split("");

                    for (int k = 0; k < output.length; k++) {
                %>
                <span class="totalpage"><%=output[k]%></span>

                <%}%> 



            </div>
        </div>

    </body>
</html>





