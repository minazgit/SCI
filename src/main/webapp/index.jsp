<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Report Example!</h1>

        <form action="IssueNoteReportServlet" method="get">
            <input type="submit" value="issue report" name="btn1" />
        </form>

        <form action="purchaseOrderServlet" method="get">
            <input type="submit" value="purchase report" name="btn1" />
        </form>
    </body>
</html>
