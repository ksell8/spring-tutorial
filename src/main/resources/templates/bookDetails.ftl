<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Details</title>
</head>
<body>
    <h2>Book Details</h2>

    <#if bookDetails??>
        <p>Title: ${bookDetails.details.title}</p>
        <p>Publishers: ${bookDetails.details.publishers[0]}</p>
        <p>Publish Date: ${bookDetails.details.publish_date}</p>
        <p>Pages: ${bookDetails.details.number_of_pages}</p>
        <p><img src="${bookDetails.thumbnail_url}" alt="Book cover"/></p>
        <a href="${bookDetails.preview_url}">Read Preview</a>
    <#else>
        <p>No book details found for this ISBN.</p>
    </#if>

    <!-- Add a new button to go back to the form -->
    <form action="/bookform" method="get">
        <button type="submit">Add a New Book</button>
    </form>
</body>
</html>