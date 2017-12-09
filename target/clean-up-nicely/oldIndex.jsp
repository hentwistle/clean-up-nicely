<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
    <head><link href="css/signin.css" rel="stylesheet"></head>
    <body>
        <form action="/login" class="form-signin" method="post">
            <h2 class="form-signin-heading">Clean Up Nicely</h2>
            <div class="form-group">
                <label for="username" class="sr-only">User Name</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="User Name" required autofocus />
                <label for="password" class="sr-only">Password</label>
                <input type="password" class="form-control" id="password" name="password" aria-describedby="password" placeholder="Password" required />
            </div>
            <br />
            <br />
            <button type="submit" name="submit" value="signIn" class="btn btn-lg btn-primary btn-block">Sign In</button>
            <button type="submit" name="submit" value="signUp" class="btn btn-lg btn-primary btn-block">Sign Up</button>
    </body>
</html>