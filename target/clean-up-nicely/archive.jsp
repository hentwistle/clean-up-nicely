<%--
  Created by IntelliJ IDEA.
  User: Heather
  Date: 11/25/2017
  Time: 3:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="head.jsp"%>


<script type="text/javascript" class="init">

    $(document).ready( function () {
        $('#choreTable').DataTable();
    } );
</script>


<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Clean Up Nicely</h2>


    <table id="choreTable" class="display" cellspacing="0" width="100%">

        <thead>
        <th>Logs</th>
        </thead>
        <tbody>
        <c:forEach var="week" items="${weeks}">
            <tr>
                <td><h2> ${week.startDate} - ${week.endDate}</h2></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br /><br />

</body>
</html>
