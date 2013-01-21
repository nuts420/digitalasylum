<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Posts</h2>

<c:forEach var="post" items="${posts}">
    Title: <c:out value="${post.title}"/>
    Body: <c:out value="${post.body}"/>
    <br/>
</c:forEach>