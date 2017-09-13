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
  * Google Charts or a similar Chart-based API to display data
* _____________ (independent research topic)
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
