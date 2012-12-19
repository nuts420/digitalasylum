<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="style"/>"/>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="jQueryUIStyle"/>">
    <script src="<tiles:getAsString name="jQuery"/>"></script>
    <script src="<tiles:getAsString name="jQueryUI"/>"></script>
</head>
<body>
<table border="1">
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="header" />
        </td>
    </tr>
    <tr>
        <td width="300"><tiles:insertAttribute name="menu" /></td>
        <td width="100%"><tiles:insertAttribute name="body" /></td>
    </tr>
    <tr>
        <td height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>