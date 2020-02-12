<%-- 
    Document   : part2
    Created on : Feb 12, 2020, 10:28:29 AM
    Author     : 798419
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            Name: <input type="text" name="fldName" value=""><br>
            Age <input type="text" name="fldAge" value=""><br>

            <button type="submit" name="submit">Add</button>
        </form>

        ${message}
        <br>
        <br>
        <a href="part1">Part 1</a>



        <hr>
        ${guestcount}
    </body>
</html>
