<%@include file="taglib.jsp"%>
<c:set var="title" value="Household Search Results" />
<%@include file="head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#householdTable').DataTable();
    } );

</script>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>
    <table id="householdTable" class="display" cellspacing="0" width="100%">
        <thead>
        <th>Household ID</th>
        <th>Household Name</th>
        </thead>
        <tbody>
        <c:forEach var="household" items="${households}">
            <tr>
                <td>${household.householdId}</td>
                <td>${household.householdName}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>