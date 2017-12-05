<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>


<script type="text/javascript" class="init">

    $(document).ready( function () {
        $('#dateTable').DataTable();
    } );

    $(document).ready( function () {
        $('#userTable').DataTable();
    } );

    $(document).ready( function () {
        $('#taskTable').DataTable();
    } );
</script>


<html><body>

<form action="/logout" class="form-inline" commandName="logout">
    <button type="submit" name="submit" value="logout" formaction="/logout" class="btn btn-primary">Log Out</button>
</form>


<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Clean Up Nicely</h2>

    <table id="dateTable" class="display" cellspacing="0" width="100%">

        <thead>
        <th>Week</th>
        </thead>
        <tbody>
        <tr>
            <td>${week.weekId} - ${week.startDate} - ${week.endDate}</td>
        </tr>
        </tbody>
    </table>

    <br /><br />


    <table id="userTable" class="display" cellspacing="0" width="100%">

        <thead>
        <th>Chores for ${housemate.userid} / ${housemate.username} / ${housemate.firstName} / ${housemate.lastName} / ${housemate.email}</th>
        </thead>
        <tbody>

        </tbody>
    </table>

    <br /><br />

        <table id="taskTable" class="display" cellspacing="0" width="100%">

            <thead>
            <th>Tasks</th>
            <th>Time</th>
            </thead>
            <tbody>
            <c:forEach var="log" items="${housemate_logs}" varStatus="loop">
                <tr>
                    <td>${tasks[loop.count - 1].taskName}</td>
                    <td>${log.minutes}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    <p></p>
    <p></p>
    <p></p>

</body>
</html>