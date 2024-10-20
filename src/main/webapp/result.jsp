<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Email Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 50px;
        }
        .result-container {
            text-align: center;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
            width: 400px;
        }
    </style>
</head>
<body>

<div class="result-container">
    <h2>${message}</h2>
    <a href="/">Send another email</a>
</div>

</body>
</html>
