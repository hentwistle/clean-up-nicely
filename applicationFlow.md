# Application Flow


### User Sign up

1. User chooses sign up on the menu.
1. User fills out the sign up form (first name, last name, username, email, password and submits.
1. Request goes to sign up servlet.
1. Servlet creates a user object and then creates user in the database.
1. Response to user confirming addition.

### User Sign In

1. User chooses sign in on the menu.
1. User enters username and password on form and submits. 
1. If user is authenticated, the server will handle allowing access to edit 
pages.  JDBCRealm used for authentication (users, users_roles, and roles table).
1. If authentication fails, show error message/page.

### View Main/Add Chores

1. Page sends a request to view chores servlet.
1. If data for this week has already been entered, chore dao performs select and it is pre-filled into the blanks.
1. Otherwise, form entries are blank.
1. If user changes something, dao performs insert/delete/change.
1. Google charts API shows pie chart of this week's split on the right.
1. Household dao uses select to list other members of the household.

### View Other Household Member

1. Based on which user is selected by the user, dao performs select and loads list of chores for that week.
1. If user clicks "Load more" button at bottom, dao will perform another select and lists of chores from previous weeks will be loaded.

### View Household
1. Google API displays two charts, one that shows the chore time split for this week, and one for all time.

## Join Household
1. Only available to second member of the household.
1. You can only join one household at once
1. Joining a new household will send a message to that household's owner asking to "confirm."
1. If confirmed, you are added. Otherwise, you remain in your own household.

### Confirm Other Household Member
1. Only available to the first member of the household.
1. Pops up after second+ user requests to join household. 
1. If owner confirms, second user is added to the household.

### About

1. Static page.
1. Contact info.
