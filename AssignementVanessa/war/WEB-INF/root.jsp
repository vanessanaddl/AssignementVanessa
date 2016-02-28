<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>This is example 002</title>
</head>
<body>
	<!-- if the user is logged in then we need to render one version of
 the page
consequently if the user is logged out we need to render adifferent version
                   of the page
            -->

	<c:choose>
		<c:when test="${user != null}">
			<p>
				Welcome ${user.email} <br /> You can signout<a
					href="${logout_url}">here</a><br /> The current time is:
				${current_time}
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Welcome! <a href="${login_url}">Sign in or register</a>"
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>