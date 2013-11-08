<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here are the requests for London</title>
</head>
<body>
Web reqs are running fast in London
<ol>
		<c:forEach items="${requests}" var="request">
			<li>
			<b>Web site logging information has been received from </b>
			 <c:out value="${request.location.name}"></c:out> 
			Start Time was = <c:out value="${request.startTime}"></c:out> 
			End Time was = <c:out value="${request.endTime}"></c:out>
			Request Url was = ${request.requestUrl}
			
			</li>
		</c:forEach>
	</ol>
</body>
</html>