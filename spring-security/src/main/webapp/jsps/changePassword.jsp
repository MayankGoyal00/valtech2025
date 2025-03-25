<%@ page contentType="text/html; charset=ISO-8859-1" %>
<html>
<head>
<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>
					Current Password
				</td>
				<input type="password" name="currentPassword"/>
			</tr>
			<tr>
				<td>
					New Password
				</td>
				<input type="password" name="newPassword"/>
			</tr>
			<tr>
				<td>
					Confirm Password
				</td>
				<input type="password" name="confirmPassword"/>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Change Password"/>
				</td>
			</tr>
		</table>
	</form>


</body>
</html>