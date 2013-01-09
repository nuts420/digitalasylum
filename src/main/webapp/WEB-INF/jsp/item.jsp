<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Items</h2>

<c:forEach var="item" items="${items}">
    Title: ${item.title}
    Link: ${item.link}"/>
    Description: ${item.description}
    <%--Feed: ${channel.feed.name}--%>
    <br/>
</c:forEach>