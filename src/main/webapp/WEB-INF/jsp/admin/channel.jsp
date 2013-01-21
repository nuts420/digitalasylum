<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2>Channels</h2>
<script>
    $(function() {
        $('#channels').dataTable();
        $('.button').button();
    } );
</script>

<style>
    .button{
        font-size: .75em;
    }
</style>

<table id="channels">
<thead>
<tr>
    <th>Title</th>
    <th>Link</th>
    <th>Description</th>
    <th>Image</th>
    <th>Feed</th>
    <th>Actions</th>
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
        <td>
            <a class="button" href="<spring:url value="/admin/channel/delete/${channel.id}"/>">delete</a>
        </td>
    </tr>

</c:forEach>

</tbody>
</table>

