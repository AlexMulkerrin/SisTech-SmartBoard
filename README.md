# SisTech-SmartBoard
Masters programming project

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
* a file called html_obsolete, guess we don't need that
* directory for the mySQL database code
* directory for the Smartboard prototype software
* directory for the webPortal code

##Usage

The Sistech smartboard interface can be used by downloading the prototype directory and running the Netbeans project file called Sistech inside. The proect requires the mysql libraries which are contained in the mysql-connector-java-5.0.8 On loading the project file Netbeans will report a missing library which is fixed by giving the path to the jar file in this directory.

The database files which can be seen in the directory are currently being hosted on the university server space. Currently our group as students do not have the access rights to upload images so only the tables of text are available to add to through the other parts of the system.

The webportal files are already hosted on the University webpages and can be accessed
[here](homepages.abdn.ac.uk/hilary.hastings.14/acsw).

## Known problems:

The uploading of handwritten messages as images is not available, ideally these would be stored on the server database so that they can be downloaded and shown on Smartboard and web portal. 

The database soetimes fails to return all the results of a query, the Smartboard rechecks the information every 30 seconds so waiting until the next poll should display the information correctly.

The interfaces of the Smartboard and webportal are designed only with the University lab machines in mind. Using a smaller resolution display may result in poor layout of the displays.

While a database table of network of support members and supported individuals exists it is not used within the Smartboard code at present. 

Can extra support network profiles be created? Only one at the moment.
