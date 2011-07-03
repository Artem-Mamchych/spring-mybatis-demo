<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head></head>
<body>
<table border="1" width="100%">
    <c:forEach var="message" items="${messages}" varStatus="i">
        <tr>
            <td width="20%"><spring:message code="label.message.datePosted"/> <c:out
                    value="${message.datePosted}"/>

            </td>
            <td width="80%"><spring:message code="label.message.messageContent"/> <c:out
                    value="${message.messageContent}"/>
            </td>
            <td>
                 <a href="${pageContext.request.contextPath}/message/update/<c:out
                    value="${message.id}"/>"><spring:message code="label.message.edit"/></a>
                <a href="${pageContext.request.contextPath}/message/delete/<c:out
                    value="${message.id}"/>"><spring:message code="label.message.delete"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/message/create/"><spring:message code="label.message.add"/></a>
</body>
</html>