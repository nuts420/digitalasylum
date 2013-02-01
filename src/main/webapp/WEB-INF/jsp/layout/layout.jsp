<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="style"/>"/>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="jQueryUIStyle"/>">
    <script src="<tiles:getAsString name="jQuery"/>"></script>
    <script src="<tiles:getAsString name="jQueryUI"/>"></script>
    <script type="text/javascript" src='<spring:url value="/js/jquery.dataTables.min.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/openid-en.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/openid-jquery.js"/>'></script>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/jquery.dataTables.css"/>">
    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/openid.css"/>">

<style>
    #layout_menu{
        vertical-align: top;
    }
    #body{
        padding: 20px;
        background-color: white;
        border: 1px solid #aaaaaa;
        border-radius: 4px;
    }
    #footer{
        text-align: center;
    }

</style>
</head>
<body>
<table>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="300" id="layout_menu"><tiles:insertAttribute name="menu" /></td>
        <td width="100%"><div id="body"><tiles:insertAttribute name="body" /></div></td>
    </tr>
    <tr>
        <td id="footer" height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>