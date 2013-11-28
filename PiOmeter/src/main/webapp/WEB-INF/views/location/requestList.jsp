<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Here are the requests for London</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	type="text/javascript"></script>
</head>
<body>
	
	<p id="demo"></p>

	<script>
		var myVar = setInterval(function() {
			myTimer()
		}, 10000);

		function myTimer() {
			var d = new Date();
			var t = d.toLocaleTimeString();
			document.getElementById("demo").innerHTML = t;
			$('.result').html("");
			sendGETwebrequest();
		}
		function formatDate(date, fmt) {
		    function pad(value) {
		        return (value.toString().length < 2) ? '0' + value : value;
		    }
		    return fmt.replace(/%([a-zA-Z])/g, function (_, fmtCode) {
		        switch (fmtCode) {
		        case 'Y':
		            return date.getUTCFullYear();
		        case 'M':
		            return pad(date.getUTCMonth() + 1);
		        case 'd':
		            return pad(date.getUTCDate());
		        case 'H':
		            return pad(date.getUTCHours());
		        case 'm':
		            return pad(date.getUTCMinutes());
		        case 's':
		            return pad(date.getUTCSeconds());
		        default:
		            throw new Error('Unsupported format code: ' + fmtCode);
		        }
		    });
		}
		function sendGETwebrequest() {
			$
					.ajax({
						// the URL for the request
						url : "webrequest",

						// whether this is a POST or GET request
						type : "GET",

						// the type of data we expect back
						dataType : "json",

						// code to run if the request succeeds;
						// the response is passed to the function
						success : function(json) {

							// 	$("#div1").text( json.title ).appendTo( "body" );
							//  $(".result").append('yoko ' + JSON.stringify(json));
							for ( var i = 0; i < json.length; i++) {
								$('.result').append(
										'<b>Web request data: </b>'
												+ 'Start Time: '
												+ new Date(json[i].startTime).getUTCSeconds()
												+ ' End Time: '
												+ json[i].endTime 
												+ ' Requested url: '
												+ json[i].requestUrl + '<br>');
							}
						},

						// code to run if the request fails; the raw request and
						// status codes are passed to the function
						error : function(xhr, status) {
							alert("Sorry, there was a problem!");
						},

						// code to run regardless of success or failure
						complete : function(xhr, status) {
							//	alert("The request is complete!");
						}
					});

		}
	</script>
	Web reqs are running fast in London
	<h1></h1>
	<p></p>
	<div class="result">
		<ol>
			<c:forEach items="${requests}" var="request">
				<li><b>Web request data: </b> <c:out
						value="${request.location.name}"></c:out> Start Time was = <c:out
						value="${request.startTime}"></c:out> End Time was = <c:out
						value="${request.endTime}"></c:out> Request Url was =
					${request.requestUrl}</li>
			</c:forEach>
		</ol>
	</div>
</body>
</html>