<%@include file="../taglib.jsp"%>
<c:set var="title" value="Clean Up Nicely: Admin Results" />
<%@include file="../head.jsp"%>

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
                <th>User ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>First Name</th>
                <th>Last Name</th>
            </thead>
            <tbody>
                <c:forEach var="user" items="${users}">
                    <tr>
                        <td>${user.userid}</td>
                        <td>${user.username}</td>
                        <td>${user.email}</td>
                        <td>${user.password}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</div>

</body>
</html>
