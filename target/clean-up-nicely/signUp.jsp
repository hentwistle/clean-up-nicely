<%@include file="taglib.jsp"%>
<c:set var="title" value="User Search Home Page" />
<%@include file="head.jsp"%>
<html>
<head><link href="css/signin.css" rel="stylesheet"></head>
<body>
<form action="addUser" class="form-signin" method="post">
    <h2 class="form-signin-heading">Clean Up Nicely</h2>
    <label class="form-group">
        <label for="username" class="sr-only">User Name</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="User Name" required autofocus />
        <label for="password" class="sr-only">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password" required />
        <label for="email" class="sr-only">Email</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Email" required />
        <label for="first_name" class="sr-only">First Name</label>
        <input type="text" class="form-control" id="first_name" name="first_name" placeholder="First Name" required />
        <label for="last_name" class="sr-only">Last Name</label>
        <input type="text" class="form-control" id="last_name" name="last_name" placeholder="Last Name" required />

        <br />

        <h4>Household</h4>

        <input type="radio" name="household" id="new" value="new" class="form-control" checked><label for="new" class=""sr-only></label> New Household</label><br />

        If you entered "new," enter a nickname for your new household (optional):
        <input type="text" class="form-control" id="household_name" name="household_name" placeholder="Household Nickname" />
        <br />
        <input type="radio" name="household" id="existing" value="existing" class="form-control"><label for="existing" class=""sr-only></label>Existing Household</label><br />

        If you entered "existing," enter the username of a member of the house you'd like to join:
        <input type="text" class="form-control" id="housemate_name" name="housemate_name" placeholder="Housemate Username" />
    </div>
    <br />
    <br />
    <button type="submit" name="submit" value="add" class="btn btn-lg btn-primary btn-block">Sign Up</button>
</form>
</body>
</html>