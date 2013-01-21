<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<h2>Categories</h2>


<script>
    $(function() {
        $('#categories').dataTable();
        $('.button').button();
    } );
</script>
<style>
    .button{
        font-size: .75em;
    }
</style>

<table id="categories">
    <thead>
    <tr>
        <th>Name</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>


    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.name}</td>
            <td>
                <%--<a class="button" href="<spring:url value="/category/edit/${category.id}"/>">edit</a>--%>
                <a class="button" href="<spring:url value="/admin/category/delete/${category.id}"/>">delete</a>
            </td>
        </tr>

    </c:forEach>

    </tbody>
</table>
