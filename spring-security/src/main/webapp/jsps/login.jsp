<%@ page contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input name="username" type="text"/></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password"/></td>
			</tr>
			<tr>
				<td colspan ="2">
					<input type="submit" value="Login" name="login"/>
				</td>
			</tr>
		</table>
	</form>
	</body>
</html>