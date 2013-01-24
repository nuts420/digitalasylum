<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h2>Add Category</h2>
<form:form method="post" modelAttribute="category" action="/admin/category/edit/${category.id}">

    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" readonly="true"></form:input></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>

            <%--        <tr>
                        <td><form:label path="feedType">Feed Type</form:label></td>
                        <td>
                            <form:select path="feedType" items="${feedTypeList}" />
                        </td>
                    </tr>--%>

        <tr>
            <td colspan="2">
                <input type="submit" value="Update"/>
            </td>
        </tr>
    </table>

</form:form>