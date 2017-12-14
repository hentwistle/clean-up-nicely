<%@include file="../taglib.jsp"%>
<c:set var="title" value="Clean Up Nicely: Chore Results" />
<%@include file="../head.jsp"%>

<script type="text/javascript" class="init">
    $(document).ready( function () {
        $('#taskTable').DataTable();
    } );
</script>

<html>
<head>
    <link href="../css/cover.css" rel="stylesheet">
</head>
<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <header class="masthead clearfix">
                <div class="inner">
                    <h2 class="masthead-brand">Clean Up Nicely</h2>
                    <br />
                    <nav class="nav nav-masthead">
                        <a class="nav-link" href="main.jsp">Home</a> |
                        <div class="dropdown div-inline">
                            <a class="dropdown-toggle nav-link active" type="button" id="dropdownMenu1" data-toggle="dropdown">Housemates <span class="caret"></span> </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                <c:forEach var="housemate" items="${housemates}">
                                    <tr>

                                        <c:url value="/user/loadRoommateInfo" var="url" scope="request">
                                            <c:param name="housemate" value="${housemate.username}"/>

                                        </c:url>
                                        <li role="presentation"><a role="menuitem" tabindex="-1" href="${requestScope.url}" id="${housemate.username}" value="${housemate.username}">${housemate.firstName} ${housemate.lastName}</a></li>
                                    </tr>
                                </c:forEach>
                            </ul>
                        </div>
                        | <a class="nav-link" href="household.jsp">Household</a>
                    </nav>
                </div>
            </header>

            <main role="main" class="inner cover">
                <h3 class="cover-heading">You just updated chores for: </h3>
                <h4 class="cover-heading">${start_date} - ${end_date}</h4>
                <p class="lead">

                <table id="taskTable" class="display" cellspacing="0" width="100%">

                    <thead>
                    <th>Tasks</th>
                    <th>Time</th>
                    </thead>
                    <tbody>
                    <c:forEach var="log" items="${logs}" varStatus="loop">
                        <tr>
                            <td>${tasks[loop.count - 1].taskName}</td>
                            <td>${log.minutes}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </main>

            <footer class="mastfoot">
                <div class="inner">
                    <p><a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
`

                </div>
            </footer>

        </div>

    </div>

</div>

</body>
</html>