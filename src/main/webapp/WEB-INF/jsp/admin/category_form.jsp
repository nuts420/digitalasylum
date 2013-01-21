<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<h2>Add Category</h2>
<form:form method="post" action="/admin/category/addCategory">

    <table>
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
                <input type="submit" value="Add Category"/>
            </td>
        </tr>
    </table>

</form:form>