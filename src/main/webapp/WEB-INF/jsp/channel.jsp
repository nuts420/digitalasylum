<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Channels</h2>
<script>
    $(function() {
        $('#channels').dataTable();
    } );
</script>

<table id="channels">
<thead>
<tr>
    <th>Title</th>
    <th>Link</th>
    <th>Description</th>
    <th>Image</th>
    <th>Feed</th>
</tr>
</thead>
<tbody>


<c:forEach var="channel" items="${channels}">
    <tr>
        <td>${channel.title}</td>
        <td>${channel.link}</td>
        <td>${channel.description}</td>
        <td><a href="${channel.imageLink}"><img src="${channel.imageUrl}" alt="${channel.imageTitle}"></a></td>
        <td>${channel.feed.name}</td>
    </tr>

</c:forEach>

</tbody>
</table>

