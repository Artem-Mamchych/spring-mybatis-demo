<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head></head>
<body>
<h1>
TODO: use spring:message code="label.author"
</h1>
<table border="1" width="100%">
    <c:forEach var="message" items="${messages}" varStatus="i">
        <tr>
            <td width="20%">Date: <c:out
                    value="${message.datePosted}"/>
            </td>
            <td width="80%">Text: <c:out
                    value="${message.messageContent}"/>
            </td>

        </tr>
    </c:forEach>
</table>

</body>
</html>