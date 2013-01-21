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
    <li>
        <a href="/admin">Admin</a>
<%--        <ul>
            <li>
                <a href="/category">Categories</a>
                <ul>
                    <li><a href="/category/add">Add</a></li>
                </ul>
            </li>
            <li>
                <a href="/post">Posts</a>
                <ul>
                    <li><a href="/post/add">Add</a></li>
                </ul>
            </li>
            <li><a href="/feed">Feeds</a>
                <ul>
                    <li><a href="/feed/add">Add</a></li>
                </ul>
            </li>
            <li><a href="/channel">Channels</a></li>
            <li><a href="/item">Items</a></li>


        </ul>--%>

    </li>

    <c:forEach var="category" items="${categories}">
        <li>
            <a href="${category.name}">${category.name}</a>
        </li>

    </c:forEach>
</ul>