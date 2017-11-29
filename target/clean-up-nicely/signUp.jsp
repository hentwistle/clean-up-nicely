<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
    <body>
        <h2>Clean Up Nicely</h2>

        <h3>Add User</h3>
       <br />
        <form action="/addUser" class="form-inline">
            <div class="form-group">
                <label for="user_name">User Name</label>
                <input type="text" class="form-control" id="user_name" name="user_name" aria-describedby="user_name" />
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email" aria-describedby="email" />
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="password" />
                <label for="first_name">First Name</label>
                <input type="text" class="form-control" id="first_name" name="first_name" aria-describedby="first_name" />
                <label for="last_name">Last Name</label>
                <input type="text" class="form-control" id="last_name" name="last_name" aria-describedby="last_name" />
            </div>
            <button type="submit" name="submit" value="add" class="btn btn-primary">Join</button>
    </body>
</html>