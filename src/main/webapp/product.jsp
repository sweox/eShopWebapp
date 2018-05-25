<%--Подключение бибилиотеки тэгов--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="net.golovach.eshop.entity.Product" %>
<html>
    <body>
        <b>PRODUCT PAGE</b>
        <br/> //EL = Expression Language
        <br/>id: ${product.id}  <%--EL = Expression Language--%>
        <br/>//Scriptlet
        <br/>id: <%= ((Product)request.getAttribute("product")).getId()%> <%--Scriptlet--%>
        <br/>//Scriptlet
        <br/><a href="./productAll.jsp">main page</a>

        <br/>id:
        <%
            response.getWriter().write(((Product)request.getAttribute("product")).getId());
        %>
        <br/>name: ${product.name}

        <br/><%-- Add quiz to backet --%>
        <a href="./productAddToBucket.do?id=${product.id}"> Add this product to bucket</a>

        <br/><%--Show products backet --%>
        <h2>Product in bucket</h2>
        <ul>
            <c:forEach var="productInBucket" items="${productsInBucket}">
                <li>
                    <a href="./product.do?id=${productInBucket.key.id}">${productInBucket.key.name}</a>: =
${productInBucket.value}
                    <%--(<a href="./productRemoveFromBucket.do?id=${productInBucket.id}&redirectToId=--%>
<%--${product.id}">X</a>--%>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>