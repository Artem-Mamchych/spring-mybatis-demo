<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
	<title>@Controller Example</title>
</head>
<body>
<div class="container">
	<h1>
		View Message
	</h1>
	<div class="span-12 last">
		<form:form modelAttribute="message" action="${message.id}" method="post">
		  	<fieldset>
				<legend>Message Fields</legend>
				<p>
					<form:label	for="messageContent" path="messageContent">messageContent</form:label><br/>
					<form:input path="messageContent" readonly="true"/>
				</p>
				<p>
					<form:label for="datePosted" path="datePosted">datePosted</form:label><br/>
					<form:input path="datePosted" readonly="true"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	<hr>
	<ul>
		<li> <a href="?locale=en_us">us</a> |  <a href="?locale=en_gb">gb</a> | <a href="?locale=es_es">es</a> | <a href="?locale=de_de">de</a> </li>
	</ul>
</div>
</body>
</html>