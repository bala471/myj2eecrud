<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Model.User" %>
<%@ page import="DAO.UserDao" %>
<%
    List<User> userList = UserDao.getAllUsers();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List Users</title>
</head>
<body>
    <h2>List of Users</h2>
    <a href="add-user.jsp">Add New User</a><br><br>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <%
            for (User user : userList) {
        %>
        <tr>
            <td><%= user.getId() %></td>
            <td><%= user.getName() %></td>
            <td><%= user.getEmail() %></td>
            <td><%= user.getCountry() %></td>
            <td>
                <a href="edit-user.jsp?id=<%= user.getId() %>">Edit</a>
                <a href="delete?id=<%= user.getId() %>">Delete</a>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
