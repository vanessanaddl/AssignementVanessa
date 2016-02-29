<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Anagram Engine 2.0</title>
</head>
<body style="font-family: Calibri">
	<!-- if the user is logged in then we need to render one version of
 the page
consequently if the user is logged out we need to render adifferent version
                   of the page
            -->
	<b>${MessageTask8}</b>

	<c:choose>
		<c:when test="${user != null}">
			<p>
				Welcome ${user.email} <br/> 
			</p>
			<form action="/anagram" method="get">
				Search the Anagrams of your favorite word: <input type="text"
					name="text_input1"/><input type="submit" value="Go for it!"/><br/>
			</form>
		
			<!--  c:choose textinput="" oder null? -->
			
			<form action="/anagram" method="post">
				Add your favorite word to the List: <input type="text"
					name="text_input2"/><input type="submit" value="Go for it!"/><br/>
			</form>
			<p>
			${MessageTest}
			</p>
			<br/><br/><br/><br/>
			You can signout <a href="${logout_url}">here</a><br/>
		</c:when>
		<c:otherwise>
			<p>
				Welcome! <a href="${login_url}">Sign in or register</a>"
				</p>
				</c:otherwise>
				
	</c:choose>
	

	



</body>
</html>