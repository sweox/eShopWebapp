<%@ page import="net.golovach.eshop.entity.demo.DemoEntityA" %>
<%@ page import="net.golovach.eshop.entity.demo.DemoEntityB" %>
<html>
    <body>
        <b>MVC Mocl View</b>
        <br/>requestAttribute.str = ${requestAttribute.str}
        <br/>requestAttribute.str = <%= ((DemoEntityA)request.getAttribute("requestAttribute")).getStr()%>

        <br/>requestAttribute.map['key-0'] = ${requestAttribute.map['key-0']}
        <br/>requestAttribute.map['key-0'] =
    <%= ((DemoEntityA)request.getAttribute("requestAttribute")).getMap().get("key-0")%>

        <br/>requestAttribute.mockEntityB.str = ${requestAttribute.mockEntityB.str}
        <br/>requestAttribute.mockEntityB.str =
    <%=((DemoEntityA)request.getAttribute("requestAttribute")).getMockEntityB().getStr()%>

        <br/>sessionAttribute.array[1] = ${sessionAttribute.array[1]}
        <br/>sessionAttribute.array[1] =
    <%=((DemoEntityA)request.getSession().getAttribute("sessionAttribute")).getArray()[1]%>

        <br/>servletContextAttribute.list[0] = ${servletContextAttribute.list[0]}
        <br/>servletContextAttribute.list[0] =
    <%=((DemoEntityA)request.getServletContext().getAttribute("servletContextAttribute")).
    getList().get(0)%>

        <hr/>
        <%--    В атрибуты страницы (scope="page"), по имени pageBin (id="pageBin")
         нужно поместить экземпляры DemoEntityB. Поэтому в DemoEntityB должен быть
         конструктор без аргументов   --%>
        <jsp:useBean id="pageBean" scope="page" class="net.golovach.eshop.entity.demo.DemoEntityB"></jsp:useBean>
        <br/>pageBean.str = ${pageBean.str}
        <hr/>
        <br/>(pageBean.intValue0 gt -10) and (pageBin.intValue1 lt 10) =
            ${(pageBean.intValue0 gt -10) and (pageBean.intValue1 lt 10)}
        <hr/>
        <br/>test = ${test}
        <hr/>
        <br/> <% int x = 1;%>  <%--  Statement (оператор) - то что заканчивается ; --%>
              <% int xx = 88;%>

        <%--<br/> <%= int y = 3;%>
                  <%= Math.random();%>    Expretion (выражение) - то что справа от оператора
                  присваивания (вычисляется и ответ будет вставлен вместо этой сторочки)--%>
    </body>
</html>