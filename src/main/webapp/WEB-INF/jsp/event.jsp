<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>event</h2>

<c:forEach var="event" items="${events}">
    Title: <c:out value="${event.title}"/>
    Date: <c:out value="${event.date}"/>
    <br/>
</c:forEach>
