<%@include file="taglib.jsp"%>
<c:set var="title" value="Household Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#choreTable').DataTable();
    } );

</script>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="choreTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>User ID</th>
        <th>Week ID</th>
        <th>Task ID</th>
        <th>Minutes</th>
        </thead>
        <tbody>
        <c:forEach var="chore" items="${chores}">
            <tr>
                <td>${chore.userId}</td>
                <td>${chore.weekId}</td>
                <td>${chore.taskId}</td>
                <td>${chore.minutes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>