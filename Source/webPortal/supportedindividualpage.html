<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
	<title>sistech als</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="style.css"/>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
    <form name="SendComments" action="mailto:myemail@mydomain.com&subject:form.subject&body=form.body method="get">
          
                              
    <textarea name="body" id="comment"></textarea><br/></form>  </br> 
    <input type="submit" name="submit" value="Send Message">
<div class="container">
 <div class="innercontainer">
  <div class="contentcontainer">
	<div class="blurbcontainerleft">
	<div class="blurbheader"> Reminders </div>
	<?php
		$servername = "mysql.abdn.ac.uk";
		$username = "t02hah14_sistech";
		$password = "sistech";
		$dbname = "t02hah14_sistech";
		$userid=1;
		$task_no=1;
		// Create connection and read tasks
		$conn = new mysqli($servername, $username, $password, $dbname);
		// Check connection
		if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
		}
		
		$sql = "SELECT rem_table_key, uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed FROM reminders
		WHERE s_uid =$userid AND reminder_task_completed =0
		ORDER BY reminder_date ASC , reminder_time_by ASC
		LIMIT 0 , 30";
		
		$result = $conn->query($sql);
		
		if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
		echo $task_no.". ".$row["reminder_time_by"]. " " . $row["reminder_text"]."<br>";
		$task_no+=1;
		}
		} else {
		echo "0 results";
		}
		$conn->close();
	?>
	</div>

	<div class="blurbcontainerright">
	 <div class="blurbheader"> Messages </div>
	<?php
		$servername = "mysql.abdn.ac.uk";
		$username = "t02hah14_sistech";
		$password = "sistech";
		$dbname = "t02hah14_sistech";
		$userid=1;
		$task_no=1;
		// Create connection and read tasks
		$conn = new mysqli($servername, $username, $password, $dbname);
		// Check connection
		if ($conn->connect_error) {
		die("Connection failed: " . $conn->connect_error);
		}
		$sql = "SELECT rem_table_key, uid, reminder_date, reminder_time_by, reminder_text, reminder_task_completed FROM reminders
		WHERE s_uid =$userid AND reminder_task_completed =0
		ORDER BY reminder_date ASC , reminder_time_by ASC
		LIMIT 0 , 30";
		$result = $conn->query($sql);
		if ($result->num_rows > 0) {
		// output data of each row
		while($row = $result->fetch_assoc()) {
		echo $task_no.". ".$row["reminder_time_by"]. " " . $row["reminder_text"]."<br>";
		}
		} else {
			echo "0 results";
			}
			$conn->close();
	?>
	</div>
  </div>
 </div>
</div>
</body>
</html>