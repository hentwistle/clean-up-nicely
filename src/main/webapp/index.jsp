<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
    <body>
        <h2>Clean Up Nicely</h2>

       <br />
        <form action="/login" class="form-inline">
            <div class="form-group">
                <label for="username">User Name</label>
                <input type="text" class="form-control" id="username" name="username" aria-describedby="username" />
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="password" />
            </div>
            <br />
            <br />
            <button type="submit" name="submit" value="signIn" class="btn btn-primary">Sign In</button>
            <button type="submit" name="submit" value="signUp" class="btn btn-primary">Sign Up</button>
    </body>
</html>