<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
    $(function() {
        $( "#menu" ).menu();
        $( "#datepicker" ).datepicker({
            dateFormat: "mm-dd-yy",
            onSelect: function (dateText, inst) {
                <c:choose>
                    <c:when test="${not empty date}">
                        document.location.href = dateText;
                    </c:when>
                    <c:otherwise>
                        document.location.href = document.location.href + "/date/" + dateText;
                    </c:otherwise>
                </c:choose>
            }
        });
    });
</script>
<style>

    .ui-menu .ui-menu-item a {font-size: .75em;}
    li p {
        font-size: .75em;
        padding-left: 5px;
    }
    #datepicker{font-size: .75em;}
    #ui-datepicker-div{font-size: .75em;}
    #menu_box{
        width: 156px;
    }
    #menu{
        width: 150px;
        position: fixed;
    }
</style>

<div id="menu_box">
    <ul id="menu">
        <c:forEach var="category" items="${categories}">
            <li>
                <c:choose>
                    <c:when test="${not empty date}">
                        <a href="/category/${category.id}/date/${date}">${category.name}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="/category/${category.id}">${category.name}</a>

                    </c:otherwise>
                </c:choose>
            </li>

        </c:forEach>

        <li><hr/></li>
        <li><p>Date: <input type="text" id="datepicker" value="${date}" size="10"/><p/></li>
    </ul>
</div>
