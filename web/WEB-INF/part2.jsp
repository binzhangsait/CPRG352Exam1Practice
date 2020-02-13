<%-- 
    Document   : part2
    Created on : Feb 12, 2020, 10:28:29 AM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CPRG352 Practice Exam 1</h1>

        <h2>${phrase}</h2>

        <form method="post">
            Name: <input type="text" name="fldName" value="" required=""><br>
            Age <input type="text" name="fldAge" value="" required=""><br>

            <button type="submit" name="submit">Add</button>
        </form>

        ${message}
        <br>



        <hr>

        <c:if test="${loadlist.size() > 0}" >
            <table border='1' style='color: red; size: 20px'>
                <tr >
                    <td>Name</td>
                    <td>Age</td>
                </tr>
                <c:forEach items="${loadlist}" var="list" >

                    <tr >
                        <td>${list.name}</td>
                        <td>${list.age}</td>
                    </tr>

                </c:forEach>

            </table>
        </c:if>


        <hr>

        <br>
        <a href="part1">Part 1</a>



        <hr>
        ${guestcount}
    </body>
</html>
