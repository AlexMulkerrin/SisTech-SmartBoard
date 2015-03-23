<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
	<title>sistech sign-in</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="style.css"/>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>

<body>
	<div id="container">       

	<?php include "header.php" ?>
	
	 <div class="innercontainer">
	  <div class="contentcontainer">
	   

	   <center><form name="reminders" method="post" onsubmit=""
		action="supportedindividualpage.php"> 
		<div class="blurbheader"> Sign-In </div>
		<fieldset>
			<label for="username">Username:</label><input type="text" id="username" name="username"></br>
			<label for="password">Password:</label><input type="password" id="password" name="password"></br>
			<div id="lower">
			<input type="submit" class="submitreset" id="submit" name="submit" value="Sign In"/>
			<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
			</div> <!--lower-->
		</fieldset>
	</form> 
	
	  </div> <!-- content container -->
	 </div> <!-- inner container -->
	</div> <!-- container -->
	
</body>
</html>