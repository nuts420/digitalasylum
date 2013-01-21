<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h2>Add Post</h2>
<form:form method="post" action="/admin/post/addPost">

    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title" /></td>
        </tr>
        <tr>
            <td><form:label path="body">Body</form:label></td>
            <td><form:input path="body" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Add Post"/>
            </td>
        </tr>
    </table>

</form:form>
