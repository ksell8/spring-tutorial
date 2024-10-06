<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Enter ISBN</title>
</head>
<body>
    <h2>Enter ISBN</h2>

    <#import "/spring.ftl" as spring />

    <form action="/getBookDetails" method="get">
        <@spring.bind "isbn" />
        <label for="isbn">ISBN:</label>
        <input type="text" id="isbn" name="isbn" value="${isbn}" />
        <button type="submit">Fetch Book</button>
    </form>
</body>
</html>