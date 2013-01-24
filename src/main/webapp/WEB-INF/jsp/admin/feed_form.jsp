<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Add Feed</h2>
<form:form method="post" action="/admin/feed/addFeed">

    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="url">Url</form:label></td>
            <td><form:input path="url" /></td>
        </tr>
        <tr>
            <td><form:label path="category">Feed Type</form:label></td>
            <td>
                <%--<form:select path="category" items="${categories}" />--%>
                <select name="category">
                <c:forEach items="${categories}" var="category">
                    <option value="${category.id}">${category.name}
                </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Add Feed"/>
            </td>
        </tr>
    </table>

</form:form>