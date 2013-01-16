<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Feeds</h2>


<script>
    $(function() {
        $('#feeds').dataTable();
    } );
</script>

<table id="feeds">
    <thead>
    <tr>
        <th>Name</th>
        <th>Url</th>
        <th>Type</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="feed" items="${feeds}">
        <tr>
            <td>${feed.name}</td>
            <td>${feed.url}</td>
            <td>${feed.feedType}</td>
        </tr>

    </c:forEach>

    </tbody>
</table>
