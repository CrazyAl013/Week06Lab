<%-- 
    Document   : shoppinglist
    Created on : 22-Oct-2020, 7:04:48 PM
    Author     : Alex Tompkins - 821984
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, <c:out value="${sessionScope.username}"/></p>
        <a href="ShoppingList?action=logout">Logout</a>
        
        <form action="" method="post">
            <h2>Add Item</h2>
            <input type="text" name="item">
            <input type="submit" value="Add Item">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
                <c:forEach var="item" items="${sessionScope.items}">
                    <li>
                        <input type="radio" name="listItem" value="${item}">
                        ${item}
                    </li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form> 
    </body>
</html>
