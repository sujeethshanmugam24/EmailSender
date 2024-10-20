<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Sender</title>
    <style>
        body { font-family: Arial, sans-serif; }
        form { width: 300px; margin: 50px auto; }
        label { display: block; margin-bottom: 5px; }
        input, textarea { width: 100%; margin-bottom: 10px; }
    </style>
</head>
<body>
    <h2 style="text-align: center;">Send Email</h2>
    <form action="/sendEmail" method="post">
            <label for="toEmail">To (separate multiple emails with commas):</label>
            <input type="email" id="toEmail" name="toEmail" required>

            <label for="subject">Subject:</label>
            <input type="text" id="subject" name="subject" required>

            <label for="body">Body:</label>
            <textarea id="body" name="body" required></textarea>

            <input type="submit" value="Send Email">
        </form>
    <c:if test="${not empty error}">
        <p style="color:red;">${error}</p>
    </c:if>
</body>
</html>
