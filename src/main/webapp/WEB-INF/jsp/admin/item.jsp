<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Items</h2>




<script>
    $(function() {
        $('#items').dataTable();
    } );
</script>
<style>
    .date{
        white-space: nowrap;
        font-size: .5em;
    }
    .title{
        /*white-space: nowrap;*/
        font-size: .75em;
        width: 250px;
    }
</style>

<table id="items">
    <thead>
    <tr>
        <th>Pub Date</th>
        <th>Title</th>
        <th>Description</th>
        <th>Channel</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="item" items="${items}">
        <tr>
            <td class="date">${item.pubDate}</td>
            <td class="title"><a href="${item.link}" target="_blank">${item.title}</a></td>
            <td>${item.description}</td>
            <td><a href="${item.channel.imageLink}"><img src="${item.channel.imageUrl}" alt="${item.channel.imageTitle}" width="70"></a></td>
        </tr>

    </c:forEach>

    </tbody>
</table>
