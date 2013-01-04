<script>
    $(function() {
        $( "#menu" ).menu();
    });
</script>
<style>
    .ui-menu { width: 150px; }
    .ui-menu .ui-menu-item a {font-size: 12px;}
</style>

<ul id="menu">
    <li class="ui-state-disabled"><a href="#">Aberdeen</a></li>
    <li>
        <a href="/post">Posts</a>
        <ul>
            <li><a href="/post/add">Add</a></li>
        </ul>
    </li>
    <li><a href="/feed">Feeds</a>
        <ul>
            <li><a href="/feed/add">Add</a></li>
        </ul>
    </li>
    <li><a href="#">Addyston</a></li>
    <li>
        <a href="#">Delphi</a>
        <ul>
            <li class="ui-state-disabled"><a href="#">Ada</a></li>
            <li><a href="#">Saarland</a></li>
            <li><a href="#">Salzburg</a></li>
        </ul>
    </li>
</ul>