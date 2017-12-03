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
        $('#logTable').DataTable();
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
        <th>Housemates for ${user.userid} / ${user.username} / ${user.firstName} / ${user.lastName} / ${user.email} with household ID ${household.householdId} and name ${household.householdName}</th>
        </thead>
        <tbody>
        <form name="housemates" action="/loadRoommateInfo">
        <c:forEach var="housemate" items="${housemates}" varStatus="status">
            <c:set var="${housemate.username}" value="${housemate.username}" scope="session" />
            <tr>
                <td> <a href="/loadRoommateInfo" id="${housemate.username}" value="${housemate.username}">${housemate.firstName} ${housemate.lastName}</a> - ${housemate.userid} / ${housemate.username} / ${housemate.firstName} / ${housemate.lastName} / ${housemate.email} </td>
            </tr>
        </c:forEach>
        </form>
        </tbody>
    </table>

    <br /><br />

    <table id="logTable" class="display" cellspacing="0" width="100%">

        <thead>
        <th>Logs
        </thead>
        <tbody>
        <c:forEach var="log" items="${logs}">
            <tr>
                <td> ${log.userId} / ${log.taskId} / ${log.weekId} / ${log.minutes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br /><br />

    <form action="/saveChores" class="form-inline" commandName="allTaskEdit">
    <table id="taskTable" class="display" cellspacing="0" width="100%">

        <thead>
        <th>Tasks</th>
        <th>Time</th>
        </thead>
        <tbody>
        <c:forEach var="log" items="${logs}" varStatus="loop">
            <tr>
                <td>${tasks[loop.count - 1].taskName}</td>
                <td><input type="text" class="form-control" id="${log.taskId}" name="${log.taskId}" value=${log.minutes} aria-describedby="task_time" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <button type="submit" name="submit" value="saveChores" class="btn btn-primary">Save Chores</button>
    </form>

    <p></p>
    <p></p>
    <p></p>

</body>
</html>