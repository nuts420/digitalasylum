<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="style"/>"/>
    <link href="css/smoothness/jquery-ui-1.9.2.custom.css" rel="stylesheet">
    <script src="js/jquery-1.8.3.js"></script>
    <script src="js/jquery-ui-1.9.2.custom.js"></script>
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