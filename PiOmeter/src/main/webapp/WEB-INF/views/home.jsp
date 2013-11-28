<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page errorPage="ShowError.jsp" %>

<%@ page session="false"%>
<html>
<head>
<title>PioMeter Home</title>
<base href="${pageContext.request.contextPath}">
</head>
<body>
	<h1>Please select a location to see performance statistics:</h1>
	Here is the pc .... ${pageContext.request.contextPath}
	<ol>
		<c:forEach items="${locations}" var="location">
			<c:url value="/location" var="locString">
				<c:param name="location" value="${location.name}"></c:param>
			</c:url>
			
			<li><a href="${pageContext.request.contextPath}/location?location='London'">${location.name}</a></li>
		</c:forEach>
	</ol>

	<P>The time on the server is ${serverTime}.</P>
</body>
</html>
