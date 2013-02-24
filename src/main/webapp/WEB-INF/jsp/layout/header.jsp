<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    #title{
        text-decoration: none;
        padding-left: 10px;
        color: #000;
        float: left;
    }
    #title:hover{
        color: #555;
    }
    #date{
        text-align: right;
        float: right;
        padding-right: 10px;
    }

</style>

<a id="title" href="/"><h1>DigitalAsylum</h1></a>

<c:choose>
    <c:when test="${not empty date}">
        <p id="date">News From: ${date}</p>
    </c:when>
    <c:otherwise>
        <jsp:useBean id="now" class="java.util.Date"/>
        <p id="date">Date: <fmt:formatDate value="${now}" pattern="MM-dd-yyyy" /></p>
    </c:otherwise>
</c:choose>