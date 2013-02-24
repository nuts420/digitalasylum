<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <link type="text/css" rel="stylesheet" href="<tiles:getAsString name="style"/>"/>
    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/smoothness/jquery-ui-1.9.2.custom.css"/>">
    <script type="text/javascript" src="<spring:url value="/js/jquery-1.8.3.js"/>"></script>
    <script type="text/javascript" src="<spring:url value="/js/jquery-ui-1.9.2.custom.js"/>"></script>
    <script type="text/javascript" src='<spring:url value="/js/jquery.dataTables.min.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/jquery.masonry.min.js"/>'></script>

    <script type="text/javascript" src='<spring:url value="/js/jquery.mousewheel-3.0.6.pack.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/jquery.fancybox.pack.js"/>'></script>

    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/jquery.fancybox.css"/>">


    <script type="text/javascript" src='<spring:url value="/js/helpers/jquery.fancybox-buttons.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/helpers/jquery.fancybox-media.js"/>'></script>
    <script type="text/javascript" src='<spring:url value="/js/helpers/jquery.fancybox-thumbs.js"/>'></script>

    <link type="text/css" rel="stylesheet" href="<spring:url value="/js/helpers/jquery.fancybox-buttons.css"/>">
    <link type="text/css" rel="stylesheet" href="<spring:url value="/js/helpers/jquery.fancybox-thumbs.css"/>">

    <link type="text/css" rel="stylesheet" href="<spring:url value="/css/jquery.dataTables.css"/>">

<style>
    #layout_menu{
        vertical-align: top;
        width: 156px;
        overflow: hidden;
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
    #layout_table{
        table-layout: fixed;
    }
    #layout_body{
        width: 100%;
        vertical-align: top;
    }

</style>
</head>
<body>
<table id="layout_table">
    <tr>
        <td colspan="2"><tiles:insertAttribute name="header" /></td>
    </tr>
    <tr>
        <td id="layout_menu"><tiles:insertAttribute name="menu" /></td>
        <td id="layout_body">
            <div id="body"><tiles:insertAttribute name="body" /></div>
        </td>
    </tr>
    <tr>
        <td id="footer" height="30" colspan="2"><tiles:insertAttribute name="footer" />
        </td>
    </tr>
</table>
</body>
</html>