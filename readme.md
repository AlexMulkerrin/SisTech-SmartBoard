# SisTech-SmartBoard
Masters programming project for CS5563 (2014-15): Advanced Computer Science Workshop

The Assisted Living Smartboard prototype has been developed using a data-centric architecture. It has three components:
* Java application running on a wall-mounted touchscreen Client for the Supported Individual
* mySQL database to store user details, messages and reminders accessed by both Java Client and php web portal
* php web portal for the Network of Support

##Authors
Alexander Mulkerrin, Matthew Prinold, Hilary Hastings, Charles "Attah" Ademu and Taofik "Tunde." Mustapha

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
* directory for the webPortal php and mySQL code

## Deployment and Usage THIS NEEDS TO BE FINALISED AT DRY RUN (HH 29TH)
To deploy and use, you will need:
1.  a Java IDE (Netbeans or Eclipse) to run the Java Client 
2. a MySQL account
3. to publish the php web-pages 
4. to apply the workarounds 
1)
The Sistech smartboard interface can be used by downloading the prototype directory and running the Netbeans project file called Sistech inside. The proect requires the mysql libraries which are contained in the mysql-connector-java-5.0.8 On loading the project file Netbeans will report a missing library which is fixed by giving the path to the jar file in this directory.
2)
Access to the database requires a University MySQL account and specifically granted access privileges (email hilary.hastings.14@aberdeen.ac.uk if required).
3)
Source from the WebPortal directory are already hosted on the University webpages and can be accessed  at:
 homepages.abdn.ac.uk/hilary.hastings.14/acsw
or
published to your own University Homepages using 
homepages.abdn.ac.uk/local/publish 
script and entering your username and password. 
4a)
Due to the University web-publishing and sys-admin facilities for students, the uploading of handwritten messages as images is not straight through at present. Basically, the supported user writes their message on the Client screen. This is stored as a ".jpg" which is then displayed on the WebPortal Page. Under present University provisions for student produced web pages, all images have to be "published" before they will display on the WebPortal page. This just changes the permissions on them so they are available to the outside world e.g. our WebPortal page. We cannot run our Java Client as sys admin on the University Network  (workaround 1) and have been unable to secure some dedicated server space (workaround 2). Workaround 3 (Wizard of Oz): 
Use the University's homepages.abdn.ac.uk/local/publish script, enter username and password. This enables the image file containing the handwritten message to be displayed on the portal page over the web. 
This issue would not occur on a real-world server where we had full control of file/folder permissions and server space and so does not affect proof-of-concept or showcase prototype. 
4b)
The database sometimes fails to return all the results of a query, the Smartboard rechecks the information every 30 seconds so waiting until the next poll should display the information correctly. NEED TO SAY WHY TO SHOW IT DOESN'T MEAN IT'S NOT DOABLE

## Prototype Limitations
1)
The interfaces of the Smartboard and webportal are designed only with the University lab machines in mind. Whilst browser-independence has been tested on IE, Google and Firefox, using a smaller resolution display may result in poor layout of the displays.
2)
A database table of network of support members and supported individuals exists it is not fully used within the Smartboard code at present. 
3)
Only one support network profile exists at the moment and it is not necessary to login to see dashboard.
