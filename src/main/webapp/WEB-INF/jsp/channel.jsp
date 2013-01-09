<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Channels</h2>

<c:forEach var="channel" items="${channels}">
    Title: <c:out value="${channel.title}"/>
    Link: <c:out value="${channel.link}"/>
    Description: <c:out value="${channel.description}"/>
    Feed: ${channel.feed.name}
    <br/>
</c:forEach>