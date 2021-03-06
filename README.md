# Heather Entwistle Individual Project: Clean Up Nicely 

### Problem Statement

It's a perennial problem for anyone who doesn't live alone: your roommate or spouse isn't pulling their weight with the household chores. Or are they? Clean Up Nicely is a web application that makes it easy to tell. Each member of the household can enter the time they're spending on common chores each week, and the app will let you track not only how your time spent cleaning stacks up against others, see which tasks you've been particularly good (or bad) at over time, and compare that to the rest of your household. With any luck, it'll inspire everyone to pick up the slack!


### Project Technologies/Techniques 

* Security/Authentication
   * Admin role: create/read/update/delete all data
   * First User in Household role: can approve subsequent users as members of their household
   * Any User role: can submit their own chore logs and view those of anyone in their household
 * Database (MySQL and Hibernate)
  * Store users and roles
  * Store chores and household information
* Web Services or APIs
  * Google Visualization with Google Charts or a similar Chart-based API to display data
* Bootstrap (independent research topic)
* Logging
  * Configurable logging using Log4J. In production, only errors will normally be logged, but logging at a debug level can be turned on to facilitate trouble-shooting. 
* Site and database hosted on AWS
* Unit Testing
  * JUnit tests to achieve 80% code coverage 

### Design

* Screen Design (see sheet)
* [Application Flow](applicationFlow.md)
* [Database Design](databaseDiagram.md)

### [Project Plan](ProjectPlan.md)

### [Time Log](TimeLog.md) 

### After:

### [AWS Link](http://52.15.105.22:8080/clean-up-nicely/)
  * Unfortunately I can't seem to get past the login windows. I was able to confirm that it was connected to my database, so I think it must have to do with my paths. I wish I had more time to check this out.
  
### [Video](https://youtu.be/T-6DaPtSVSo)

### [Code Coverage](code_coverage.png)