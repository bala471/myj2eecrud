<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Model.User" %>
<%@ page import="DAO.UserDao" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    User user = UserDao.getUserById(id);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>
</head>
<body>
    <h2>Edit User</h2>
    <form action="edit" method="post">
        <input type="hidden" name="id" value="<%= user.getId() %>">
        Name: <input type="text" name="name" value="<%= user.getName() %>"><br>
        Email: <input type="text" name="email" value="<%= user.getEmail() %>"><br>
        Country: <input type="text" name="country" value="<%= user.getCountry() %>"><br>
        <input type="submit" value="Update">
    </form>
    <a href="list">Back to list</a>
</body>
</html>
