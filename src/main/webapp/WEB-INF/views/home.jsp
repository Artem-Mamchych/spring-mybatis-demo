<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<br/>
<a href="sum">Calculator</a><br/>
<a href="${pageContext.request.contextPath}/message-all">Messages</a>
</body>
</html>
