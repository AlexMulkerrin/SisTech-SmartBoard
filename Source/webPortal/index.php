<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<!-- Initial HTML Code by Taofik Babtunde Mustapha. Converted to php and styled by Hilary Hastings, April 2015.
 code references www.stackexchange.com, www.w3c.schools.com -->

<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
	<title>sistech sign-in</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="SISTECHstyle.css"/>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>
	<div id="container"><center>
	<?php include "header.php" ?>
	
	 <div class="innercontainer">
	  <div class="contentcontainer">
	   

	   <form name="signin" method="post" onsubmit=""
		action="supportedindividualpage.php"> 
		<div class="blurbheaderright">Sign-In Here</div>
		<div align="right"><fieldset>
			<!-- form for username and password. Skeleton for prototype, no database writes at present -->
			<label for="username">Username:</label><input type="text" id="username" name="username"></br>
			<label for="password">Password:</label><input type="password" id="password" name="password"></br>
			<div id="lower">
			<input type="submit" class="submitreset" id="submit" name="submit" value="Sign In"/>
			<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
			</div> <!--lower-->
		</fieldset></div>
	   </form> 
	   <?php include "footer.php"?>
	  </div> <!-- content container -->

	
	 </div> <!-- inner container -->
	</center></div> <!-- container -->
	
</body>
</html>