
<%@include file="../taglib.jsp"%>
<c:set var="title" value="Search Results" />
<%@include file="../head.jsp"%>

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

                </div>
            </header>

            <main role="main" class="inner cover">
                <h3 class="cover-heading">Admin</h3>
                <p class="lead">

                <h3>Add User</h3>
                <br />
                <form action="update" class="form-inline" method="post">
                    <div class="form-group">
                        <label for="user_name">User Name</label><br />
                        <input type="text" class="form-control" id="user_name" name="user_name" aria-describedby="user_name" /><br />
                        <label for="email" > Email </label><br />
                        <input type="email" class="form-control" id="email" name="email" aria-describedby="email" /><br />
                        <label for="password">Password</label><br />
                        <input type="password" class="form-control" id="password" name="password" aria-describedby="password" /><br />
                        <label for="first_name">First Name</label><br />
                        <input type="text" class="form-control" id="first_name" name="first_name" aria-describedby="first_name" /><br />
                        <label for="last_name">Last Name</label><br />
                        <input type="text" class="form-control" id="last_name" name="last_name" aria-describedby="last_name" /><br /><br />


                        <button type="submit" name="submit" value="add" class="btn btn-primary">Add User</button>
                    </div>

                </form>
                <br />
                <h3>Delete User</h3>
                <br />
                <form action="update" class="form-inline" method="post">
                    <div class="form-group">
                        Select username to update:
                        <br />
                        <label for="user_id_delete">Username</label><br />
                        <input type="text" class="form-control" id="user_id_delete" name="user_id_delete" aria-describedby="user_id_delete" /><br /><br />

                    <button type="submit" name="submit" value="delete" class="btn btn-primary">Delete User</button>
                    </div>

                </form>

                <br />
                <h3>Update User</h3>
                <br />
                <form action="update" class="form-inline" method="post">
                    <div class="form-group">
                        Select username to update:
                        <br />
                        <label for="user_name_update">Username</label><br />
                        <input type="text" class="form-control" id="user_name_update" name="user_name_update" aria-describedby="user_name_update" /><br/>
                        <label for="first_name_update">Update First Name</label><br />
                        <input type="text" class="form-control" id="first_name_update" name="first_name_update" aria-describedby="first_name_update" /><br />
                        <label for="last_name_update">Update Last Name</label><br />
                        <input type="text" class="form-control" id="last_name_update" name="last_name_update" aria-describedby="last_name_update" /><br />
                        <label for="password_update">Update Password</label><br />
                        <input type="password" class="form-control" id="password_update" name="password_update" aria-describedby="password_update" /><br />
                        <label for="email_update">Update Email</label><br />
                        <input type="email" class="form-control" id="email_update" name="email_update" aria-describedby="email_update" /><br />
                    <br />
                    <button type="submit" name="submit" value="update" class="btn btn-primary">Update User</button>
                    </div>

                </form>


                <br />
                <h3>Show Users</h3>
                <br />
                <form action="update" class="form-inline" method="post">
                    <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
                </form>
                </p>



            </main>

            <footer class="mastfoot">
                <div class="inner">
                    <p><a href="https://getbootstrap.com/">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>

                    <form action="../logout" class="form-inline"  method="post">
                        <button type="submit" name="submit" value="logout" class="btn btn-lg btn-secondary" id="btn-logout">Log Out</button>
                    </form>

                </div>
            </footer>

        </div>

    </div>

</div>

</body>
</html>