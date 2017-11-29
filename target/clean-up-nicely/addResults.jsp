<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#userTable').DataTable();
    } );
</script>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
                SUCCESS
            </thead>
            <tbody>

            </tbody>
        </table>
</div>

</body>
</html>
