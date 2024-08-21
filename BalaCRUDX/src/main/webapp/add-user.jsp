<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add User</title>
</head>
<body>
    <h2>Add New User</h2>
    <form action="add" method="post">
        Name: <input type="text" name="name"><br>
        Email: <input type="text" name="email"><br>
        Country: <input type="text" name="country"><br>
        <input type="submit" value="Add">
    </form>
    <a href="list">Back to list</a>
</body>
</html>
