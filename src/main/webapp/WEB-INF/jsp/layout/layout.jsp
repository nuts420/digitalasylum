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
    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/jquery.dataTables.css"/>">

    <style>
        #layout_menu{
            vertical-align: top;
        }
    </style>
</head>
<body>
<table border="1">
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="300" id="layout_menu"><tiles:insertAttribute name="menu" /></td>
        <td width="100%"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>