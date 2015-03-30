<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>sistech als</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="style.css"/>
	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
		$(function() {
			$( "#datepicker" ).datepicker();
		});
		$()function(){
			$('#timepicker').timepicker();
		});
	</script>
	
</head>
<body>
<div id="container"><center>
 <?php include "header.php"?>
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
	?>
	
	<form name="reminders" method="post" onsubmit=""
		action="writeReminder.php"> 
		<fieldset>
			<legend>New Reminder</legend>
			<p></p>Date:  <input type="text" id="datepicker" name="reminder_date"/><br/>
			<p></p>Time:  <input type="number" name="reminder_time" id="timepicker" size="6"/><br/>
			Reminder: <textarea name="reminder_text" id="reminder_text" rows="8" cols="30"></textarea><br/>
			<div id="lower">
				<input type="submit" class="submitreset" id="submit" name="submit" value="Sign In"/>
				<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
			</div> <!--lower-->
		</fieldset>
	</form> 

	</div> <!-- end blurbcontainerleft -->

	<div class="blurbcontainerright">
	 <div class="blurbheader"> Messages </div>
	<?php
	        $sql = "SELECT message_stream, message_type, s_uid, uid, message_number, image_message_path, typed_message_text, message_time, message_date
              FROM messages 
			  WHERE s_uid = 1 
			  AND uid = 1 
			  ORDER BY message_number ";
              
			  $result = $conn->query($sql);
              if ($result->num_rows > 0) {
                   // output data of each row
					while($row = $result->fetch_assoc()) {
						if($row["message_type"]=="I")
						{
							echo '<img src=' . $row['image_message_path'] . ' width="60" height="60" alt="word" />'. "<br><br>";
						}
						else
						{
							echo $row["typed_message_text"]. "<br><br>";
						}
					}
             } else {
                    echo "0 results";
                    }
   ?>
   

   
   <form name="message" method="post" onsubmit=""
		action="writeMessage.php"> 
		<fieldset>
			<legend>New Message</legend>
			Message: <textarea name="message_text" id="message_text" rows="8" cols="23"></textarea><br/>			
			<input type="submit" class="submitreset" id="submit" name="submit" value="Add Message"/>
			<input type="reset" class="submitreset" id ="reset" name="reset" value="Reset"/>
		</fieldset>
	</form> 
	
	<?php
		//close database
		$conn->close();
	?>
	</div>
            
  </div> <!-- content container -->
 </div></center> <!-- inner container -->
</div> <!-- container -->
</body>
</html>