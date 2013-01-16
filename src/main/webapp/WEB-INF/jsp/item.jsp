<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Items</h2>




<script>
    $(function() {
        $('#items').dataTable();
    } );
</script>

<table id="items">
    <thead>
    <tr>
        <th>Title</th>
        <th>Link</th>
        <th>Description</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.title}</td>
            <td><a href="${item.link}" target="_blank">${item.link}</a></td>
            <td>${item.description}</td>
        </tr>

    </c:forEach>

    </tbody>
</table>
