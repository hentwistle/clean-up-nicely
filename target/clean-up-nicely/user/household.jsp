
<%@include file="../taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="../head.jsp"%>

<head>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        // Load the Visualization API and the corechart package.
        google.charts.load('current', {'packages':['corechart']});

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Roommate');
            data.addColumn('number', 'Minutes');

            data.addRows([
                ['You', 30],
                ['Roommate 1', 40],
                ['Roommate 2', 50]
            ]);

            // Set chart options
            var options = {'title':'Chore Split For This Week',
                'width':500,
                'height':375};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
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
                <h3 class="cover-heading">Chores for Your Household</h3>
                <h4 class="cover-heading">${start_date} - ${end_date}</h4>
                <p class="lead">

                <!--Div that will hold the pie chart-->
                <div id="chart_div"></div>

            </main>

            <footer class="mastfoot">
                <div class="inner">
                    <p><a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>

                </div>
            </footer>

        </div>

    </div>

</div>

</body>
</html>