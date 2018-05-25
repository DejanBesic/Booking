<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Welcome</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
	
	<button id ="showUser" style = " display: none;" onClick="showUsers()">Show all users</button>
	<button id ="backgrd" style = " display: none;"  onClick="changeBackground()">Background Color</button>
	<button id ="writeS" style = " display: none;"  onClick="writeS()">Write something.</button>
	<button id ="alertme" onClick="alertMe()">Alert me</button>
	<p id="allUsers"></p>
</div>
<!-- /container -->
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script>

	$(document).ready(function(){
		$.ajax({
			url: "../user/getUserRole",
			success: function(data){
				if(data=="REGULAR"){
					document.getElementById("writeS").style.display = "inline";
				}
				else if(data=="AGENT"){
					document.getElementById("backgrd").style.display= "inline";
				}
				else if(data=="ADMIN"){
					document.getElementById("showUser").style.display = "inline";
				}
			},
			error: function (xhr, ajaxOptions, thrownError) {
				console.log("asa");
		        console.log(xhr.responseText);
		      }
		});
	});
		
	function showUsers(){
		$.ajax({
			url: "../user/getUsers",
			success: function(data){
				document.getElementById("allUsers").innerHTML = "";
				for(var i in data){
					document.getElementById("allUsers").innerHTML += data[i]+'</br>';
				}
			}
			
		});
	}
	
	function changeBackground(){
		$.ajax({
			url: "../user/getUsersCol",
			success: function(data){
				$("div").css("background-color", data);
			}
			
		});
		
	}
	
	function writeS(){
		console.log("ASD");
		$.ajax({
			url: "../user/getUsersEmail",
			success: function(data){
				console.log(data);
				document.getElementById("allUsers").innerHTML = data;
			},
			error: function (xhr, ajaxOptions, thrownError) {
				console.log("asa");
		        console.log(xhr.responseText);
		      }
		});
	}
	
	function alertMe(){
		alert("Za sve korisnike.");
	}
</script>
</body>
</html>
