<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Feeds</h2>

<c:forEach var="feed" items="${feeds}">
    Name: <c:out value="${feed.name}"/>
    Url: <c:out value="${feed.url}"/>
    Type: <c:out value="${feed.feedType}"/>
    <br/>
</c:forEach>