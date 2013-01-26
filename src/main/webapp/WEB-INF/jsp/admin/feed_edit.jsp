<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>Update Feed</h2>
<form:form method="post" modelAttribute="feed" action="/admin/feed/editSubmit">

    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" readonly="true"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="url">Url</form:label></td>
            <td><form:input path="url" /></td>
        </tr>
        <tr>
            <td><form:label path="category.id">Feed Type</form:label></td>
            <td><form:select path="category.id" items="${categories}" itemLabel="name" itemValue="id" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Update Feed"/>
            </td>
        </tr>
    </table>

</form:form>