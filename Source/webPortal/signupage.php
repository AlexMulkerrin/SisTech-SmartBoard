<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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
	<?php include "header.php"?>

	<div class="innercontainer">
	  <div class="contentcontainer">
	   <form name="signup" method="post" onsubmit=""
		action="index.php"> 
		<div class="blurbheaderright"> Sign-Up Here</div>
		<div align="right">
		
		<fieldset>
			<label for="firstname">First name:</label><input type="text" id="firstname" name="firstname"></br>
			<label for="surname">Surname:</label><input type="text" id="surname" name="surname"></br>
			<label for="username">Username:</label><input type="text" id="username" name="username"></br>
			<label for="password">Password:</label><input type="password" id="password" name="password"></br>
			<label for="password">Email:</label><input type="email" id="email" name="email"></br>
			<div id="lower">
				<input type="submit" class="submitreset" id="submit" name="submit" value="Sign Up"/>
				<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
			</div> <!--lower-->
		</fieldset>
	   </form> 
	   </div>
	   <?php include "footer.php"?>
	 </div> <!-- content container -->
	</div> <!-- innercontainer -->
	</div> <!-- container -->
</body>
</html>