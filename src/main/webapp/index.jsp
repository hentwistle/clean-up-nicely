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
            <button type="submit" name="submit" value="add" class="btn btn-primary">Add</button>

        </form>
        <br />
        <h3>Update or Delete User</h3>
        <br />
            <form action="/updateUser" class="form-inline">
                <div class="form-group">
                    <label for="user_id_update">Enter User ID to Update</label>
                    <input type="text" class="form-control" id="user_id_update" name="user_id_update" aria-describedby="user_id_update" />
                    <label for="first_name_update">Update First Name</label>
                    <input type="text" class="form-control" id="first_name_update" name="first_name_update" aria-describedby="first_name_update" />
                    <label for="last_name_update">Update Last Name</label>
                    <input type="text" class="form-control" id="last_name_update" name="last_name_update" aria-describedby="last_name_update" />
                </div>
                <button type="submit" name="submit" value="update" class="btn btn-primary">Update Name</button>
                <button type="submit" name="submit" value="delete" class="btn btn-primary">Delete User</button>

            </form>
        <br />
        <h3>Show Users</h3>
        <br />
        <form action="/searchUser" class="form-inline">
            <button type="submit" name="submit" value="viewAll" class="btn btn-primary">View All Users</button>
        </form>
    </body>
</html>