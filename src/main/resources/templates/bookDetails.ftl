<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Book Details</title>
</head>
<body>
    <h2>Book Details</h2>

    <#if bookDetails??>
        <form id="addBook" method="post" action="/addBook">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title"
                   value="<#if bookDetails.title??>${bookDetails.title}</#if>">
            <br><br>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author"
            <#-- TODO: Figure out how to support both types of APIs (most likely in controller) -->
                value="<#if bookDetails.authors??>${bookDetails.authors[0]}</#if>">
            <br><br>

            <label for="isbn">ISBN:</label>
            <input type="text" id="isbn" name="isbn" value="${bookDetails.isbn}">
            <br><br>

            <label for="publisher">Publisher:</label>
            <input type="text" id="publisher" name="publisher"
                   value="<#if bookDetails.publishers??>${bookDetails.publishers[0]}<#elseif bookDetails.publisher??>${bookDetails.publisher}</#if>">
            <br><br>

            <label for="publishedYear">Publish Year:</label>
            <input type="number" id="publishedYear" name="publishedYear"
                   value="<#if bookDetails.publishedYear??>${bookDetails.publishedYear}</#if>">
            <br><br>

            <label for="pages">Number of Pages:</label>
            <input type="number" id="pages" name="pages"
                   value="<#if bookDetails.number_of_pages??>${bookDetails.number_of_pages}<#elseif bookDetails.pageCount??>${bookDetails.pageCount}</#if>">
            <br><br>

            <label for="genre">Genre:</label>
            <select id="genre" name="genre">
                <option value="">None</option>
                <#list genres as genre>
                    <option value="${genre}">
                        ${genre?capitalize}
                    </option>
                </#list>
            </select>
            <br><br>

            <label for="status">Status:</label>
            <select id="status" name="status">
                <option value="">None</option>
                <#list statuses as status>
                    <option value="${status}">
                        ${status?capitalize}
                    </option>
                </#list>
            </select>
            <br><br>

            <label for="hardcover">Hardcover:</label>
            <#-- checkbox only sends data on true, this way in the case of false it will be OK -->
            <input type="hidden" name="hardcover" value="false">
            <input type="checkbox" id="hardcover" name="hardcover"> Hardcover
            <br><br>

            <button type="submit">Add Book</button>
        </form>
    <#else>
        <p>No book details found for this ISBN.</p>
    </#if>
</body>
</html>
