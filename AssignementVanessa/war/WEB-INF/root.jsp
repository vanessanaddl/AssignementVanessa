<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Anagram Engine 2.0</title>
</head>
<body style="font-family: Calibri">

	<b>${MessageTask8}</b>

	<c:choose>
		<c:when test="${user != null}">
			<p>
				Hi, ${user.email}<br/>
			</p>
			<form action="/anagram" method="get">
				Search the Anagrams of your favorite word: <input type="text"
					name="text_input1"/><input type="submit" value="Go for it!"/><br/>
			</form>

			<form action="/anagram" method="post">
				Add your favorite word to the List: <input type="text"
					name="text_input2"/><input type="submit" value="Go for it!"/><br/>
			</form>
			<br/>
			<textarea rows="3" cols="60">
				${Message}
			</textarea>
			<br/><br/><br/><br/>
			Tired of Anagram Engine 2.0? Signout <a href="${logout_url}">here.</a> See you :) 
			<br/>
			
		</c:when>
		<c:otherwise>
			<p>
				Welcome to Anagram Engine 2.0! Nice to see you :) <br/>
				Sign in or register with your <a href="${login_url}">Google Account</a>".
			</p>
			
		</c:otherwise>

	</c:choose>






</body>
</html>