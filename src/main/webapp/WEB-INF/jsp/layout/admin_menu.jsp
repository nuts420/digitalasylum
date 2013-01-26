<style>
    .ui-menu { 
        width: 150px;
        position: relative;
        z-index: 1;
    }
    .ui-menu .ui-menu-item a {font-size: 12px;}
</style>

<ul id="menu">
    <li>
        <a href="/">Home</a>
    </li>
    <li>
        <a href="/admin/category">Categories</a>
        <ul>
            <li><a href="/admin/category">List</a></li>
            <li><a href="/admin/category/add">Add</a></li>
        </ul>
    </li>
    <li>
        <a href="/admin/post">Posts</a>
        <ul>
            <li><a href="/admin/post">List</a></li>
            <li><a href="/admin/post/add">Add</a></li>
        </ul>
    </li>
    <li><a href="/admin/feed">Feeds</a>
        <ul>
            <li><a href="/admin/feed">List</a></li>
            <li><a href="/admin/feed/add">Add</a></li>
        </ul>
    </li>
    <li><a href="/admin/channel">Channels</a></li>
    <li>
        <a href="/admin/item">Items</a>
    </li>
</ul>

<script>
    $(function() {
        $( "#menu" ).menu();
    });
</script>