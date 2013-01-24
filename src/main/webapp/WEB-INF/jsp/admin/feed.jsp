<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2>Feeds</h2>


<script>
    $(function() {
        $('#feeds').dataTable();
        $('.button').button();
    } );
</script>
<style>
    .button{
        font-size: .75em;
    }
</style>

<table id="feeds">
    <thead>
    <tr>
        <th>Name</th>
        <th>Url</th>
        <th>Last Updated</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="feed" items="${feeds}">
        <tr>
            <td>${feed.name}</td>
            <td>${feed.url}</td>
            <td>${feed.lastUpdated}</td>
            <td>${feed.category.name}</td>
            <td>
                <a class="button" href="<spring:url value="/admin/feed/update/${feed.id}"/>">update</a>
                <a class="button" href="<spring:url value="/admin/feed/delete/${feed.id}"/>">delete</a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>
