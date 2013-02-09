<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>Login</h1>
<div id="login-error">${error}</div>


<c:if test="${not empty error}">
    <div class="errorblock">
        Your login attempt was not successful, try again.<br /> Caused :
            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>

<spring:url var="logoUrl" value="/images/openidlogosmall.png" />
<p><img src="${logoUrl}"/>Login with OpenID:</p>
<c:url var="openIDLoginUrl" value="/j_spring_openid_security_check" />
<form action="${openIDLoginUrl}" method="post" >
    <label for="openid_identifier">OpenID Login</label>:
    <input id="openid_identifier" name="openid_identifier" type="text"/>
    <input  type="submit" value="Login"/>
</form>

<hr/>

<spring:url var="googleLogoUrl" value="/images/google-logo.png" />
<img src="${googleLogoUrl}"/>
<form action="<c:url value='/j_spring_openid_security_check' />" method="post">
    For Google users:
    <input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id"/>

    <input type="submit" value="Sign with Google"/>
</form>