<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>

    #container .col1 { min-width: 250px; width: 30%; box-sizing: border-box;}
    #container .col2 { min-width: 250px; width: 60%; box-sizing: border-box;}
    #container .col3 { min-width: 250px; width: 90%; box-sizing: border-box;}


    .item{
        border-top: 4px solid #8c8cbd;
        float: left;
        margin: 10px;
        display: table;
    }
    .pubDate{
        font-size: .6em;
        margin: 0;
    }
    .sourceLink{
        font-size: .75em;
        text-decoration: none;
        color: #000;
    }

    .sourceLink:hover{
        color: #8c8cbd;
    }

    .titleLink{
        font-size: .9em;
        text-decoration: none;
        font-weight: bold;
        color: #000000;
    }
    .titleLink:hover{
        background-color: #cccccc;
    }

    .title{
        float: left;
        display: table-cell;
    }
    .logo{
        float: right;
        height: auto;
        display: table-cell;
    }
    .content{
        clear: both;
    }

    .content p a img{
        margin-right: 5px;
    }
    .content a img{
        margin-right: 5px;
    }

    .feedflare{
        display: none;
    }

</style>


<script type="text/javascript">

    $(function(){
        var $container = $('#container');

        $container.imagesLoaded( function(){
            $container.masonry({
                columnWidth: 50
            });
        });

        $(".titleLink").fancybox({
            //maxWidth	: 800,
            //maxHeight	: 600,
            fitToView	: false,
            width		: '90%',
            height		: '90%',
            autoSize	: false,
            closeClick	: false,
            openEffect	: 'elastic',
            openSpeed   : 'slow',
            closeEffect	: 'elastic'
        });
    });

</script>

<div id="container">



    <c:forEach var="item" items="${items}">
        <c:choose>
            <c:when test="${fn:length(item.description) > 5000}">
                <c:set var="style" value="col3" />
            </c:when>
            <c:when test="${fn:length(item.description) > 2500}">
                <c:set var="style" value="col2" />
            </c:when>
            <c:otherwise>
                <c:set var="style" value="col1" />
            </c:otherwise>
        </c:choose>


        <div class="item ${style}">

            <a class="titleLink" data-fancybox-type="iframe" href="${item.link}">${item.title}</a>
            <div style="display: table-row; background-color: #f3f3f2">

                <div class="title">
                    <p class="pubDate"><fmt:formatDate value="${item.pubDate}" pattern="MM-dd-yyyy HH:mm"/> </p>
                </div>
                <div class="logo">
                    <c:choose>
                        <c:when test="${fn:length(item.channel.imageUrl) > 0}">
                            <a href="${item.channel.imageLink}"><img src="${item.channel.imageUrl}" alt="${item.channel.imageTitle}" width="70"></a>

                        </c:when>
                        <c:otherwise>
                            <a class="sourceLink" href="${item.channel.link}">${item.channel.title}</a>

                        </c:otherwise>
                    </c:choose>

                </div>

            </div>


            <div class="content">
                ${item.description}
            </div>
        </div>

    </c:forEach>
</div>
<div style="clear: both;">&nbsp;</div>