# SisTech-SmartBoard
Masters programming project for CS5563 (2014-15): Advanced Computer Science Workshop

The Assisted Living Smartboard prototype has been developed using a data-centric architecture. It has three components:
* Java application running on a wall-mounted touchscreen for the Supported Individual
* database 
* web portal for the Network of Support

##Authors
Alex, Matthew, Hillary, Attah and Tunde.

##Files in Repository

Documentation containing: 
* Database
* First Requirements
* initial database definition
* group presentation
* group whitepaper

Screenshots containing:
* screen capture of web portal dashboard
* web sign in page
* web sign up page
* Smartboard interface
* updated Smartboard interface

Source containing:
* directory for the mySQL database code
* directory for the Smartboard prototype software
* directory for the webPortal code
* ignore the directory called html_obsolete, old code

##Usage

The Sistech smartboard interface can be used by downloading the prototype directory and running the Netbeans project file called Sistech inside. The proect requires the mysql libraries which are contained in the mysql-connector-java-5.0.8 On loading the project file Netbeans will report a missing library which is fixed by giving the path to the jar file in this directory.

The database files which can be seen in the directory are currently being hosted on the university server space. Currently our group as students do not have the access rights to upload images so only the tables of text are available to add to through the other parts of the system.

The webportal files are already hosted on the University webpages and can be accessed
[here](homepages.abdn.ac.uk/hilary.hastings.14/acsw).

## Known problems

The uploading of handwritten messages as images is not available, ideally these would be stored on the server database so that they can be downloaded and shown on Smartboard and web portal. 

The database sometimes fails to return all the results of a query, the Smartboard rechecks the information every 30 seconds so waiting until the next poll should display the information correctly.

The interfaces of the Smartboard and webportal are designed only with the University lab machines in mind. Using a smaller resolution display may result in poor layout of the displays.

While a database table of network of support members and supported individuals exists it is not used within the Smartboard code at present. 

Only one support network profile exists at the moment and it is not necessary to login to see dashboard.
