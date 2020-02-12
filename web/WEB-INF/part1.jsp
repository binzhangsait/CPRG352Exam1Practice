<%-- 
    Document   : part1
    Created on : Feb 12, 2020, 10:28:17 AM
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

        <form method="post">
            Enter a motivational phrase: <input type="text" name="fldPhrase" value=""><br>

            <button type="submit" name="submit">Set Phrase</button>
        </form>
        <br>
        <h2>${phrase}</h2>
        <br>

        <a href="part2">Part 2</a>

        <hr>
        ${guestcount}
    </body>
</html>
