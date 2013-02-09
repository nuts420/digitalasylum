<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function() {
        $( "#menu" ).menu();
    });
</script>
<style>
    .ui-menu { width: 150px; }
    .ui-menu .ui-menu-item a {font-size: 12px;}
</style>

<ul id="menu">
    <c:forEach var="category" items="${categories}">
        <li>
            <a href="/category/${category.id}">${category.name}</a>
        </li>

    </c:forEach>
</ul>