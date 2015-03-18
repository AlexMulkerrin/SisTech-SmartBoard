<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
   <head>
  <style>
		div	{border-style:solid; border-width:1px;
			border-color:blue}
		div#blue_mountain {position:absolute;
			z-index:1;top:100px;left:100px}
		div#kopi_luwak {z-index:2;top:150px;lef:150px}
		div#kona {z-index:3;position:absolute;
			left:200px;top:200px}
	</style>
	 
</head>
<body>
	<div id="container">       
<form>
    <center><label for="username">Username:</label>
		<input type="text" id="username" name="username">
    <br></br>
<label for="password">Password:</label>
<input type="password" id="password" name="password">
<div id="lower">
<input type="checkbox"><label for="checkbox">Keep me logged in</label>
<input type="submit" value="Login">
</br>
<a href="signupage.php">
    <button type="button">Add profile</button></a></center>
</div><!--/ lower-->

</form>

</div>
	
</body>
</html>